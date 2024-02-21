package hw._240221.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ChangyongVillage_DisJointSet {
	static int N, M;
	static int[] set;
	static int[] height;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new int[N + 1];
			height = new int[N + 1];
			// make set
			for (int i = 1; i <= N; i++) {
				set[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				union(p1, p2);
			}

			Set<Integer> muri = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				muri.add(find(i));
			}
			sb.append("#" + t + " " + muri.size() + "\n");
		}
		System.out.println(sb);
	}

	private static void union(int org, int change) {
		int a = find(org);
		int b = find(change);
		if (a != b) {
			// set[a] = b;
			// rank;
			if (height[b] > height[a]) {
				set[a] = set[b];
			} else {
				set[b] = set[a];
				if (height[b] == height[a]) {
					height[a]++;
				}
			}
		}
	}

	private static int find(int org) {
		if (set[org] == org)
			return set[org];
		// path compression
		else
			return set[org] = find(set[org]);
	}

}
