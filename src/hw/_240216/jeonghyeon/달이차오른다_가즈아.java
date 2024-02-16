package hw._240216.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다_가즈아 {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][][] visited;
	static Point startPoint;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C][64];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (s.charAt(j) == '0') {
					startPoint = new Point(i, j);
				}
			}
		}

		bfs();
	}

	private static void bfs() {

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(startPoint);
		map[startPoint.r][startPoint.c] = '.';
		visited[startPoint.r][startPoint.c][0] = true;

		while (!queue.isEmpty()) {

			Point p = queue.poll();
			int[] nr = new int[] { p.r, p.r + 1, p.r, p.r - 1 };
			int[] nc = new int[] { p.c + 1, p.c, p.c - 1, p.c };

			for (int i = 0; i < 4; i++) {

				if (isNotInArea(nr[i], nc[i]))
					continue;

				char newChar = map[nr[i]][nc[i]];
				// 1인 경우 종료
				if (newChar == '1') {
					System.out.println(p.cnt + 1);
					return;
				}
				// 0인 경우
				else if (newChar == '.') {
					// 만약 내가 키 a, b를 들고 왔는데 기존 visited[nr][nc][3] = false면 true로 업데이트
					if (!visited[nr[i]][nc[i]][p.keys]) {
						visited[nr[i]][nc[i]][p.keys] = true;
						queue.offer(new Point(nr[i], nc[i], p.cnt + 1, p.keys));
					}

				}
				// abcdef인 경우
				else if (newChar >= 97 && newChar <= 102) {
					// visited[nr[i]][nc[i]] &= visited[p.r][p.c];
					int newKeys = p.keys | (int) Math.pow(2, newChar - 97);
					if (!visited[nr[i]][nc[i]][newKeys]) {
						visited[nr[i]][nc[i]][newKeys] = true;
						queue.offer(new Point(nr[i], nc[i], p.cnt + 1, newKeys));
					}
				}
				// ABCDEF인 경우
				else if (newChar >= 65 && newChar <= 70) {
					boolean canWeGo = (p.keys & (int) Math.pow(2, newChar - 65)) > 0 ? true : false;
					if (canWeGo && !visited[nr[i]][nc[i]][p.keys]) {
						visited[nr[i]][nc[i]][p.keys] = true;
						queue.offer(new Point(nr[i], nc[i], p.cnt + 1, p.keys));
					}
				}
			}
		}

		System.out.println(-1);

	}

	static boolean isNotInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return true;
		return false;
	}
}

class Point {
	int r, c, cnt, keys;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
		this.cnt = 0;
		this.keys = 0;
	}

	Point(int r, int c, int cnt, int keys) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.keys = keys;
	}
}
