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
public class 간선리스트_크루스칼 {
	
	static public class Edge implements Comparable<Edge>{
		int start;
		int to;
		int weight;
		public Edge(int start, int to, int weight) {
			super();
			this.start = start;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
		
	}
	static int[] root;
	static int V,E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Edge[] edgeList = new Edge[E];
		root = new int[V];
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken()); //가중치는 일단 보류
			edgeList[i]=new Edge(start, to, weight);
		}
		Arrays.sort(edgeList);
		
		make_set();
		int cnt=0;
		int weight=0;
		
		for(int i=0;i<E;i++)
		{
			if(union_set(edgeList[i].start, edgeList[i].to))
			{
				
				weight += edgeList[i].weight;
				if(cnt++==V-1)break;
			}
		}
		System.out.println(weight);
	}
	public static void make_set()
	{
		for(int i=0;i<V;i++)
		{
			root[i]=i;
		}
	}
	public static int find_set(int a)
	{
		if(root[a]==a)return a;
		else return root[a]=find_set(root[a]);
	}
	public static boolean union_set(int  a ,int b)
	{
		int aRoot = find_set(a);
		int bRoot = find_set(b);
		if(aRoot == bRoot)return false;
		root[aRoot]=bRoot;
		return true;
	}
	
	
}
