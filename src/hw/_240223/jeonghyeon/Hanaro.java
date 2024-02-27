package hw._240223.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Hanaro {
	static int N;
	static Double taxRate;
	static Island[] islandArray;
	static Edge[] edgeArray;
	static int[] set;
	static long answer;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			getInput();
			
			makeEdgeArrayAndSort();
			
			//printEdgeArray();
			
			UnionFind();
			
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static public void getInput() throws Exception {
		N = Integer.parseInt(br.readLine());
		islandArray = new Island[N];
		edgeArray = new Edge[N*(N-1)/2];
		set = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			islandArray[i] = new Island(Integer.parseInt(st.nextToken()));
			set[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			islandArray[i].y = Integer.parseInt(st.nextToken());
		}
		taxRate = Double.parseDouble((br.readLine()));
	}

	static public void makeEdgeArrayAndSort() {
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				long dist = (long) (Math.pow(islandArray[i].x-islandArray[j].x, 2) + Math.pow(islandArray[i].y-islandArray[j].y, 2));
				edgeArray[idx++] = new Edge(i, j, dist);
			}
		}
		Arrays.sort(edgeArray);
	}
	
	static public void UnionFind() {
		int cnt = 0;
		answer = 0;
		for(int i = 0; i < edgeArray.length; i++) {
			int from = edgeArray[i].from;
			int to = edgeArray[i].to;
			if(!union(from, to)) {
				continue;
			}
			
			answer += edgeArray[i].dist;
			if(++cnt == N-1) {
				answer = Math.round(answer * taxRate);
				return;
			}
		}
	}
	
	static public void printEdgeArray() {
		System.out.println();
		for(int i = 0; i < edgeArray.length; i++) {
			System.out.println(edgeArray[i].from + " " +  edgeArray[i].to + " " + edgeArray[i].dist);
		}
		System.out.println();
	}
	
	static public boolean union(int idx1, int idx2) {
		int root1 = find(idx1);
		int root2 = find(idx2);
		
		if(root1 == root2) {
			return false;
		}
		set[root1] = root2;
		return true;
	}
	
	static public int find(int idx) {
		if(set[idx] == idx) return idx;			
		return find(set[idx]);
	}
	
	static class Island{
		int x, y;

		public Island(int x) {
			this.x = x;
		}
		public Island(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge>{
		int from, to;
		long dist;

		public Edge(int from, int to, long dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist , o.dist);
		}
		
		
	}
}