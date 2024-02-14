package hw._240214.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리 {
	/*
	 * 쿼드트리
	 * 분할정복을 배우고 봐서 금방 이해했지만
	 * 4분할로 나누는지 어케유추할수 있나 궁금
	 */
	static int n;
	static int[][]board;
	static String res="";
//	static String res="";
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		board= new int[n][n];
		for(int i=0;i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<n;j++)
			{
				board[i][j]=str.charAt(j)-'0';
			}
		}
		System.out.println(recursive(n, 0, 0));
		
	}
	
	public static String recursive(int n,int r, int c)
	{
		//basis part
		if(n==1)
		{
			if(board[r][c]==0)
			{
				return "0";
			}
			else return "1";
		}
		//inductive
		int half=n/2;
		 String str=recursive(n/2, r, c)
				 + recursive(n/2, r, c+half)
				 + recursive(n/2, r+half, c)
				 + recursive(n/2, r+half, c+half);
		 if(str.contains("0000"))return "0";
		 else if(str.contains("1111"))return "1";
		 else return "("+str+")";
		
	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}
