package hw._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 { // BOJ_2252

	static int N, M;
	static StringTokenizer st;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[N+1];
		for (int j = 0; j < N + 1; j++) {
			adjList[j] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjList[e].add(s);
		}

		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(adjList[i].size() == 0) {
				q.offer(i);
				v[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for(int j = 1 ; j <= N ; j++) {
				if(adjList[j].contains(cur)) {
					adjList[j].remove(adjList[j].indexOf(cur));
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(!v[i] && adjList[i].size() == 0) {
					q.offer(i);
					v[i] = true;
				}
			}
			
		}
	}

}
