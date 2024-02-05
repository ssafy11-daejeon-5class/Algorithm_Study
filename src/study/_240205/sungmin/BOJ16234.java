package study._240205.sungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	static int n;
	static Queue<Pair> q;
	static Queue<Pair> q1=new LinkedList<>();
	static int[][] board;
	static int[][] visited;
	static int l;
	static int r;
	static int sum;
	static int place;
	static int move=-1;
	static int check=1;
	static int seq;
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		l= Integer.parseInt(st.nextToken());
		r= Integer.parseInt(st.nextToken());
		
		board=new int[n][n];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(check==1)
		{
			visited=new int[n][n];
			move++;
			check=0;
			for(int[] s : board)
			{
				System.out.println(Arrays.toString(s));				
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(visited[i][j]==0)
					{
						place=0;
						sum=0; 
						q=new LinkedList<Pair>();
						bfs(i,j,++seq);
						
						//인구수 나누기
						divide();
						
					}
				}
			}
			if(check==0) break; //인구이동x
		}
		System.out.print(move);
		
		
	}
	public static void divide()
	{
		while(!q1.isEmpty())
		{
			board[q1.peek().getX()][q1.peek().getY()]=sum/place;
			q1.poll();
		}
	}
	public static void bfs(int x,int y,int time)
	{
		q.offer(new Pair(x,y));
		q1.offer(new Pair(x,y));
		visited[x][y]=1;
		sum += board[x][y];
		place=1;
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury = q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
			
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(visited[nx][ny]>0)continue;
				//L명이상 R명이하일때 관문을 연다
				if(Math.abs(board[curx][cury]-board[nx][ny])<=r && Math.abs(board[curx][cury]-board[nx][ny])>=l)
				{
					
					q.offer(new Pair(nx,ny));
					q1.offer(new Pair(nx,ny));
					visited[nx][ny]=time;
					place++;
					sum += board[nx][ny];
					check=1; //인구이동 발생
				}
			}
		}
	}

}



class Pair{
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
