package hw._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

	static int N, M, answer;
	static int[][] maps;
	static boolean[][][] v;
	static StringTokenizer st;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new int[N][M];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) == '0') {
					maps[i][j] = 0;
				} else {
					maps[i][j] = 1;
				}
			}
		}
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[N][M][2];
		q.offer(new int[] { 0, 0, 1, 0 }); // 0 : r, 1 : c, 2 : count, 3 : 벽 뚫었는지 여부
		v[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == N - 1 && cur[1] == M -1) {
				System.out.println(cur[2]);
				return;
			}
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if (maps[ni][nj] == 0 && !v[ni][nj][cur[3]]) {
						v[ni][nj][cur[3]] = true;
						q.offer(new int[] {ni, nj, cur[2] + 1, cur[3]});
					} else if (maps[ni][nj] == 1 && cur[3] == 0) {
						v[ni][nj][1] = true;
						q.offer(new int[] {ni, nj, cur[2] + 1, 1});
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
