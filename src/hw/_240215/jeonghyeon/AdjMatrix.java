package hw._240215.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdjMatrix {
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 인접 행렬
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weigh = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = weigh;
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}

		// 인접 리스트

		// 간선 리스트ㅁ

	}
}