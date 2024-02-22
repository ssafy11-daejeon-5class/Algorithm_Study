package hw._240222.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimumSpanningTree {
	static int V, E;
	static Edge[] edgeList;
	static int[] set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			set = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				set[i] = i;
			}

			Arrays.sort(edgeList);

			for (Edge edge : edgeList) {
				System.out.println("list : " + edge.from + " " + edge.to + " " + edge.weight);
			}

			int cnt = 0;
			long totalLength = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					totalLength += edge.weight;
					System.out.println(edge.from + " " + edge.to);
					if (++cnt == V - 1) {
						sb.append("#" + t + " " + totalLength + "\n");
						break;
					}
				}
			}

		}
		System.out.println(sb);
	}

	public static boolean union(int e1, int e2) {
		int e1Root = find(e1);
		int e2Root = find(e2);
		if (e1Root == e2Root)
			return false;

		set[e1Root] = e2Root;
		return true;
	}

	public static int find(int e) {
		if (e == set[e])
			return e;
		return set[e] = find(set[e]);
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}

	}

}
