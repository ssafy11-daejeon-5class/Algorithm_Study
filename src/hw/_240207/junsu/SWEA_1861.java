package hw._240207.junsu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1861 { // 정사각형 방

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int T, N, answer, max;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static List<Integer> cand;
	static int[][] maps;
	static int[][] cnts;
	static boolean[][] v;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			answer = 0;
			cand = new ArrayList<>();
			max = Integer.MIN_VALUE;
			N = sc.nextInt();
			maps = new int[N][N];
			cnts = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					maps[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					v = new boolean[N][N];
					bfs(i, j);
				}
			}
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(cnts[i][j] == max) {
						cand.add(maps[i][j]);
					}
				}
			}
			cand.sort(null);
			answer = cand.get(0);
			System.out.println("#" + t + " " + answer + " " + max);
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(cnts[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(int i, int j) {
		Queue<Node> q = new ArrayDeque<>();
		int cnt = 1;
		v[i][j] = true;
		q.offer(new Node(i, j));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur.i + di[k];
				int nj = cur.j + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj] && maps[ni][nj] == maps[cur.i][cur.j] + 1) {
					v[ni][nj] = true;
					q.offer(new Node(ni, nj));
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
		cnts[i][j] = cnt;
	}

}
