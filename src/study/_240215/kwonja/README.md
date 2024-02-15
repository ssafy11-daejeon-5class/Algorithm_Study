# 아기상어

---

나름 호흡이 있는 문제라고 생각한다.

이런문제일수록 기능을 분리해보는게 좋은것 같다

### 전역변수

```jsx
static int[][] board;
	static int[][] visitied;
	static int n;
	static int sharksize=2;
	static Pair sharklocation;
	static int time;
	static int eatcount=0;
	static int[] dx= {-1,0,0,1};
	static int[] dy= {0,-1,1,0};
	static Queue<Pair> q = new ArrayDeque<>();
	static PriorityQueue<Pair> pq = new PriorityQueue<>(new Custom()); //어떤 먹이를 먼저 먹을 것인가
```

### 처음 물고기와 상어의 상황을 배열에 대입

```jsx
    board=new int[n][n];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==9)sharklocation= new Pair(i,j);
			}
		}
```

## 상어는 현재 위치에서 먹을수 있는 물고기를 찾아야한다

### 먹을수 있는 물고기 찾기
.

```jsx
public static void bfs()
	{
		q.offer(sharklocation); //현재 상어위치에서 출발~
		visitied[sharklocation.getX()][sharklocation.getY()]=1;
		
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury = q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx = curx + dx[i];
				int ny = cury+ dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(board[nx][ny]>sharksize || visitied[nx][ny]>0)continue;
				//먹이를 먹을때를 판단해야한다
				
				//먹이를 먹을 수 있을때 
				if(board[nx][ny]>0 && board[nx][ny]<sharksize)
				{
					//처음 마주했을때를 다시 넣어준다
					q.offer(new Pair(curx,cury));
					//다음이동이 물고기일때가 가장 짧은 경로 이동이다.
					setFish(visitied[curx][cury]);
					break;
				}				
				visitied[nx][ny]= visitied[curx][cury]+1;
				q.offer(new Pair(nx,ny));
			}
		}
	}
```

bfs는 가장 짧은거리를 구할수 있다 → 

bfs를 탐색하면서 물고리를 탐색하면 해당 탐색거리가 가장 짧다는 의미이다

그러면 가장 짧게 탐색한 거리를 기억하고 해당 거리와 똑같이 이동한 곳중 물고기를 먹을수 있다면

모두 먹는다

### 같은 거리에 있는 물고기 모두 먹기

```jsx
public static void setFish(int dist)
	{
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury = q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx = curx + dx[i];
				int ny = cury+ dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(board[nx][ny]>=sharksize || visitied[nx][ny]>0)continue;
				//다음 이동이 먹이를 먹을때 가장 짧은 거리여야한다.
				if(board[nx][ny]>0 && board[nx][ny]<sharksize && visitied[curx][cury]==dist)
				{
//					System.out.println(nx + " "+ ny +" 선택");
					visitied[nx][ny]=visitied[curx][cury]+1; //혹시 겹쳐서 두번 들어갈까봐 방문처리
					pq.offer(new Pair(nx,ny));
				}
			}
		}
	}
```

### 같은 거리에 물고기중에 조건을 만족하는 친구를 먹어야한다

- 우선순위큐에 먹을 수 있는 물고기들을 넣고 정렬

```jsx
static class Custom implements Comparator<Pair>
	{

		@Override
		public int compare(Pair o1, Pair o2) {
			if(o1.getX() == o2.getX())
			{
				return o1.getY()-o2.getY();
			}
			//x가 작은게 맨위에 있는것이다.
			return o1.getX()-o2.getX();
			
		}
		
	}
```

### 물고기를 먹는다.

```jsx
public static Pair sharkEat()
	{
		//큐가 비어있으면 먹을수 있는 물고기가 없다는 의미이다.
		if(pq.isEmpty())return null;
		//먹을수 있는 물고기가 있다면
		eatcount++;
		if(eatcount==sharksize)
		{
			sharksize++;
			eatcount=0;
		}
		board[sharklocation.getX()][sharklocation.getY()]=0; //기존 상어는 자리를 옮김
		return pq.poll();
	}
```

먹을 물고기가 있다면 해당 물고기좌표를 반환→ 상어를 그 위치로 옮기기 위함이다

```jsx
while(true)
		{
			pq = new PriorityQueue<>(new Custom());
			q = new ArrayDeque<>();
			visitied=new int[n][n];
			bfs();

			sharklocation = sharkEat();
			if(sharklocation==null)break;
			board[sharklocation.getX()][sharklocation.getY()]=9;

			time+=(visitied[sharklocation.getX()][sharklocation.getY()]-1);

		}
		
		System.out.println(time);
```

- bfs를 통해 물고기를 탐색하고 setfish를 통해 물고기를 담는다
- sharkeat를 통해 물고기를 먹는다
    - 물고기를 먹었다면 상어를 물고기좌표로 옮기고 원래 상어위치는 0으로 초기화 해준다
        - 상어가 등치가 커져서 본인도 먹어버릴수 있지않을까 해서 초기화
    - 먹을 물고기가 없다면 종료
- 시간은 상어가 물고기를 먹었을때의 거리를 더해줬기때문에 상어가 먹었을때 더해줌