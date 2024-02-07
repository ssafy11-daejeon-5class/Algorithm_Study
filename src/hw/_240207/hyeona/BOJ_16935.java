package hw._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_16935 {

	static int[][] arr;
	static int[][] newArr;
	static int N, M, R;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		StringTokenizer st; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		int K = Integer.parseInt(br.readLine());
		newArr = new int[N][M];
		
		switch(K)
		{
			case 1:
				calculate_1();
				print(N, M);
				break;
			case 2:
				calculate_2();
				print(N, M);
				break;
			case 3:
				calculate_3();
				print(M, N);
				break;
			case 4:
				calculate_4();
				print(M, N);
				break;
			case 5:
				calculate_5();
				print(N, M);
				break;
			case 6:
				calculate_6();
				print(N, M);
				break;
			
		}
		
		
	}
	 
	private static void calculate_5() {
		// TODO Auto-generated method stub
		
	}

	// 1사분면 저장
	private static void store_temp()
	{
		int[][] temp = new int[N/2][M/2];
		for(int i=0; i<N/2; i++)
		{
			for(int j=0; j<M/2; j++)
			{
				temp[i][j] = arr[i][j];
			}
		}
	}
	
	private static void calculate_6() {
		
		// 1 2
		// 3 4
	
		// 2사분면을 1사분면으로
		for(int i=0 ; i<N/2; i++)
		{
			for(int j= M/2-1; j>=0; j--)
			{
				arr[i][M/2-1-j] = arr[i][j];
			}
		}
		
		// 4사분면을 2사분면으로
		for(int i=N/2-1 ; i>=0; i--)
		{
			for(int j= M/2-1; j>=0; j--)
			{
				arr[N/2-1-i][j] = arr[i][j];
			}
		}
		
		// 3사분면을 4사분면으로
		for(int i=N/2 ; i<N; i++)
		{
			for(int j= 0; j<M-1; j++)
			{
				arr[i][j+M/2] = arr[i][j];
			}
		}
		
		// temp를 1사분면으로
		
		
		
		
		
		
		
	}


	private static void calculate_4() {
		
		newArr = new int[M][N];
		
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				newArr[i][j]= arr[j][M-i-1];
			}
		}
		
		
	}


	private static void calculate_3() {
		
		newArr = new int[M][N];
		
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				newArr[i][j]= arr[N-1-j][i];
			}
		}
	
	}


	public static void calculate_1()
	{
		
		for(int i=0; i<N; i++)
		{
			newArr[i] = arr[N-1-i];
		}
	}
	
	public static void calculate_2()
	{
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				newArr[i][j] = arr[i][M-1-j];
			}
			
		}
	}
	
	public static void print(int garo, int sero)
	{
		for(int i=0; i<garo; i++)
		{
			for(int j=0; j<sero; j++)
			{
				sb.append(newArr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
