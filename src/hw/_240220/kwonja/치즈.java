package hw._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치즈 {
	static int n,m;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int[][] board;
	static int[][] visited;
	static int time=2;
	static int cnt;
	static Queue<Pair> q = new ArrayDeque<>();
	static List<Pair> cheese = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new int[n][m];
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==1)cheese.add(new Pair(i,j));
			}
		}
		//치즈가 언제 떨어질지 모른다 -> while문을 사용
		while(true)
		{
			//치즈를 모두 먹으면
			if(cheese.size()==0)break;
			for(int i=0;i<n;i++)
			{
				if(i==0 || i==n-1)
				{
					for(int j=0;j<m;j++)
					{
						if(board[i][j]!=1 && visited[i][j]==0)
						{
							bfs(i,j);
						}
					}
				}
				else
				{
					if(board[i][0]!=1 && visited[i][0]==0)
					{
						bfs(i,0);
					}
					if(board[i][m-1]!=1 && visited[i][m-1]==0)
					{
						bfs(i,m-1);
					}
				}
			}
			//1시간후 없어질것을 탐색
//			print();
//			System.out.println();
			time++;
			visited = new int[n][m];//방문 초기화
		}
		System.out.println(time-2);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(board[i][j]==time-1)cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}
	public static void bfs(int x ,int y)
	{
		q.offer(new Pair(x,y));
		visited[x][y]=1;
		
		while(!q.isEmpty())
		{
			int curx = q.peek().x;
			int cury = q.peek().y;
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx= curx+dx[i];
				int ny =cury +dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=m)continue; //사실 나갈일은 없긴함
				if(visited[nx][ny]==1)continue;
				if(board[nx][ny]==1)
				{
					board[nx][ny]=time;//부식되야하는 치즈
					visited[nx][ny]=1;
					for(int h=0;h<cheese.size();h++)
					{
						Pair p = cheese.get(h);
						if(p.x == nx && p.y == ny)
						{
							cheese.remove(h);
							break; //해당좌표의 치즈는 1개다
						}
					}
					
				}
				else
				{
					q.offer(new Pair(nx,ny));
					visited[nx][ny]=1;
				}
				
			}
		}
	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
	}

}
