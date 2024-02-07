package hw._240207.junsu;

import java.util.Scanner;

public class SWEA_1861 {	// 정사각형 방

	static int T, N, answer, max;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] maps;
	static int[][] cnts;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = sc.nextInt();
			maps = new int[N][N];
			cnts = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					maps[i][j] = sc.nextInt();
					cnts[i][j] = -1;
				}
			}
			
			
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
