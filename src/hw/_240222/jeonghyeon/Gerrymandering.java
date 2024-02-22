package hw._240222.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Gerrymandering {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st;

		static int N;
		static int[] population;
		static boolean[][] adjMatrix;
		static int[] set;
		static int[] rank;
		static int[] selected;

		static boolean result = false;
		static int minValue = Integer.MAX_VALUE;

		static HashSet<Integer> group1 = new HashSet<>();
		static HashSet<Integer> group2 = new HashSet<>();

		public static void main(String[] args) throws Exception {
			N = Integer.parseInt(br.readLine());
			population = new int[N + 1];
			selected = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				population[i] = Integer.parseInt(st.nextToken());
			}

			adjMatrix = new boolean[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());

				int count = Integer.parseInt(st.nextToken());
				for (int j = 0; j < count; j++) {
					int next = Integer.parseInt(st.nextToken());
					adjMatrix[i][next] = true;
				}
			}

			for (int size = 1; size < N; size++) {	
				combination(0, 1, size);
			}
			
			if (result) {
				System.out.println(minValue);
			} else {
				System.out.println(-1);
			}

		}

		private static void combination(int cnt, int start, int size) {
			if (cnt == size) {
				group1.clear();
				group2.clear();

				for (int i = 0; i < size; i++) {
					group1.add(selected[i]);
				}

				for (int i = 1; i <= N; i++) {
					if (!group1.contains(i)) {
						group2.add(i);
					}
				}

				set = new int[N + 1];
				for (int i = 0; i <= N; i++) {
					set[i] = i;
				}
				rank = new int[N + 1];

				for (int i : group1) {
					for (int j = 0; j <= N; j++) {
						if (adjMatrix[i][j]) {
							if (!group2.contains(j)) {
								union(i, j);
							}
						}
					}
				}

				for (int i : group2) {
					for (int j = 0; j <= N; j++) {
						if (adjMatrix[i][j]) {
							if (!group1.contains(j)) {
								union(i, j);
							}
						}
					}
				}

				boolean flag = true;

				int root1 = -1;
				int sum1 = 0;

				for (int i : group1) {
					sum1 += population[i];

					if (root1 == -1) {
						root1 = find(i);
					} else {
						if (root1 != find(i)) {
							flag = false;
						}
					}
				}

				int root2 = -1;
				int sum2 = 0;

				for (int i : group2) {
					sum2 += population[i];

					if (root2 == -1) {
						root2 = find(i);
					} else {
						if (root2 != find(i)) {
							flag = false;
						}
					}
				}

				if (flag) {
					result = true;
					minValue = Math.min(minValue, Math.abs(sum1 - sum2));
				}

			} else {
				for (int i = start; i <= N; i++) {
					selected[cnt] = i;
					combination(cnt + 1, i + 1, size);
				}
			}
		}

		private static void union(int a, int b) {
			a = find(a);
			b = find(b);

			if (a != b) {
				if (rank[a] < rank[b]) {
					set[a] = b;
				} else {
					set[b] = a;
				}

				if (rank[a] == rank[b]) {
					rank[a]++;
				}
			}
		}
		
		public static int find(int e) {
			if (e == set[e])
				return e;
			return set[e] = find(set[e]);

		}
	}
