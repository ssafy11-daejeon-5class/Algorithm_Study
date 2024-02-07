package hw._240207.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935 {

	/*
	 * 배열돌리기 3
	 * 배열을 돌려보자!
	 */
	static int n,m,r;
	static int[] dx = new int[]{0,1,0,-1};
	static int[] dy = new int[]{1,0,-1,0};
	static int[] dx2 = new int[]{1,0,-1,0};
	static int[] dy2 = new int[]{0,1,0,-1};
	static boolean[][] visitied;
	static int[] dx3 = new int[]{1,0,-1,0};
	static int[] dy3 = new int[]{0,-1,0,1};
	static int[] dx4 = new int[]{0,-1,0,1};
	static int[] dy4 = new int[]{1,0,-1,0};
	static int[][] board;
	static int[][] Newboard;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		board=new int[n][m];
		Newboard=new int[n][m];
		
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<r;i++)
		{
			visitied = new boolean[n][m];
			Newboard= new int[n][m];
			int c = Integer.parseInt(st.nextToken());
			switch (c) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				Newboard=new int[m][n];
				func3(0,-1,-1,n-1);
				int tmp=m;
				m=n;
				n=tmp;
				break;
			case 4:
				Newboard=new int[m][n];
				func4(-1,0,m-1,-1);
				int tmp1=m;
				m=n;
				n=tmp1;
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
			}
			board = new int[n][m];
			for(int j=0;j<n;j++)
			{
				for(int h=0;h<m;h++)
				{
					board[j][h]=Newboard[j][h];
				}
			}
		}
		print();
			
		
	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(board[i][j] +" ");
			}
			System.out.print("\n");
		}
	}
	public static void func1()
	{
		int start=n/2 -1;
		int end=n/2;
		
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m;j++)
			{
				Newboard[start][j]=board[end][j];
				Newboard[end][j]=board[start][j];
			}
			start--;
			end++;
		}
		
	}
	public static void func2()
	{
		int start=m/2 -1;
		int end=m/2;
		for(int i=0;i<m/2;i++)
		{
			for(int j=0;j<n;j++)
			{
				Newboard[j][start]=board[j][end];
				Newboard[j][end]=board[j][start];
			}
			start--;
			end++;
		}
		
	}
	public static void func3(int curx,int cury,int targetx,int targety)
	{
		for(int i=0;i<4;i++)
		{
			int nx = curx + dx[i];
			int ny = cury+ dy[i];
			int tnx = targetx+dx3[i];
			int tny = targety+dy3[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m)continue;
			if(visitied[nx][ny])continue;
			visitied[nx][ny]=true;
			Newboard[tnx][tny]=board[nx][ny];
			func3(nx,ny,tnx,tny);
		}
		
	}
	public static void func4(int curx,int cury,int targetx,int targety)
	{	
		for(int i=0;i<4;i++)
		{
			int nx = curx + dx2[i];
			int ny = cury+ dy2[i];
			int tnx = targetx+dx4[i];
			int tny = targety+dy4[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m)continue;
			if(visitied[nx][ny])continue;
			visitied[nx][ny]=true;
			Newboard[tnx][tny]=board[nx][ny];
			func4(nx,ny,tnx,tny);
		}
	}
	public static void func5()
	{
		
		//1->2
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i][j+m/2]=board[i][j];
			}
		}
		//2->3
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i+n/2][j+m/2]=board[i][j+m/2];
			}
		}
		//3->4
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i+n/2][j]=board[i+n/2][j+m/2];
			}
		}
		//4->1
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i][j]=board[i+n/2][j];
			}
		}
	}
	public static void func6()
	{
		//1->4
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i+n/2][j]=board[i][j];
			}
		}
		//4->3
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i+n/2][j+m/2]=board[i+n/2][j];
			}
		}
		//3->2
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i][j+m/2]=board[i+n/2][j+m/2];
			}
		}
		//2->1
		for(int i=0;i<n/2;i++)
		{
			for(int j=0;j<m/2;j++)
			{
				Newboard[i][j]=board[i][j+m/2];
			}
		}
	}
	

}
