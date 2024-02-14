package study._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

	static int N, answer;
	static StringTokenizer st;
	static int[][] maps;
	static int size = 2;
	static int[] di = new int[] { -1, 1, 0, 0 };
	static int[] dj = new int[] { 0, 0, -1, 1 };
	static int[] start;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maps = new int[N][N];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 9) {
					start = new int[] { i, j };
				}
			}
		}

		while (true) {
			bfs(start);
		}
		
	}

	private static void bfs(int[] s) {
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[N][N];
		List<int[]> cand = new ArrayList<>();
		
		q.offer(new int[] {s[0], s[1], 0});
		v[s[0]][s[1]] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
					if(maps[ni][nj] == 0 || maps[ni][nj] == size) {
						q.offer(new int[] {ni, nj, cur[2] + 1});
					}
				}
			}
		}
	}
}
