package study._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
	static int N;
	static int M;
	static int R;
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new String[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split(" ");
		}
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			turning(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void turning(int startPoint) {
		int smallR = startPoint;
		int smallC = startPoint;
		int largeR = N - 1 - smallR;
		int largeC = M - 1 - smallC;
		int oneRoundDist = ((N - smallR * 2 - 1) + (M - smallC * 2 - 1)) * 2;
		int leftDist = R % oneRoundDist;
		for (int i = 0; i < leftDist; i++) {
			String[] upString = map[smallR].clone();
			for (int r = smallR; r < largeR; r++) {
				map[r][largeC] = map[r + 1][largeC];
			}
			for (int c = largeC; c > smallC; c--) {
				map[largeR][c] = map[largeR][c - 1];
			}
			for (int r = largeR; r > smallR; r--) {
				map[r][smallC] = map[r - 1][smallC];
			}
			for (int c = smallC; c < largeC; c++) {
				map[smallR][c] = upString[c + 1];
			}
		}
	}
}
