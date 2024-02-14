package hw._240214.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

	/*
	 * 빵집
	 * 
	 */
	static int[][] board;
	static int r,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<r;i++)
		{
			st= new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<c;j++)
			{
				if(str.charAt(j)=='X')
				{
					board[i][j]=1; //건물위치
				}
			}
		}
		
		//파이프의 시작
	}

}
