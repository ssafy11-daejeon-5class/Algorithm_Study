package study._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16927 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(N,  M) / 2;
		
		int garo=M;
		int sero=N;
				
		
		for(int i=0; i<count; i++)
		{
			// count마다 R이 달라짐  
			int answer = 2*garo + 2*(sero-2);
			
	        
			int X = R % answer;
			
			//System.out.println(garo+" "+sero);
			//System.out.println(X);
			
			for(int k=0; k<X; k++)
			{
				int temp = arr[i][i];
				for(int j=i; j<M-i-1; j++)
				{
					arr[i][j] = arr[i][j+1];
				}
				
				for(int j=i; j<N-i-1; j++)
				{
					arr[j][M-i-1] = arr[j+1][M-i-1];
				}
				
				for(int j=M-1-i; j>i; j--)
				{
					arr[N-1-i][j] = arr[N-1-i][j-1];
				}
				
				for(int j=N-i-1; j>i+1; j--)
				{
					arr[j][i] = arr[j-1][i];
				}
				
				arr[i+1][i] = temp;	
			}
			garo -=2;
			sero -=2;
		
		}	
		
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		

	}


}
