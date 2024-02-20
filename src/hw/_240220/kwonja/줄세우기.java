package hw._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	/*
	 * 위상정렬을 공부해보자
	 */
	static int n,m;
	static List<Integer> student = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] inDegree;
	static Queue<Integer> pq  = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		//그래프 선언
		inDegree = new int[n+1];
		graph = new LinkedList[n+1];
		//그래프 초기화
		for(int i=1;i<=n;i++)
		{
			graph[i]=new LinkedList<>();
		}
		for(int i=0;i<m;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			//1->2 2는 1다음에 와야하는 순서를 가진다
			inDegree[end]++;
			
		}
		degreecheck();
		while(!pq.isEmpty())
		{
			int temp=pq.poll();
			student.add(temp);
			//선택된 노드가 연결하고 있는 노드들의 차수를 제거한다.

			for(int i=0;i<graph[temp].size();i++)
			{
				inDegree[graph[temp].get(i)]--;
				//여기다 안하면 큐가 멈추지 않는다
				if(inDegree[graph[temp].get(i)]==0)
				{
					pq.add(graph[temp].get(i));
					//선택한 간선은 다시 안쓰기때문에 리스트에서 삭제해줘야한다.
					//삭제를 안한 간선만큼 다시 들어올수 있기때문에 제거하니까 시초해결
					//근데 32000*320000해도 2초는 잘 통과하지않을까..? 생각중
					graph[temp].remove(i);
					i--;
				}
			}
			//전위차수 0이 되는친구 탐색
		}
		for(int i=0;i<student.size();i++)
		{
			System.out.print(student.get(i) +" ");
		}
		
	}
	public static void degreecheck()
	{
		for(int i=1;i<=n;i++)
		{
			if(inDegree[i]==0)//전입차수가 없는 노드를 고른다
			{
				pq.offer(i);
			}
		}
	}

}
