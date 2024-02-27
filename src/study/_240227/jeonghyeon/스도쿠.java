package study._240227.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스도쿠 {
	static int[][] map, newMap;
	static boolean[] visited;
	static Queue<Point> queue;
	static List<Point> zeroList;

	public static void main(String[] args) throws Exception {

		getInput();

		makeQueue();

		initialFillMap(); // 가능한 후보가 한 개인 칸들을 먼저 채워준다.

		makeList();

//		int pqSize = pq.size();
//		for (int i = 0; i < pqSize; i++) {
//			System.out.print(pq.poll().ableNumCnt + " ");
//		}
//		System.out.println();

		printMap();
	}

	private static void getInput() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void makeQueue() {
		queue = new ArrayDeque<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					queue.offer(new Point(i, j));
				}
			}
		}
	}

	private static void initialFillMap() {
		while (true) {
			int qSize = queue.size();
			for (int i = 0; i < queue.size(); i++) {
				Point p = queue.poll();
				if (map[p.r][p.c] != 0)
					continue;
				if (!initialFillCan(p.r, p.c)) {
					queue.offer(p);
					continue;
				}
			}
			if (qSize == queue.size())
				break;
		}
	}

	private static boolean initialFillCan(int r, int c) {
		if (getAbleNumCnt(r, c) == 1) {
			for (int i = 1; i <= 9; i++) {
				if (!visited[i]) {
					map[r][c] = i;
					return true;
				}
			}
		}

		return false;
	}

	private static int getAbleNumCnt(int r, int c) {
		visited = new boolean[10];
		visited[0] = true;
		int cnt = 9;

		for (int i = 0; i < 9; i++) {
			if (!visited[map[i][c]]) {
				cnt--;
				visited[map[i][c]] = true;
			}
			if (!visited[map[r][i]]) {
				cnt--;
				visited[map[r][i]] = true;
			}
		}
		for (int i = r - r % 3; i < r - r % 3 + 3; i++) {
			for (int j = c - c % 3; j < c - c % 3 + 3; j++) {
				if (!visited[map[i][j]]) {
					cnt--;
					visited[map[i][j]] = true;
				}
			}
		}

		return cnt;
	}

	private static void makeList() {
		zeroList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					zeroList.add(new Point(i, j, getAbleNumCnt(i, j)));
				}
			}
		}

		zeroList.sort((p1, p2) -> p1.ableNumCnt - p2.ableNumCnt);
		combination(0);
	}

	private static boolean combination(int idx) {
		if (idx == zeroList.size()) {
			return true;
		}

		Point p = zeroList.get(idx);
		int[] ableNumList = getAbleNumList(p.r, p.c);
		for (int j = 0; j < ableNumList.length; j++) {
			map[p.r][p.c] = ableNumList[j];
			if (combination(idx + 1))
				return true;
			map[p.r][p.c] = 0;
		}

		return false;

	}

	private static int[] getAbleNumList(int r, int c) {
		int[] ableNumList = new int[getAbleNumCnt(r, c)];
		int idx = 0;
		for (int j = 1; j <= 9; j++) {
			if (!visited[j]) {
				ableNumList[idx++] = j;
			}
		}

		return ableNumList;

	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb + "\n");
	}

	static class Point {
		int r, c;
		int ableNumCnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int ableNumCnt) {
			super();
			this.r = r;
			this.c = c;
			this.ableNumCnt = ableNumCnt;
		}

	}

}
