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
	static int[] edgeCnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[N+1];
		edgeCnt = new int[N+1];
		for (int j = 0; j < N + 1; j++) {
			adjList[j] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjList[s].add(e);
			edgeCnt[e]++;
		}

		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 1; i < N+1; i++) {
			if(edgeCnt[i] == 0){
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int i : adjList[cur]) {
				edgeCnt[i]--;
				if(edgeCnt[i] == 0){
					q.offer(i);
				}
			}
		}
	}

}
