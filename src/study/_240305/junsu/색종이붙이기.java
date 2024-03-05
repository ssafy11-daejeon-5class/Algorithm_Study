package study._240305.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
	static int[][] maps = new int[10][10];
	static int[] papers = { 5, 5, 5, 5, 5 };
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		answer = 25;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(0, 0, 0);
		System.out.println(answer);
	}

	private static void recursive(int r, int c, int count) {
		if (r == 10) {
			answer = Math.min(answer, count);
			return;
		}

		for (int i = r; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (maps[i][j] == 1) {
					for (int k = 4; k >= 0; k--) {
						if (papers[k] > 0 && i + k + 1 < 10 && j + k + 1 < 10 && valid(i, j, k + 1)) {
							check(i, j, k + 1, 0);
							papers[k]--;
							recursive(i, j, count + 1);
							check(i, j, k + 1, 1);
							papers[k]++;
						}
					}
				}
			}
		}

	}

	private static boolean valid(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (maps[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static void check(int r, int c, int size, int tag) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				maps[i][j] = tag;
			}
		}
		return;
	}

	private static boolean onlyZero() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (maps[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
