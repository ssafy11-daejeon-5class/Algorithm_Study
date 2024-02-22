package hw._240222.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Test {

	static class Edge implements Comparable<Edge>{
		
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	static int V;
	
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);

		} // 간선 리스트 생성
		
		Arrays.sort(edgeList);
		
		// 1. make-set
		parents = new int[V]; // 경로 압축을 안하면 부모를 가지는데, 경로 압축 하면 조상으로 붙는다
		
		make();
		
		int weight=0;
		int cnt=0;
		// 2. 정렬된 간선을 하나씩 꺼내어 신장트리 생성
		for (Edge edge : edgeList) {
			
			if(!union(edge.from, edge.to)) continue;
			weight += edge.weight;
			if(++cnt == V-1) break;
		}
		
		System.out.println(weight);

	}

	private static void make() {
	
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
	}
	
	public static int find(int a) // a가 속한 트리의 루트 찾기
	{
		if(a == parents[a])
		{
			return a;
		}
		
		return parents[a] = find(parents[a]); // 경로 압축
	}
	
	public static boolean union(int a, int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; // a와 b가 같은 트릐에 속해있음
		
		// 편향 트리 만들어질 수 있음
		parents[bRoot] = aRoot;
		
		return true;
		
		
	}
	

}
