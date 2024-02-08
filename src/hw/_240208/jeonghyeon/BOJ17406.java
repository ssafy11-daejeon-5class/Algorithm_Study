package hw._240208.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
	static int N;
	static int M;
	static int K;
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split(" ");
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken()) - 1;
			int S = Integer.parseInt(st.nextToken());
			for (int i = S; i > 0; i--) {
				turning(R, C, S);
			}

			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(map[i][j]);
					sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int val = 0;
			for (int j = 0; j < M; j++) {
				val += Integer.parseInt(map[i][j]);
			}
			answer = Math.min(answer, val);
		}
		System.out.println(answer);
	}

	static void turning(int R, int C, int S) {
		int smallR = R - S;
		int largeR = R + S;
		int smallC = C - S;
		int largeC = C + S;
		int oneRoundDist = ((largeR - smallR) + (largeC - smallC)) * 2;
		int leftDist = R % oneRoundDist;
		for (int i = 0; i < leftDist; i++) {
			String[] upString = map[smallR].clone();
			for (int r = smallR; r < largeR; r++) {
				map[r][smallC] = map[r + 1][smallC];
			}
			for (int c = smallC; c < largeC; c++) {
				map[largeR][c] = map[largeR][c + 1];
			}
			for (int r = largeR; r > smallR; r--) {
				map[r][largeC] = map[r - 1][largeC];
			}
			for (int c = largeC; c < smallC; c--) {
				map[smallR][c] = upString[c - 1];
			}
		}
	}
}
