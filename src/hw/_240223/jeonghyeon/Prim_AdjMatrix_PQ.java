package hw._240223.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import hw._240223.jeonghyeon.Hanaro.Edge;

public class Prim_AdjMatrix_PQ {
	static int V, E;	
	static PriorityQueue<Vertex> pq = new PriorityQueue<>();
	static boolean[] visited;
	static int[][] adjMatrix;
	static int totalWeight;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {

		getInput();
		
		prim();
		
	}

	static public void getInput() throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new boolean[V];
		adjMatrix = new int[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = weight;
			adjMatrix[to][from] = weight;
		}
		
	}

	static public void prim() {
		int cnt = 0;
		totalWeight = 0;
		pq.offer(new Vertex(0, 0));
		
		while(!pq.isEmpty()) {
			Vertex vertex = pq.poll();
			if(visited[vertex.idx]) 
				continue;
			
			System.out.println("added vertex: " + vertex.idx + ", weight:" + vertex.weight);
			visited[vertex.idx] = true;
			totalWeight += vertex.weight;
			if(++cnt == V) {
				// 출력
				System.out.println(totalWeight);
				return;
			}
			
			for(int i = 0; i < V; i++) {
				if(adjMatrix[vertex.idx][i] < Integer.MAX_VALUE) {
					pq.offer(new Vertex(i, adjMatrix[vertex.idx][i]));
				}
			}
			
		}
		
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		int idx;
		int weight;

		public Vertex(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex v) {
			return this.weight - v.weight;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight , o.weight);
		}
		
		
	}

}
