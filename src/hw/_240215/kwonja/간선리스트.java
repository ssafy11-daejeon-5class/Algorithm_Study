package hw._240215.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class 간선리스트 {
	
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
			if(this.start ==o.start)
			{
				return this.to-o.to;
			}
			return this.start-o.start;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edgeList = new Edge[E];
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken()); //가중치는 일단 보류
			edgeList[i]=new Edge(start, to, weight);
		}
		Arrays.sort(edgeList);
		for(int i=0;i<E;i++)
		{
			System.out.println( "[" + i +"] " + edgeList[i]);
		}
	}
}
