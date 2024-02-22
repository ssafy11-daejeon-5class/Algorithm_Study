package hw._240222.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리 {	//	SWEA_3124

	static class Edge {
		int s, e, w;
		
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	
	static int T, V, E;
	static long answer;
	static Edge[] edgeList;
	static StringTokenizer st;
	static int[] set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			answer = 0;
			
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(s, e, weight);
			}
			
			// 전처리 edge 오름차순 정렬
			Arrays.sort(edgeList , (a,b) -> Integer.compare(a.w, b.w));
			
			// makeSet
			set = new int[V + 1];
			for (int i = 0; i <= V; i++) {
				set[i] = i;
			}
			
			int cnt = 0; // 만들어진 간선 개수
			for (Edge e: edgeList) {
				if(!unionSet(e.s, e.e)) {
					continue;
				} else {
					answer += e.w;
					if(cnt == V - 1) {
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}		
	}

	private static boolean unionSet(int s, int e) {
		int a = find(s);
		int b = find(e);
		if(a == b) {
			return false;
		} else {
			set[a] = b;
			return true;
		}
	}

	private static int find(int s) {
		if(set[s] == s) return s;
		else return set[s] = find(set[s]);
	}
}

