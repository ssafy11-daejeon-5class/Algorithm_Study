package hw._240215.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_boolean {

	/*
	 * 빵집
	 * 
	 */
	static int[][] board;
	static int r,c;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {1,1,1,1};
	static int arrive;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		board = new int[r][c];
		for(int i=0;i<r;i++)
		{
			st= new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<c;j++)
			{
				if(str.charAt(j)=='x')
				{
					board[i][j]=1; //건물위치를 1로 지정
				}
			}
		}
		//파이프의 시작
		//최대 개수를 구해야한다->그리디하게 생각?
		//대각선위로 갈수 있다면 가고 그다음 대각선, 그다음 아래로
		for(int i=0;i<r;i++)
		{
			arrive=0;
			dfs(i,0);
//			print();
//			System.out.println();
		}
		System.out.println(res);
	}
	public static boolean dfs(int curx,int cury) {
		
		if(cury==c-1) //파이프 끝에 도달
		{
			res++;
			return true;
		}
		for(int i=0;i<4;i++)
		{
			int nx= curx+dx[i];
			int ny = cury+dy[i];
			if(nx<0 || nx>=r || ny<0 || ny>=c)continue;
			if(board[nx][ny]>0)continue; //건물이거나 방문했다면 패스
			board[nx][ny]=2;
			if(dfs(nx,ny))return true;
		}
		
		return false;
	}
	public static void print()
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
