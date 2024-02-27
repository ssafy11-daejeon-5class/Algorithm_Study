package hw._240223.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import hw._240223.jeonghyeon.Hanaro.Edge;
import hw._240223.jeonghyeon.Prim_AdjList_PQ.Vertex;

public class Prim_AdjList {
	static int V, E;	
	static boolean[] visited;
	static List<List<Vertex>> adjList;
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
		adjList = new ArrayList<List<Vertex>>();
		for(int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList.get(from).add(new Vertex(to, weight));
			adjList.get(to).add(new Vertex(from, weight));
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
			
			for(int i = 0; i < adjList.get(minNextVertex).size(); i++) {
				int nextIdx = adjList.get(minNextVertex).get(i).idx;
				int nextWeight = adjList.get(minNextVertex).get(i).weight;
				if(!visited[nextIdx] && nextWeight < minEdge[nextIdx]) {
					minEdge[nextIdx] = nextWeight;
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
