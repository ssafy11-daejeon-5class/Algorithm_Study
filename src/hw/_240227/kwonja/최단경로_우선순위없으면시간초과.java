package hw._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_우선순위없으면시간초과 {
	/*
	 * 
	 * 다익스트라를 배워보자!
	 * 인접리스트 / 우선순위큐X
	 * 
	 * 
	 * 1. end에 가중치를 가지고 있는 인접리스트를 만들자!
	 * (인접리스트는 링크드 리스트가 더 효율적이다!)
	 */
	
	static class Node{
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
		
		
	}
	static int V,E;
	static int startNode;
	static List<Node>[] adjList;
	static int[] minDistance;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		startNode=Integer.parseInt(br.readLine());
		
		//그래프 초기화
		adjList = new LinkedList[V+1];
		
		for(int i=1;i<=V;i++)
		{
			adjList[i]= new LinkedList<>();
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
		//탐색은 V번 진행한다.
		
		for(int i=1;i<=V;i++)
		{
			int min=Integer.MAX_VALUE;
			int stopOver=-1;
			//1.step 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			for(int j=1;j<=V;j++)
			{
				if(!visited[j] && min>minDistance[j])
				{
					min=minDistance[j];
					stopOver=j;
				}
			}
			//더이상 찾을 정점이 없을때
			if(stopOver == -1)break;
			//가장 가중치가 짧은 정점을 찾았다면 방문 처리를 해준다.
			visited[stopOver]=true;
			//2.step 방문처리한 노드에서 거리를 새로 갱신
			// d[v] = d[stopOver] + adjList[stopOver][v]
			
			for(int j=0;j<adjList[stopOver].size();j++)
			{
				if(!visited[adjList[stopOver].get(j).end] 
						&& minDistance[adjList[stopOver].get(j).end] > minDistance[stopOver] + adjList[stopOver].get(j).weight)
				{
					minDistance[adjList[stopOver].get(j).end] = minDistance[stopOver] + adjList[stopOver].get(j).weight;
				}
			}
		}
//		System.out.println(Arrays.toString(minDistance));
		for(int i=1;i<=V;i++)
		{
			System.out.print(minDistance[i] != Integer.MAX_VALUE ? minDistance[i] +"\n" : "INF" +"\n");
		}
		
		
	}

}
