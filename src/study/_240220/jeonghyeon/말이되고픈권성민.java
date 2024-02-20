package study._240220.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1600	
public class 말이되고픈권성민 {
	static int K;
	static int R;
	static int C;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = new int[] { 1, 2, -1, 2, 0, 1, -1, 0, -2, 1, -2, -1 }; // 0~3, 8~11은 말, 4~7은 원숭이
	static int[] dc = new int[] { 2, 1, 2, -1, 1, 0, 0, -1, 1, -2, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C][K + 1];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		if (R == 1 && C == 1) {
			System.out.println(0);
			return;
		}

		bfs();
	}

	private static void bfs() {

		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(0, 0));
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int ncnt = p.jumpCnt + 1;
				int nhj;
				if ((i < 4 || i >= 8))
					nhj = p.horseJumpCnt + 1;
				else
					nhj = p.horseJumpCnt;

				if (notInArea(nr, nc)) // 맵 벗어났을 때
					continue;
				if (map[nr][nc] == '1') // 장애물일 때
					continue;
				if (nhj > K)
					continue;
				if (visited[nr][nc][nhj])
					continue;

				if (nr == R - 1 && nc == C - 1) {
					System.out.println(ncnt);
					return;
				}

				Point np;
				np = new Point(nr, nc, ncnt, nhj);
				queue.offer(np);
				visited[nr][nc][nhj] = true;

			}

		}

		System.out.println(-1);
		return;

	}

	public static boolean notInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return true;
		return false;
	}
}

class Point {
	int r, c, jumpCnt, horseJumpCnt;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
		this.jumpCnt = 0;
		this.horseJumpCnt = 0;
	}

	Point(int r, int c, int cnt, int jumps) {
		this.r = r;
		this.c = c;
		this.jumpCnt = cnt;
		this.horseJumpCnt = jumps;
	}
}
