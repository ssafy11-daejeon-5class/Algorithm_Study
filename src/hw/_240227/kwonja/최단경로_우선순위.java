package hw._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_우선순위 {
	/*
	 * 
	 * 다익스트라를 배워보자!
	 * 인접리스트 / 우선순위큐X
	 * 그래프의 경우 중간에 삽입삭제가 없기때문에 ArrayList가 효과적이다!
	 * 
	 * 1. end에 가중치를 가지고 있는 인접리스트를 만들자!
	 * 
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
			//어째서 end가 작은것을 먼저 선택해야 통과하는가
			return Integer.compare(weight, o.weight);
		}
		
		
	}
	static int V,E;
	static int startNode;
	static List<Node>[] adjList;
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
		adjList = new ArrayList[V+1];
		
		for(int i=1;i<=V;i++)
		{
			adjList[i]= new ArrayList<>();
		}
		minDistance = new int[V+1]; //다익스트라는 minDistance라고 많이 쓴다.
		visited = new boolean[V+1];
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			//양방향
			adjList[start].add(new Node(end,weight));
//			adjList[end].add(new Node(start,weight));
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
			for(int j=0;j<adjList[minVertex.end].size();j++)
			{
				Node temp = adjList[minVertex.end].get(j);
				if(visited[temp.end])continue;
				if( minDistance[temp.end] > (minDistance[minVertex.end] + temp.weight))
				{
					minDistance[temp.end] = minDistance[minVertex.end] + temp.weight;
					pq.offer(new Node(temp.end, minDistance[temp.end]));
				}
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
        for (int i = 1; i < minDistance.length; i++) {
            if (minDistance[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(minDistance[i]).append("\n");
        }
        System.out.print(sb);
		
		
	}

}
