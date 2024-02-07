package algorithm.Algorithm_Study.src.hw._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {

	static int[][] arr;
	static int[][] new_arr, temp;
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

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<R; i++)
		{
			int K = Integer.parseInt(st.nextToken());
			N=arr.length;
			M=arr[0].length;

			switch(K)
			{
				case 1:
					calculate_1();
					//print(N, M);
					break;
				case 2:
					calculate_2();
					//print(N, M);
					break;
				case 3:
					calculate_3();
					//print(M, N);
					break;
				case 4:
					calculate_4();
					//print(M, N);
					break;
				case 5:
					store_temp();
					calculate_5();
					//print(N, M);
					break;
				case 6:
					store_temp();
					calculate_6();
					//print(N, M);
					break;

			}
		}
		print();

	}

	// 1 2
	// 3 4
	 
	private static void calculate_5() {

		new_arr = new int[N][M];

		// 3번을 1번으로
		for(int i=N/2; i<N; i++)
		{
			for(int j=0; j<M/2; j++)
			{
				new_arr[i-N/2][j]=arr[i][j];
			}
		}

		// 4번을 3번으로
		for(int i=N/2; i<N; i++)
		{
			for(int j=M/2; j<M; j++)
			{
				new_arr[i][j-M/2] = arr[i][j];
			}
		}

		// 2번을 4번으로
		for(int i=0; i<N/2; i++)
		{
			for(int j=M/2; j<M; j++)
			{
				new_arr[i+N/2][j] = arr[i][j];
			}
		}


		// temp를 2번으로
		for(int i=0; i<temp.length; i++)
		{
			for(int j=0; j<temp[0].length; j++)
			{
				new_arr[i][j+M/2]=temp[i][j];
			}
		}
		arr=new_arr;

		
	}

	// 1사분면 저장
	private static void store_temp()
	{
		temp = new int[N/2][M/2];
		for(int i=0; i<N/2; i++)
		{
			for(int j=0; j<M/2; j++)
			{
				temp[i][j] = arr[i][j];
			}
		}

	}
	
	private static void calculate_6() {

		new_arr = new int[N][M];
		// 1 2
		// 3 4
	
		// 2사분면을 1사분면으로
		for(int i=0 ; i<N/2; i++)
		{
			for(int j= M/2; j<M; j++)
			{
				new_arr[i][j-M/2] = arr[i][j];
			}
		}
		
		// 4사분면을 2사분면으로
		for(int i=N/2; i<N; i++)
		{
			for(int j= M/2; j<M; j++)
			{
				new_arr[i-N/2][j] = arr[i][j];
			}
		}
		
		// 3사분면을 4사분면으로
		for(int i=N/2 ; i<N; i++)
		{
			for(int j=0; j<M/2; j++)
			{
				new_arr[i][j+M/2] = arr[i][j];
			}
		}

		// temp를 2사분면으로
		for(int i=0; i<temp.length; i++)
		{
			for(int j=0; j<temp[0].length; j++)
			{
				new_arr[N/2+i][j] = temp[i][j];
			}
		}
		arr=new_arr;
	}


	private static void calculate_4() {

		new_arr = new int[M][N];
		
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				new_arr[i][j]= arr[j][M-i-1];
			}
		}
		arr=new_arr;
	}


	private static void calculate_3() {

		new_arr = new int[M][N];
		
		for(int i=0; i<M; i++)
		{
			for(int j=0; j<N; j++)
			{
				new_arr[i][j]= arr[N-1-j][i];
			}
		}
		arr=new_arr;
	}


	public static void calculate_1()
	{
		new_arr = new int[N][M];
		for(int i=0; i<N; i++)
		{
			new_arr[i] = arr[N-1-i];
		}
		arr=new_arr;
	}
	
	public static void calculate_2()
	{
		new_arr = new int[N][M];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				new_arr[i][j] = arr[i][M-1-j];
			}
		}
		arr=new_arr;
	}
	
	public static void print()
	{
		for(int i=0; i< new_arr.length; i++)
		{
			for(int j=0; j<new_arr[0].length; j++)
			{
				sb.append(new_arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
