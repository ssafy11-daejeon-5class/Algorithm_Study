package hw._240131.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sums = new int[N + 1];
		
		sums[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int n = 1; n < N + 1; n++) {
			sums[n] = sums[n - 1] + Integer.parseInt(st.nextToken());
		}

		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sums[end] - sums[start]);
		}
	}
}
