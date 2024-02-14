package study._240215.kwonja;

import java.io.*;
import java.util.*;

public class BOJ_16236 {
	/*
	 * 아기상어
	 * 정렬을 잘하자...... getX 함수 바꿔야할듯
	 * 아기상어는 개수에 따라 크기가 커진다
	 * 디버깅시간이 한참걸렸네ㅠㅠ
	 */
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
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		n=Integer.parseInt(br.readLine());
		
		board=new int[n][n];
		visitied=new int[n][n];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==9)sharklocation= new Pair(i,j);
			}
		}
		
		while(true)
		{
			pq = new PriorityQueue<>(new Custom());
			q = new ArrayDeque<>();
			visitied=new int[n][n];
			bfs();
//			System.out.println(sharklocation.getX() + " " + sharklocation.getY());
			sharklocation = sharkEat();
			if(sharklocation==null)break;
			board[sharklocation.getX()][sharklocation.getY()]=9;
//			print();
			time+=(visitied[sharklocation.getX()][sharklocation.getY()]-1);
//			System.out.println(time);
		}
		
		System.out.println(time);
		
	}
	//상어가 물고기를 찾는다
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
					visitied[nx][ny]=visitied[curx][cury]+1;
					pq.offer(new Pair(nx,ny));
				}
			}
		}
	}
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
	
	
	
	
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
	}

}
