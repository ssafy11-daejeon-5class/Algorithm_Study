package hw._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 적록색약 {
	static int n;
	static char[][] board;
	static int[][] visited1;
	static int[][] visited2;	
	static int p1,p2;
	static Queue<Pair> q = new ArrayDeque<>();
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		n=Integer.parseInt(br.readLine());
		board = new char[n][n];
		visited1 = new int[n][n];
		visited2 = new int[n][n];		
		
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<n;j++)
			{
				board[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(visited1[i][j]==0)bfs1(i,j,board[i][j]);
				if(visited2[i][j]==0)bfs2(i,j,board[i][j]);
			}
		}
		System.out.println(p1 +" "+p2);

	}
	
	public static void bfs1(int x, int y, char target)
	{
		q.offer(new Pair(x,y));
		visited1[x][y]=1;
		p1++;
		while(!q.isEmpty())
		{
			int curx = q.peek().x;
			int cury = q.peek().y;
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx=curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(visited1[nx][ny]==1 || board[nx][ny]!=target)continue;
				q.offer(new Pair(nx,ny));
				visited1[nx][ny]=1;
			}
		}
	}
	//R,G
	public static void bfs2(int x, int y, char target)
	{
		q.offer(new Pair(x,y));
		visited2[x][y]=1;
		p2++;
		while(!q.isEmpty())
		{
			int curx = q.peek().x;
			int cury = q.peek().y;
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx=curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(target =='R' || target =='G')
				{
					if(visited2[nx][ny]==1 || board[nx][ny]=='B')continue;
				}
				else
				{
					if(visited2[nx][ny]==1 || board[nx][ny]!=target)continue;	
				}
				q.offer(new Pair(nx,ny));
				visited2[nx][ny]=1;
			}
		}
	}
	public static void print()
	{
		for (int i = 0; i < board.length; i++) {
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
	}

}
