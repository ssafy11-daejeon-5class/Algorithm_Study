package hw._240206.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2178 {

	static class Node {
		int i;
		int j;
		int cnt;

		Node(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

	static int N, M, answer;
	static int[][] maps;
	static boolean[][] v;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (temp.charAt(j) == '1') {
					maps[i][j] = 1;
				} else {
					maps[i][j] = 0;
				}
			}
		}
		answer = Integer.MAX_VALUE;
//		bfs();
		v[0][0]= true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}

	private static void dfs(int i, int j, int cnt) {
//		Stack<Node> s = new Stack<>();
//		s.push(new Node(0, 0, 1));
//		v[0][0] = true;
//		while (!s.isEmpty()) {
//			Node current = s.pop();
//			if (current.i == N - 1 && current.j == M - 1) {
//				answer = Math.min(answer, current.cnt);
//			}
//			for (int k = 0; k < 4; k++) {
//				int ni = current.i + di[k];
//				int nj = current.j + dj[k];
//				if (ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj] && maps[ni][nj] == 1) {
//					s.push(new Node(ni, nj, current.cnt + 1));
//					v[ni][nj] = true;
//				}
//			}
//		}
		if (i == N - 1 && j == M - 1) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for(int k = 0 ; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj] && maps[ni][nj] == 1) {
				v[ni][nj] = true;
				dfs(ni, nj, cnt + 1);
				v[ni][nj] = false;
			}
		}
		
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 1));
		v[0][0] = true;

		while (!q.isEmpty()) {
			Node current = q.poll();
			if (current.i == N - 1 && current.j == M - 1) {
				answer = current.cnt;
				break;
			}
			for (int k = 0; k < 4; k++) {
				int ni = current.i + di[k];
				int nj = current.j + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj] && maps[ni][nj] == 1) {
					q.offer(new Node(ni, nj, current.cnt + 1));
					v[ni][nj] = true;
				}
			}
		}
	}

}
