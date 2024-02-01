package hw._240131.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] sumsRight = new int[N + 1][N + 1];
		for(int n = 1; n < N + 1; n++) {
			sumsRight[n][0] = 0;
			sumsRight[0][n] = 0;
		}
		for(int n = 1; n < N + 1; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 1; m < N + 1; m++) {
				sumsRight[n][m] = sumsRight[n][m-1] + sumsRight[n-1][m] - sumsRight[n-1][m-1] + Integer.parseInt(st.nextToken());
			}
		}	

		StringBuilder sb = new StringBuilder();
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken()) - 1;
			int startX = Integer.parseInt(st.nextToken()) - 1;
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int sum = sumsRight[endY][endX] - sumsRight[endY][startX] - sumsRight[startY][endX] + sumsRight[startY][startX];
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}

}
