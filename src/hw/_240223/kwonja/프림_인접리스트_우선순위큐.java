package anything;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 * 
V E
from to weigh 의 순서

7 11
0 1 31
0 2 31
0 6 31
0 5 60
1 2 21
2 4 46
2 6 25
3 4 34
4 6 51
5 3 18
5 4 40
 * 
 * 
 */
public class 프림_인접리스트_우선순위큐 {
	
	static class Vertex implements Comparable<Vertex>{
		int no,weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    
		List<Vertex>[] adjList = new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adjList[i]= new LinkedList<>();
		}
		boolean[] visitied = new boolean[V]; //트리 정점 여부
		int [] minEdge = new int[V]; //비트리 정점 기준으로 트리 정점들과 연결했을 경우 최소 간선 비용
		
		
		for(int i=0;i<E;i++)
		{
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight =Integer.parseInt(st.nextToken());
			//양방향일때
			adjList[start].add(new Vertex(end, weight));
			adjList[end].add(new Vertex(start, weight));
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0]=0; //임의의 시작점  0을 위해 처리 -> 0을 선택하기 위해서!
		pq.offer(new Vertex(0, minEdge[0]));
		
		int result=0; //최소 신장 트리 비용
		int c=0;
		//for ,while 둘다 상관 없다
		while(!pq.isEmpty())
		{
			//step 1 : 비트리 정점 중 최소 간선 비용의 정점 찾기!
			Vertex minVertex = pq.poll();
			if(visitied[minVertex.no])continue;
			
			result +=minVertex.weight; //간선 비용 누적
			visitied[minVertex.no]=true; //트리 정점에 포함
			if(++c == V)break; //정점 기준이기때문에 v개를 만족하면 종료!
			
			//step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려 최적 업데이트
			for(int i=0;i<adjList[minVertex.no].size();i++)
			{
				if(visitied[adjList[minVertex.no].get(i).no])continue;
				if(adjList[minVertex.no].get(i).weight < minEdge[adjList[minVertex.no].get(i).no])
				{
					minEdge[adjList[minVertex.no].get(i).no]=adjList[minVertex.no].get(i).weight;
					pq.offer(new Vertex(adjList[minVertex.no].get(i).no, adjList[minVertex.no].get(i).weight));
				}
			}
		
		}
		System.out.println(Arrays.toString(visitied));
		System.out.println(c==V ? result  : -1);

	}

}

/*

5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 * 
 * 
 * 
 * 
 */
