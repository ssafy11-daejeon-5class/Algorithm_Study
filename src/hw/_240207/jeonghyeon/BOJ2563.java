package hw._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] isColorPaper = new boolean[100][100];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			for (int r = R; r < R + 10; r++) {
				for (int c = C; c < C + 10; c++) {
					isColorPaper[r][c] = true;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (isColorPaper[i][j])
					answer++;
			}
		}
		System.out.println(answer);
	}
}
