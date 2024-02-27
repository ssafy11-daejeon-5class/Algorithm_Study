package hw._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_우선순위_인접행렬 {
	/*
	 * 
	 * 다익스트라를 배워보자!
	 * 인접리스트 / 우선순위큐X
	 * 
	 * 
	 * 1. end에 가중치를 가지고 있는 인접리스트를 만들자!
	 * (인접리스트는 링크드 리스트가 더 효율적이다!)
	 */
	
	static class Node implements Comparable<Node>{
		int end,weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
	}
	static int V,E;
	static int startNode;
	static int[][] adjMatrix;
	static int[] minDistance;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		startNode=Integer.parseInt(br.readLine());
		
		//그래프 초기화
		adjMatrix = new int[V+1][V+1];
		minDistance = new int[V+1]; //다익스트라는 minDistance라고 많이 쓴다.
		visited = new boolean[V+1];
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjMatrix[start][end]=weight;
		}
		
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[startNode]=0; //출발지에서 출발지로 가는것은 0으로 한다
		pq.offer(new Node(startNode,0));
		int c=0;
		while(!pq.isEmpty())
		{
			Node minVertex = pq.poll();
			if(visited[minVertex.end])continue; //방문했던 점이면
			visited[minVertex.end]=true;
			if(++c == V)break; 
			for(int j=1;j<=V;j++)
			{
				if(visited[j])continue;
				if(adjMatrix[minVertex.end][j]==0)continue;
				if(minDistance[j] > adjMatrix[minVertex.end][j] + minDistance[minVertex.end])
				{
					minDistance[j]=adjMatrix[minVertex.end][j] + minDistance[minVertex.end];
					pq.offer(new Node(j,minDistance[j]));
				}
			}
			
		}
		
	
//		System.out.println(Arrays.toString(minDistance));
		for(int i=1;i<=V;i++)
		{
			System.out.println(minDistance[i] != Integer.MAX_VALUE ? minDistance[i] : "INF");
		}
		
		
	}

}
