package hw._240207.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {
/*
 * 정사각형 방
 */
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] board;
	static int[][] visitied;
	static int n;
	static int res=Integer.MIN_VALUE;
	static int x,y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			StringTokenizer st =null;
			n =Integer.parseInt(br.readLine());
			board = new int[n][n];
			visitied = new int[n][n];
			for(int i=0;i<n;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					visitied[i][j]=1;
					dfs(i,j,1,i,j);
					visitied[i][j]=0;
				}
			}
			System.out.println("#" +test_case +" "+board[x][y] +" "+res);
		}
		
	}
	private static void dfs(int curx, int cury,int count,int posx,int posy) {
		
		if(count>res)
		{
			res=count;
			x=posx;
			y=posy;
		}
		for(int i=0;i<4;i++)
		{
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
			if(visitied[nx][ny]==1)continue;
			if((board[nx][ny]-board[curx][cury])==1)
			{
				visitied[nx][ny]=1;
				dfs(nx,ny,count+1,posx,posy);
				visitied[nx][ny]=0;
			}
		}
	}

}
