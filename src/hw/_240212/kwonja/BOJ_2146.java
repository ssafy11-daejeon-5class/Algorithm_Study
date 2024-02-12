package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2146 {
	/*
	 * 다리만들기
	 * BFS를 사용해 물감처럼 퍼져나가는것을 통해 완전탐색
	 * q가 2번들어가는데 q를 set처럼 사용할수 있는 방법이없나? ㅠㅠ
	 */
	static int n;
	static int[][] board;
	static int[][] visitied;
	static int[][] seevisitied;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static Queue<Pair> q = new ArrayDeque<>();
	static Queue<Pair> seeq = new ArrayDeque<>();
	static int bridge = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	n=Integer.parseInt(br.readLine());
	board= new int[n][n];
	visitied = new int[n][n];
	seevisitied = new int[n][n];
	
	for(int i=0;i<n;i++)
	{
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<n;j++)
		{
			board[i][j]=Integer.parseInt(st.nextToken());
		}
	}
//	for(int i=0;i<n;i++)
//	{
//		for(int j=0;j<n;j++)
//		{
//			System.out.print(board[i][j]);
//		}
//		System.out.println();
//	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(board[i][j]==1 && visitied[i][j]==0)
			{
				seeq = new ArrayDeque<>();
				seevisitied = new int[n][n];
//				System.out.println("start" + i + " "+ j);
				bfs(i,j);				
				seeBfs();
			}
		}
	}
	System.out.println(bridge);
	}
	//섬중에 바다와 연결되어 있는 가장자리 찾기
	private static void bfs(int x, int y) {

		q.offer(new Pair(x,y));
		visitied[x][y]=1;
		
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury = q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx=curx+dx[i];
				int ny =cury+dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(visitied[nx][ny]>0)continue;
				//바다라면
				if(board[nx][ny]==0 && seevisitied[curx][cury]==0) //가장자리를 방문하지 않았다면 //중복체크로 20ms 단축 N이 크지 않아서 큰 차이를 보이지는 않는듯
				{
					//가장자리 탐색
					seeq.offer(new Pair(curx,cury));
					seevisitied[curx][cury]=1;
					//가장자리가 여러개일경우 중복값으로 들어오게되는데 어떻게 해결할 것인가
					//
				}
				if(board[nx][ny]==0)continue;
				q.offer(new Pair(nx,ny));
				visitied[nx][ny]=1;
			}
		}
	}
	//가장자리로 부터 바다를 탐색하며 1을 만났을때 종료
	public static void seeBfs()
	{
		while(!seeq.isEmpty())
		{
			int curx = seeq.peek().getX();
			int cury = seeq.peek().getY();
			seeq.poll();
			for(int i=0;i<4;i++)
			{
				int nx=curx+dx[i];
				int ny =cury+dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				//가장자리에서 시작할때 자기 육지를 선택하는 경우를 제외
				if(visitied[nx][ny]>0)continue;
				//방문한 바다라면
				if(seevisitied[nx][ny]>0)continue;
				//육지를 방문했다면
				if(board[nx][ny]==1)
				{
//					System.out.println(nx + " " + ny + " "+ seevisitied[curx][cury]);
					bridge= Math.min(bridge, seevisitied[curx][cury]-1);
					return ;
				}
				seeq.offer(new Pair(nx,ny));
				seevisitied[nx][ny]=seevisitied[curx][cury]+1;
			}
		}
	}

}
