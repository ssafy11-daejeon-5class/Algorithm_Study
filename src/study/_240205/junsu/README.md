# 인구 이동 💨
- 호흡이 매우 길었던 문제
- 구현에 탐색을 곁들인 문제
- 어찌보면 사과 먹기 문제와 유사한듯?
- 이러한 유형에 익숙해짐으로써 문제에 대한 집중력 연습과 체력을 늘리는 것이 중요할 것 같음
- 한 문제를 Sequential한 여러 단계로 나누기
### Main Method
```java
  public static void main(String[] args) throws IOException {
  		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  		st = new StringTokenizer(br.readLine());
  		N = Integer.parseInt(st.nextToken());
  		L = Integer.parseInt(st.nextToken());
  		R = Integer.parseInt(st.nextToken());
  		maps = new int[N][N];
  
  		for (int i = 0; i < N; i++) {
  			st = new StringTokenizer(br.readLine());
  			for (int j = 0; j < N; j++) {
  				maps[i][j] = Integer.parseInt(st.nextToken());
  			}
  		}
  
  		System.out.println(move());
  
  	}
```

### move Method

``` java
private static int move() {
		int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); //bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        if(list.size() > 1) {
                            changePopulation(sum); //열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
	}
 ```

### 인구수 업데이트 및 BFS 코드

```java
private static void changePopulation(int sum) {
		int avg = sum / list.size();
		while(!list.isEmpty()){
			Node temp = list.poll();
			maps[temp.i][temp.j] = avg;
		}
	}

	private static int bfs(int i, int j) {
		Queue<Node> q = new ArrayDeque<>();
		list = new ArrayDeque<>();

		q.offer(new Node(i,j));
		list.add(new Node(i, j));
		visited[i][j] = true;

		int sum = maps[i][j];
		while(!q.isEmpty()){
			Node current = q.poll();

			for(int k = 0 ; k < 4 ; k++){
				int ni = current.i + di[k];
				int nj = current.j + dj[k];

				if(ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]){
					int diff = Math.abs(maps[current.i][current.j] - maps[ni][nj]);
                    if(L <= diff && diff <= R) {
                        q.offer(new Node(ni, nj));
                        list.offer(new Node(ni, nj));
                        sum += maps[ni][nj];
                        visited[ni][nj] = true;
                    }     
				}
			}
		}
		return sum;
	}
 ```
