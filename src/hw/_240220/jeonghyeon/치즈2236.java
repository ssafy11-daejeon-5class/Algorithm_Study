package hw._240220.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈2236 {
	static int R, C;
	static char[][] map;
	static char[][] newMap;
	static boolean[][] visited;
	static int cheezeCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		newMap = new char[R][C];
		int initialCheezeCnt = 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j * 2);
				if (map[i][j] == '1')
					initialCheezeCnt++;
			}

		}

		bfs(1, initialCheezeCnt);

	}

	private static void bfs(int time, int beforeCheezeCnt) {
		for (int r = 0; r < R; r++) {
			newMap[r] = map[r].clone();
		}
		visited = new boolean[R][C];

		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(new Pair(0, 0));

		int cheezeCnt = beforeCheezeCnt;

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int[] nr = new int[] { p.r, p.r + 1, p.r, p.r - 1 };
			int[] nc = new int[] { p.c + 1, p.c, p.c - 1, p.c };
			for (int i = 0; i < 4; i++) {
				if (isNotInArea(nr[i], nc[i]))
					continue;
				if (visited[nr[i]][nc[i]])
					continue;
				if (map[nr[i]][nc[i]] == '1') {
					newMap[nr[i]][nc[i]] = '0';
					visited[nr[i]][nc[i]] = true;
					cheezeCnt--;
					continue;
				}
				queue.offer(new Pair(nr[i], nc[i]));
				visited[nr[i]][nc[i]] = true;
			}
		}

		// printMap();
		if (cheezeCnt == 0) {
			System.out.println(time + "\n" + beforeCheezeCnt);
			return;
		} else {
			for (int r = 0; r < R; r++) {
				map[r] = newMap[r].clone();
			}
			bfs(time + 1, cheezeCnt);
		}
	}

	private static void printMap() {
		System.out.println();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();

		}
	}

	private static boolean isNotInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return true;
		}
		return false;
	}

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
