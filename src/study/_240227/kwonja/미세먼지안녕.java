package study._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

	/*
	 * 미세먼지 확산이 먼저 일어나고, 공기청정기가 작동한다
	 */
	static int r,c,t;
	static int[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		r =Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		t =Integer.parseInt(st.nextToken());
		board = new int[r][c];
		for(int i=0;i<r;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		print();
		
	}
	public static void print()
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void sperad(int x ,int y)
	{
		int count=0;
		//미세먼지 확산
		for(int i=0;i<4;i++)
		{
			int nx = x+ dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=r || ny<0 || ny>=c)continue;//확산불가
			board[nx][ny]+=(board[x][y]/5);
			count++;
		}
		board[x][y]=board[x][y]-(board[x][y]/5)*3;
		
	}

}
