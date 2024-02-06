package hw._240206.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static int N, M, V, s, e;
	static int[][] maps;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		maps = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			maps[s][e] = 1;
			maps[e][s] = 1;
		}
		v = new boolean[N + 1];
		dfs(V);
		System.out.println();
		v = new boolean[N + 1];
		bfs(V);
	}

	private static void bfs(int v2) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v2);
		v[v2] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i = 1; i <= N; i++) {
				if (maps[cur][i] == 1 && !v[i]) {
					q.offer(i);
					v[i] = true;
				}
			}
		}
	}

	private static void dfs(int v2) {
		//inductive part
		System.out.print(v2 + " ");
		v[v2] = true;
		for(int i = 1 ; i <= N ; i++) {
			if(maps[v2][i] == 1 && !v[i]) {
				dfs(i);
			}
		}
		
//		Stack<Integer> s = new Stack<>();
//		s.push(v2);
//		v[v2] = true;
//		while(!s.isEmpty()) {
//			int cur = s.pop();
//			System.out.print(cur + " ");
//			for(int i = N; i >= 1 ; i--) {
//				if(maps[cur][i] == 1 && !v[i]) {
//					s.push(i);
//					v[i] = true;
//				}
//			}
//		}
		
	}

}
