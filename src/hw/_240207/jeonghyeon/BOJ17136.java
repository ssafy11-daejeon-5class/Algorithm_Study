package hw._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ17136 {

	static int N;
	static String[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = 10;
		map = new String[N][N];
		visited = new boolean[N][N];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new String[100][100];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split(" ");
		}

		Queue<Point> Q = new ArrayDeque<>();
		visited[0][0] = true;
		Q.add(new Point(0, 0));
		int cnt = 1;
		while (!Q.isEmpty()) {
			Point p = Q.poll();

			canGo(p, 1);

			for (int i = 0; i < 2; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				// 지도 경계
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}
		print();
	}

	private static void print() {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();

		}
	}

	static int canGo(Point p, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == n - 1 || j == n - 1) {
					if (!map[p.r][p.c].equals("1")) {

					}
				}
			}
		}
		if (map[p.r][p.c].equals("1"))
			return 0;
		return n;
	}
}

class Point {
	public int r, c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}