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
	static int[][] visited;
	static int[] dr = new int[] { 1, 2, -1, 2, 0, 1, -1, 0, -2, 1, -2, -1 }; // 0~3, 8~11은 말, 4~7은 원숭이
	static int[] dc = new int[] { 2, 1, 2, -1, 1, 0, 0, -1, 1, -2, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		bfs();

	}

	private static void bfs() {

		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(0, 0));
		visited[0][0] = 0;

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int ncnt = p.cnt + 1;
				
				//ㅇㅇ
				if(ncnt == 5) return;
				//ㅐㅐ
				
				int nhj;
				if ((i < 4 || i >= 8))
					nhj = p.jumps + 1;
				else
					nhj = p.jumps;

				if (notInArea(nr, nc)) // 맵 벗어났을 때
					continue;
				if (map[nr][nc] == '1') // 장애물일 때
					continue;
				if (nhj > K)
					continue;

				if (nr == R - 1 && nc == C - 1) {
					System.out.println("cnt:" + ncnt + ", nr:" + nr + ", nc:" + nc + ", horse:" + nhj);
					System.out.println(ncnt + " answer");
					return;
				}

				System.out.println("cnt:" + p.cnt + ", nr:" + nr + ", nc:" + nc + ", horse:" + nhj);

				Point np;
				if (i >= 4 && i < 8 && !someoneVisitedLessOrSameHorseJumpThanYou(nr, nc, nhj)) {
					// 원숭이일 경우
					visited[nr][nc] = visited[p.r][p.c];
					np = new Point(nr, nc, ncnt, nhj);
				} else if (p.jumps < K && !someoneVisitedLessOrSameHorseJumpThanYou(nr, nc, nhj)) {
					// 말점프 K번 미만으로 했고 기존에 더 적거나 같은 말점프 횟수로 방문한 적이 없을 때
					visited[nr][nc] = visited[p.r][p.c] + (int) Math.pow(2, nhj);
					np = new Point(nr, nc, ncnt, nhj);
				} else {
					visited[nr][nc] = visited[p.r][p.c];
					continue;
				}
				queue.offer(np);

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

	public static boolean someoneVisitedLessOrSameHorseJumpThanYou(int r, int c, int horseJumps) {
		if ((long) visited[r][c] % ((long) Math.pow(2, horseJumps + 1)) > 0)
			return true;
		return false;
	}
}

class Point {
	int r, c, cnt, jumps;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
		this.cnt = 0;
		this.jumps = 0;
	}

	Point(int r, int c, int cnt, int jumps) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.jumps = jumps;
	}
}
