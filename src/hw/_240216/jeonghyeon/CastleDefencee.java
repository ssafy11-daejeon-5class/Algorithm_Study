package hw._240216.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class CastleDefencee {
	static int R;
	static int C;
	static int archerRow; // 적을 내리는 게 아니라 성과 궁수를 위로 올려가면서 진행
	static char[][] mapOriginal;
	static char[][] map;
	static int maxDist;
	static boolean[][] visited;
	static Set<Point> killedVillainsAtARound = new HashSet<>();
	static int killedCntAtAPermutation;
	static int maxKillCnt = Integer.MIN_VALUE;

	// 조합용 전역 변수
	static int[] sel = new int[3];
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maxDist = Integer.parseInt(st.nextToken());

		mapOriginal = new char[R][C];
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine().replace(" ", "");
			for (int j = 0; j < C; j++) {
				mapOriginal[i][j] = s.charAt(j);
			}
		}

		v = new boolean[C];
		permutation(0, 0);

		System.out.println(maxKillCnt);
	}

	private static void permutation(int idx, int k) {
		// basis part
		// 다 골랐어요
		if (k == sel.length) {
			attack();
			return;
		}
		if(idx==C) {
			return ;
		}
		// inductive part
		// 선택하는 경우
		sel[k] = idx;
		permutation(idx+1, k+1);
		// 선택하지 않는 경우
		permutation(idx+1, k);
			
		
	}

	private static void attack() {
		killedCntAtAPermutation = 0;
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = mapOriginal[i].clone();
		}

		for (archerRow = R; archerRow > 0; archerRow--) {
			killedVillainsAtARound.clear();
			for (int i = 0; i < 3; i++) {
				bfs(archerRow, sel[i]);
			}
			for (Point p : killedVillainsAtARound) {
				map[p.r][p.c] = '0';
				killedCntAtAPermutation++;	
			}
		}
		maxKillCnt = Math.max(maxKillCnt, killedCntAtAPermutation);

	}

	private static void bfs(int r, int c) {

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(r, c));

		L: while (!queue.isEmpty()) {

			Point p = queue.poll();
			int[] nr = new int[] { p.r, p.r - 1, p.r };
			int[] nc = new int[] { p.c - 1, p.c, p.c + 1 };
			int nDist = p.dist + 1;
			if (nDist > maxDist)
				break;

			for (int i = 0; i < 3; i++) {

				if (isNotInArea(nr[i], nc[i]))
					continue;

				char newChar = map[nr[i]][nc[i]];
				if (newChar == '1') {
					killedVillainsAtARound.add(new Point(nr[i], nc[i]));
					break L;
				}
				// 0인 경우
				else if (newChar == '0') {
					visited[nr[i]][nc[i]] = true;
					queue.offer(new Point(nr[i], nc[i], nDist));
				}
			}
		}
	}

	static boolean isNotInArea(int r, int c) {
		if (r < 0 || r >= archerRow || c < 0 || c >= C)
			return true;
		return false;
	}

	static class Point {
		int r, c, dist;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
			this.dist = 0;
		}

		Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				if (r == p.r && c == p.c)
					return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c, dist);
		}
	}
}
