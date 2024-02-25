package hw._240226.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로_크루스칼 {
	
	static class Custom implements Comparator<Edge>
	{

		@Override
		public int compare(Edge o1, Edge o2) {
			return Double.compare(o1.weight, o2.weight);
		}

		
		
	}
	static int n;
	static int[] dx;
	static int[] dy;
	static double E;
	static int[] root;
	static int[] sel= new int[2];
	static double answer;
	static PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>(new Custom());
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int t =Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=t;test_case++)
		{
			n= Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			dx=new int[n];
			dy=new int[n];
			root = new int[n];
			edgeList = new PriorityQueue<Edge>(new Custom());
			for(int i=0;i<n;i++)
			{
				dx[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
			{
				dy[i]=Integer.parseInt(st.nextToken());
			}
			E=Double.parseDouble(br.readLine());
			combination(0, 0);
			make_set();
			int cnt =0;
			answer=0.0;
//			print();
			while(true)
			{
				Edge edge = edgeList.poll();
				if(union_set(edge.from,edge.to))
				{
					cnt++;
					answer += edge.weight;
//					System.out.println(answer);
				}
				if(cnt==n-1)break;
			}
			System.out.println("#" + test_case + " " + Math.round(E*answer));
			
			
			
		}
	}
	
	public static void make_set()
	{
		for(int i=0;i<n;i++)
		{
			root[i]=i;
		}
	}
	public static int find_set(int a)
	{
		if(root[a]==a)return a;
		else return root[a]=find_set(root[a]);
	}
	public static boolean union_set(int a, int b)
	{
		int aRoot = find_set(a);
		int bRoot = find_set(b);
		if(aRoot ==bRoot)return false;
		root[aRoot]=bRoot;
		return true;
	}
	
	
	public static void combination(int idx, int k)
	{
		if(k==2)
		{
			// 뽑은 2개에 대한 가중치를 간선리스트에 저장
			// 인덱스가 정점처럼 생각!
			int from = sel[0];
			int to =sel[1];
			double weight = (Math.pow( Math.abs(dx[from]-dx[to]),2) + Math.pow( Math.abs(dy[from]-dy[to]),2));
			edgeList.add(new Edge(from, to, weight));
			return;
		}
		if(idx==n) //전체를 넘어가면 생략
		{
			return;
		}
		sel[k]=idx;
		combination(idx+1, k+1);
		combination(idx+1, k);
	}
	public static void print()
	{
		while (!edgeList.isEmpty()) {
			System.out.println(edgeList.poll());
		}
	}

}



//각 섬
class Edge{
	int from,to;
	double weight;
	public Edge(int from, int to, double weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	
	
}


