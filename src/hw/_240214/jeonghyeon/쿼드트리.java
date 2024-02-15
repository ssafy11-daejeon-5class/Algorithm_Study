package hw._240214.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리 {
	static int N, R, C;
	static String[][] map;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		answer = recursive(0, 0, N);
		System.out.println(answer);

	}

	static String recursive(int R, int C, int N) {

		if (N == 1) {
			return map[R][C];
		}

		int midVal = N / 2;
		String area1 = recursive(R, C, midVal);
		String area2 = recursive(R, C + midVal, midVal);
		String area3 = recursive(R + midVal, C, midVal);
		String area4 = recursive(R + midVal, C + midVal, midVal);

		if ((area1.equals(area2)) && (area2.equals(area3)) && (area3.equals(area4))) {
			return area1;
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(area1);
			sb.append(area2);
			sb.append(area3);
			sb.append(area4);
			sb.append(")");
			return sb.toString();
		}
	}
}
