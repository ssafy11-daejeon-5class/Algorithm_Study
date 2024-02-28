package hw._240228.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 산악구조로봇 {

	static int[][] maps;
	static StringTokenizer st;
	static int T, N, answer;
	static final int INF = Integer.MAX_VALUE;

	static int[] di = new int[] { -1, 1, 0, 0 };
	static int[] dj = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());

			maps = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dijkstra() {
		int[][] minDis = new int[N][N];
		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(minDis[i], INF);
		}

		minDis[0][0] = 0;
		v[0][0] = true;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		pq.offer(new int[] { 0, 0, minDis[0][0] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			v[cur[0]][cur[1]] = true;
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
					if (maps[ni][nj] < maps[cur[0]][cur[1]]) { // 이동할 곳의 높이가 더 낮다면
						minDis[ni][nj] = Math.min(minDis[ni][nj], cur[2]);
						pq.offer(new int[] { ni, nj, minDis[ni][nj] });
					} else if (maps[ni][nj] == maps[cur[0]][cur[1]]) { // 이동할 곳의 높이가 같다면
						minDis[ni][nj] = Math.min(minDis[ni][nj], cur[2] + 1);
						pq.offer(new int[] { ni, nj, minDis[ni][nj] });
					} else if (maps[ni][nj] > maps[cur[0]][cur[1]]) {
						minDis[ni][nj] = Math.min(minDis[ni][nj], cur[2] + 2*(maps[ni][nj] - maps[cur[0]][cur[1]]));
						pq.offer(new int[] {ni, nj, minDis[ni][nj]});
					}	
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(minDis[i]));
//		}
		answer = minDis[N-1][N-1];
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
