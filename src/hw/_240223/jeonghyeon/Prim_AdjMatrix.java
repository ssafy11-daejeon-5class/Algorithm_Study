package hw._240223.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import hw._240223.jeonghyeon.Hanaro.Edge;

public class Prim_AdjMatrix {
	static int V, E;	
	static boolean[] visited;
	static int[][] adjMatrix;
	static int[] minEdge;
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
		minEdge = new int[V];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
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
		minEdge[0] = 0;
		
		
		for(int j = 0; j < V; j++) {
			
			int minWeight = Integer.MAX_VALUE;
			int minNextVertex = -1;
			
			for(int i = 0; i < V; i++) {
				if(!visited[i] && minEdge[i] < minWeight) {
					minWeight = minEdge[i];
					minNextVertex = i;
				}
			}
			
			if(minNextVertex == -1) 
				break;
			visited[minNextVertex] = true;
			totalWeight += minWeight;			
			System.out.println("added vertex: " + minNextVertex + ", weight:" + minWeight);
			
			if(++cnt == V) {
				// 출력
				System.out.println(totalWeight);
				return;
			}
			
			for(int i = 0; i < V; i++) {
				if(!visited[i] && adjMatrix[minNextVertex][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minNextVertex][i];
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
	

}
