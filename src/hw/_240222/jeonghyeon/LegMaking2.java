package hw._240222.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class LegMaking2 {
	static int V, E;
	static Edge[] edgeList;
	static int[] set;

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int islandNum;
	static int[][] adjMatrix;
//	static List<E>

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = a.charAt(j * 2);
			}
		}

		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] == '1') {
					bfs(i, j, ++islandNum);
				}

			}
		}

		printMap();

		makeAdjMatrix();

//		System.out.println();
//		for (int i = 0; i <= islandNum; i++) {
//			for (int j = 0; j <= islandNum; j++) {
//				if (adjMatrix[i][j] > 1000)
//					System.out.print(9 + " ");
//				else
//					System.out.print(adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//
//		}

//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//		edgeList = new Edge[E];
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine());
//			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
//					Integer.parseInt(st.nextToken()));
//		}
//		set = new int[V + 1];
//		for (int i = 1; i <= V; i++) {
//			set[i] = i;
//		}
//
//		Arrays.sort(edgeList);
//
//		for (Edge edge : edgeList) {
//			System.out.println("list : " + edge.from + " " + edge.to + " " + edge.weight);
//		}
//
//		int cnt = 0;
//		long totalLength = 0;
//		for (Edge edge : edgeList) {
//			if (union(edge.from, edge.to)) {
//				totalLength += edge.weight;
//				System.out.println(edge.from + " " + edge.to);
//				if (++cnt == V - 1) {
//					break;
//				}
//			}
//		}

	}

	public static boolean union(int e1, int e2) {
		int e1Root = find(e1);
		int e2Root = find(e2);
		if (e1Root == e2Root)
			return false;

		set[e1Root] = e2Root;
		return true;
	}

	public static int find(int e) {
		if (e == set[e])
			return e;
		return set[e] = find(set[e]);
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}

	}

	private static void bfs(int r, int c, int islandNum) {

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(r, c));
		visited[r][c] = true;
		map[r][c] = (char) (islandNum + 48);

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int[] nr = new int[] { p.r, p.r + 1, p.r, p.r - 1 };
			int[] nc = new int[] { p.c + 1, p.c, p.c - 1, p.c };
			for (int i = 0; i < 4; i++) {
				if (isNotInArea(nr[i], nc[i]))
					continue;
				if (visited[nr[i]][nc[i]])
					continue;
				if (map[nr[i]][nc[i]] == '1') {
					queue.offer(new Point(nr[i], nc[i]));
					visited[nr[i]][nc[i]] = true;
					map[nr[i]][nc[i]] = (char) (islandNum + 48);
				}
			}
		}

	}

	static void makeAdjMatrix() {
		adjMatrix = new int[islandNum + 1][islandNum + 1];
		for (int i = 0; i < islandNum + 1; i++) {
			for (int j = 0; j < islandNum + 1; j++) {
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (j != C - 1 && map[i][j] != '0' && map[i][j + 1] == '0') {
					int lengthToOppositeSide = getLengthToOppositeSide(i, j, 0);
					if (lengthToOppositeSide == -1)
						continue;

					int oppositeIslandNum = map[i][j + lengthToOppositeSide + 1] - '0';
					adjMatrix[map[i][j] - '0'][oppositeIslandNum] = Math
							.min(adjMatrix[map[i][j] - '0'][oppositeIslandNum], lengthToOppositeSide);
					adjMatrix[oppositeIslandNum][map[i][j] - '0'] = Math
							.min(adjMatrix[oppositeIslandNum][map[i][j] - '0'], lengthToOppositeSide);
				}
				if (i != R - 1 && map[i][j] != '0' && map[i + 1][j] == '0') {
					int lengthToOppositeSide = getLengthToOppositeSide(i, j, 1);
					if (lengthToOppositeSide == -1)
						continue;

					int oppositeIslandNum = map[i + lengthToOppositeSide + 1][j] - '0';
					adjMatrix[map[i][j] - '0'][oppositeIslandNum] = Math
							.min(adjMatrix[map[i][j] - '0'][oppositeIslandNum], lengthToOppositeSide);
					adjMatrix[oppositeIslandNum][map[i][j] - '0'] = Math
							.min(adjMatrix[oppositeIslandNum][map[i][j] - '0'], lengthToOppositeSide);
				}
			}
		}
	}

	static boolean isNotInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return true;
		return false;
	}

	private static int getLengthToOppositeSide(int r, int c, int direction) {
		if (direction == 0) {
			for (int nc = c + 1; nc < C; nc++) {
				if (map[r][nc] != '0') {
					// 임시
					if (r == 3 && c == 1 && nc == 5) {
						System.out.println("here! " + (nc - c - 1));
					}
					// 여기까지
					return nc - c - 1;
				}
			}
		} else if (direction == 1) {
			for (int nr = r + 1; nr < R; nr++) {
				if (map[nr][c] != '0')
					return nr - r - 1;
			}
		}

		return -1;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

//	static class Edge implements Comparable<Edge> {
//		int from, to, weight;
//
//		public Edge(int from, int to, int weight) {
//			this.from = from;
//			this.to = to;
//			this.weight = weight;
//		}
//
//		@Override
//		public int compareTo(Edge e) {
//			return this.weight - e.weight;
//		}
//
//	}

	private static void printMap() {
		System.out.println();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();

		}
	}

}
