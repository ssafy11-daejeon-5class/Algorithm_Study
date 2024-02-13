package study._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {

	static int N, M, R;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			arr = rotate();
		}
		print();
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] rotate() {
		// TODO Auto-generated method stub
		int[][] res = new int[N][M];
		int n = Math.min(N, M) / 2;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < N - i - 1; j++) {
				res[j+1][i] = arr[j][i];
			}
			for (int j = i; j < M - i - 1; j++) {
				res[N-i-1][j+1] = arr[N-i-1][j];
			}
			for (int j = N - i - 1; j > i; j--) {
				res[j-1][M-i-1] = arr[j][M-i-1];
			}
			for (int j = M - i - 1; j > i; j--) {
				res[i][j-1] = arr[i][j];
			}
		}
		return res;
	}

}
