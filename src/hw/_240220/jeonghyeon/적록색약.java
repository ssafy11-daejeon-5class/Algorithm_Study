package hw._240220.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int areaCnt;
//	static List<Pair> processorList;
//	static int maxCableCnt;
//	static int minCableTotalLength;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}

		}
		visited = new boolean[N][N];
		areaCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j])
					bfs_R_G_B(i, j);
			}
		}
		System.out.print(areaCnt + " ");

		visited = new boolean[N][N];
		areaCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j])
					bfs_RG_B(i, j);
			}
		}
		System.out.print(areaCnt);

	}

	private static void bfs_R_G_B(int R, int C) {
		char color = map[R][C];
		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(new Pair(R, C));

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int[] nr = new int[] { p.r, p.r + 1, p.r, p.r - 1 };
			int[] nc = new int[] { p.c + 1, p.c, p.c - 1, p.c };
			for (int i = 0; i < 4; i++) {
				if (isNotInArea(nr[i], nc[i]))
					continue;
				if (visited[nr[i]][nc[i]])
					continue;
				if (map[nr[i]][nc[i]] == color) {
					queue.offer(new Pair(nr[i], nc[i]));
					visited[nr[i]][nc[i]] = true;
				}
			}
		}

		areaCnt++;
	}

	private static void bfs_RG_B(int R, int C) {
		char color = map[R][C];
		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(new Pair(R, C));

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int[] nr = new int[] { p.r, p.r + 1, p.r, p.r - 1 };
			int[] nc = new int[] { p.c + 1, p.c, p.c - 1, p.c };
			for (int i = 0; i < 4; i++) {
				if (isNotInArea(nr[i], nc[i]))
					continue;
				if (visited[nr[i]][nc[i]])
					continue;
				if (isSameColor(map[nr[i]][nc[i]], color)) {
					queue.offer(new Pair(nr[i], nc[i]));
					visited[nr[i]][nc[i]] = true;
				}
			}
		}

		areaCnt++;
	}

	private static boolean isSameColor(char color1, char color2) {
		if (color1 == color2)
			return true;
		else if (color1 == 'R' && color2 == 'G')
			return true;
		else if (color1 == 'G' && color2 == 'R')
			return true;
		else
			return false;
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();

		}
	}

	private static boolean isNotInArea(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return true;
		}
		return false;
	}
}

class Pair {
	int r, c;

	public Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
