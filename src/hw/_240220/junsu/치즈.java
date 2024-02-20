package hw._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {

	static int N, M, time;
	static List<Integer> melted = new ArrayList<>();
	static int[][] maps;
	static StringTokenizer st;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(check() != 0) {
			melted.add(check());
			melt();
			time++;
		}
		
		System.out.println(time);
		System.out.println(melted.get(melted.size()-1));
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void melt() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				if(ni>= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj]) {
					if(maps[ni][nj] == 0) {
						v[ni][nj] = true;
						q.offer(new int[] {ni, nj});
					} else if (maps[ni][nj] == 1) {
						v[ni][nj] = true;
						maps[ni][nj] = 0;
					}
				}
			}
		}
	}

	private static int check() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] == 1) {
					res++;
				}
			}
		}
		return res;
	}

}
