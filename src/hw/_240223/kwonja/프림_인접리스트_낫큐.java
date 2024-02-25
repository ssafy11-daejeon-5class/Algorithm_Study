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
public class 프림_인접리스트_낫큐 {
	
	static class Node{
		int no,weight;

		public Node(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    
		List<Node>[] graph = new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			graph[i]= new LinkedList<>();
		} //인접 리스트 초기화
		boolean[] visitied = new boolean[V]; //트리 정점 여부
		int [] minEdge = new int[V]; //비트리 정점 기준으로 트리 정점들과 연결했을 경우 최소 간선 비용
		
		
		for(int i=0;i<E;i++)
		{
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight =Integer.parseInt(st.nextToken());
			//양방향일때
			graph[start].add(new Node(end,weight));
			graph[end].add(new Node(start,weight));
		}
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0]=0; //임의의 시작점  0을 위해 처리 -> 0을 선택하기 위해서!
		int result=0; //최소 신장 트리 비용
		int c;
		//for ,while 둘다 상관 없다
		for(c=0;c<V;c++)
		{
			//step 1 : 비트리 정점 중 최소 간선 비용의 정점 찾기!
			int min = Integer.MAX_VALUE;
			int minVertex=-1;
			
			for(int i=0;i<V;i++)
			{
				if(!visitied[i] && minEdge[i]<min)
				{
					min = minEdge[i];
					minVertex=i;
				}
			}
			if(minVertex == -1)break; //트리를 만들수 없다
			result +=min; //간선 비용 누적
			visitied[minVertex]=true; //트리 정점에 포함
			
			
			//step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려 최적 업데이트
			
			for(int i=0;i<graph[minVertex].size();i++)
			{
				if(visitied[graph[minVertex].get(i).no])continue;
				//선택한 정점의 가중치가 기존보다 작다면 수정!
				if(graph[minVertex].get(i).weight < minEdge[graph[minVertex].get(i).no])
				{
					minEdge[graph[minVertex].get(i).no] = graph[minVertex].get(i).weight;
				}
			}
		
		}
		System.out.println(c==V ? result  : -1);

	}

}


