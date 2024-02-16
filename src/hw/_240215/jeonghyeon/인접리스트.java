package hw._240215.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 인접리스트 {
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 인접 리스트
		List<List<int[]>> list = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weigh = Integer.parseInt(st.nextToken());
			list.get(from).add(new int[] { to, weigh });
		}

		for (int i = 0; i < V; i++) {
			list.get(i).sort((o1, o2) -> o1[0] - o2[0]);
		}

		for (int i = 0; i < V; i++) {
			System.out.print("from " + i + " : ");
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(Arrays.toString(list.get(i).get(j)) + " ");
			}
			System.out.println();
		}

	}
}