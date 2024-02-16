package hw._240216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬디펜스 {

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.i + " " + this.j;
		}
	}

	static int N, M, D, cnt, answer = Integer.MIN_VALUE;
	static int[][] maps, temp;
	static int[] sel;
	static boolean[] v;
	static StringTokenizer st;
	static int[] di = { 0, -1, 0 };
	static int[] dj = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sel = new int[3];
		combi(0, 0);
		System.out.println(answer);
	}

	private static void combi(int depth, int idx) {
		if (idx == 3) {
			// 궁수 위치 조합 발견. 비즈니스 로직 작성.
			cnt = 0;
			temp = copy();
			attack(N);
			return;
		}
		if (depth == M) {
			return;
		}
		sel[idx] = depth;
		combi(depth + 1, idx + 1);
		combi(depth + 1, idx);
	}

	private static int[][] copy() {
		int[][] res = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res[i][j] = maps[i][j];
			}
		}
		return res;
	}

	private static void attack(int depth) {
		List<Node> cand = new ArrayList<>();
		if (depth == 0) {
			answer = Math.max(answer, cnt);
			return;
		}
		for (int i = 0; i < 3; i++) {
			cand.add(bfs(depth, sel[i]));
		}			
		for (Node node : cand) {
			if(node != null && temp[node.i][node.j] == 1) {
				cnt += 1;
				temp[node.i][node.j] = -1;
			}
		}
		attack(depth-1);
	}

	private static Node bfs(int depth, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		List<int[]> list = new ArrayList<>();
		q.offer(new int[] {depth, j, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 3; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if(ni >= 0 && ni < depth && nj >= 0 && nj < M && !v[ni][nj] && cur[2] < D) {
					if(maps[ni][nj] == 1) {
						list.add(new int[] {ni, nj, cur[2] + 1});
					}
					q.offer(new int[] {ni, nj, cur[2] + 1});
				}
			}
		}
		if(list.size() == 0) {
			return null;
		} else {
			list.sort((a,b)-> a[2]==b[2]?Integer.compare(a[1], b[1]):Integer.compare(a[2], b[2]));
			return new Node(list.get(0)[0], list.get(0)[1]);
		}
	}

	private static void print() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
