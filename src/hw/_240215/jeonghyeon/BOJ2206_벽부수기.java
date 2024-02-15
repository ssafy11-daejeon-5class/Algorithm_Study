package hw._240215.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2206_벽부수기 {
	static int N, M;
	static String[][] map;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	public static int bfs(int R, int C, int breakCnt, int dist) {

		if (map[R][C].equals("1")) {
			if (breakCnt == 1)
				return -1;
			else
				breakCnt++;
		}

		int[] nr = new int[] { R, R + 1, R, R - 1 };
		int[] nc = new int[] { C + 1, C, C - 1, C };
		for (int i = 0; i < 4; i++) {
			if (notInArea(nr[i], nc[i]))
				continue;

		}

		return 0;
	}

	public static boolean notInArea(int R, int C) {
		if (R < 0 || R >= N || C < 0 || C >= M)
			return true;
		return false;
	}
}
