package study._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀어

public class BOJ16918 {

	static String[] area;
	static int R;
	static int C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		area = new String[R];

		for (int i = 0; i < R; i++) {
			area[i] = br.readLine();
		}

		StringBuilder sb = new StringBuilder();
		if (N % 4 == 1) {
			// 원본 출력
			for (int i = 0; i < R; i++) {
				sb.append(area[i]);
				sb.append("\n");
			}
		} else if (N % 2 == 0) {
			// 모두 폭탄으로 출력
			StringBuilder oneLine = new StringBuilder();
			for (int j = 0; j < C; j++) {
				oneLine.append("O");
			}
			for (int i = 0; i < R; i++) {
				sb.append(oneLine);
				sb.append("\n");
			}

		} else if (N % 4 == 3) {
			// 코딩해야됨
			for (int r = 0; r < R; r++) {
				StringBuilder rthSb = new StringBuilder();
				for (int c = 0; c < C; c++) {
					if (isBomb(r, c) || isBombNextToMe(r, c)) {
						rthSb.append(".");
					} else {
						rthSb.append("O");
					}
				}
				sb.append(rthSb);
				sb.append("\n");
			}

		}

		System.out.println(sb);

	}

	static boolean isBombNextToMe(int r, int c) {
		int[] nextR = { r, r + 1, r, r - 1 };
		int[] nextC = { c + 1, c, c - 1, c };
		for (int i = 0; i < 4; i++) {
			if (isInArea(nextR[i], nextC[i])) {
				if (area[nextR[i]].charAt(nextC[i]) == 'O') {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isBomb(int r, int c) {
		if (area[r].charAt(c) == 'O') {
			return true;
		}
		return false;
	}

	static boolean isInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return false;
		return true;
	}

}
