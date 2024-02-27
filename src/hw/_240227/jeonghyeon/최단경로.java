package hw._240227.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author THKim
 *
 */

// 인접리스트 버전
public class 최단경로 {
	static class Node {
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); // 정점 갯수
		int E = Integer.parseInt(st.nextToken()); // 간선 갯수
		st = new StringTokenizer(in.readLine().trim());
		int start = Integer.parseInt(st.nextToken()) - 1;// 시작점 인덱스
		final int INF = Integer.MAX_VALUE;

		List<Node>[] adjList = new List[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		int[] minDinstance = new int[V];
		boolean[] visited = new boolean[V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
		} // 인접리스트 생성

		Arrays.fill(minDinstance, INF);
		minDinstance[start] = 0; // 출발지에서 출발지로의비용 0으로 초기화

		int min = 0, stopOver = 0;
		for (int i = 0; i < V; i++) { // 모든 정점이 다 처리될때까지 반복

			// step1 : 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			min = INF;
			stopOver = -1;

			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > minDinstance[j]) {
					min = minDinstance[j];
					stopOver = j;
				}
			}

			if (stopOver == -1)
				break;
			visited[stopOver] = true;
//			if(stopOver == end) break;  // 도착점이면 끝내기!!

			// step2 : 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소비용을 비교해서 업데이트
			for (Node temp : adjList[stopOver]) {
				if (minDinstance[temp.vertex] > min + temp.weight) {
					minDinstance[temp.vertex] = min + temp.weight;
				}
			}
		}

		for (int i = 0; i < V; i++) {
			System.out.println(minDinstance[i] != INF ? minDinstance[i] : "INF");
		}
	}

}