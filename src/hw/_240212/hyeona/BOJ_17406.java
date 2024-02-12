package hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {

	static int N, M, K, R, C, S;
	static int[][] arr;
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			rotate(R, C, S);

		}
	}
	
	private static void rotate(int r, int c, int s) {
		
		// 돌릴 배열은 무조건 정사각형
		// 돌려야할 배열의 길이 (s*2+1)
		// 시작점 : r-2, c-2
		
		int count = (s*2+1) /2;
		
		int x = r-2;
		int y = c-2;
		
		// 인덱스는 x ~ x + (s*2)
		
		
		for(int i=0; i<count; i++)
		{
			int temp = arr[x][y];
			
			// 1

			
			// 2
			// 3
			// 4
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
