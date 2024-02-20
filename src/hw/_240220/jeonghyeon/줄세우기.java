package hw._240220.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	static int N, M;
	static List<List<Integer>> list;
	static boolean[][] visited;
	static int cheezeCnt;
	static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			list.get(front).add(back);
			indegree[back]++;
		}

		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int current = queue.poll();
			result.add(current);
			for (int i = 0; i < list.get(current).size(); i++) {
				int temp = list.get(current).get(i);
				indegree[temp]--;
				if (indegree[temp] == 0) {
					queue.add(temp);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
			sb.append(" ");
		}
		System.out.println(sb);

	}

//	static public class comeToMe {
//		int me;
//		List<Integer> backPeople;
//
//		public comeToMe(int me) {
//			this.me = me;
//			this.backPeople = new ArrayList<>();
//		}
//
//		public comeToMe(int me, List<Integer> backPeople) {
//			this.me = me;
//			this.backPeople = backPeople;
//		}
//
//	}
}
