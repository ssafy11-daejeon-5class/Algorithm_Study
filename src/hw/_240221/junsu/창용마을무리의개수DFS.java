package hw._240221.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 창용마을무리의개수DFS {
	
	static int T, N, M, answer;
	static StringTokenizer st;
	static int[][] maps;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());		// 마을사람수
			M = Integer.parseInt(st.nextToken());		// 관계수
			answer = 0;
			
			maps = new int[N+1][N+1];
			v = new boolean[N+1];		
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				maps[s][e] = 1;
				maps[e][s] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				if(!v[i]) {
//					bfs(i);
					dfs(i);
					answer++;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int i) {
		if(v[i]) return;
		v[i] = true;
		for (int j = 1; j < N+1; j++) {
			if(!v[j] && maps[i][j] == 1) dfs(j);
		}
	}

	private static void bfs(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 1; j <= N; j++) {
				if(maps[cur][j] == 1 && !v[j]) {
					q.offer(j);
					v[j] = true;
				}
			}
		}
	}

}
