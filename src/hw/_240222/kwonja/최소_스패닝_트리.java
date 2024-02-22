package hw._240222.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
		
	}
	static int V,E;
	static Edge[] edgeList;
	static int[] boss;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++)
		{
			st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			
			boss = new int[V+1];
			for(int i=0;i<E;i++)
			{
				st=new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i]=new Edge(from,to,weight);
			}
			Arrays.sort(edgeList);
//			System.out.println(Arrays.toString(edgeList));
			make_set();
			long weight=0;
			int cnt=0;
			
			
			for(int i=0;i<E;i++)
			{
				if(union_set(edgeList[i].from, edgeList[i].to))
				{
					weight += edgeList[i].weight;
					if(cnt++==V-1)break; //v-1만큼 간선의 개수를 구하면 끝이다.
				}
			}
			System.out.println("#" + test_case + " "+ weight);
			
		}
		
		

	}
	public static void make_set()
	{
		for(int i=1;i<=V;i++)
		{
			boss[i]=i;
		}
	}
	public static int find(int a)
	{
		if(a==boss[a])return a;
		else return boss[a]=find(boss[a]);
	}
	//보스를 바꿔주는걸 잊지말자
	public static boolean union_set(int a,int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)return false; //두개가 같으면 싸이클
		boss[aRoot]=bRoot;
		
		return true; //
		
	}

}
