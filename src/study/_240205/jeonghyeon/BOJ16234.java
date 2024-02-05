package study._240205.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16234 {
	static int N, L, R;
	static int[][] nations;
	static int[][] nextNations;
	static int[][] immigrants;
	static boolean[][] visited;
	static List<List<Integer>> movingList;
	static boolean isChanged;
	static int nationCnt = 0;
	static int sum = 0;
	static int cnt = 0;
	static int blockNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		nations = new int[N][N];
		for (int i = 0; i < N; i++) {
			nations[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		nextNations = nations.clone();
		for (int t = 0; t <= 2000; t++) {

			immigrants = new int[N][N];
			visited = new boolean[N][N];
			isChanged = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						sum = 0;
						cnt = 0;
						movingList = new ArrayList<>();
						openGukgyeong(i, j, ++blockNum);
						int newPopulation = sum / cnt;

						for (int k = 0; k < movingList.size(); k++) {
							if (nextNations[movingList.get(k).get(0)][movingList.get(k).get(1)] != newPopulation) {
								isChanged = true;
								nextNations[movingList.get(k).get(0)][movingList.get(k).get(1)] = newPopulation;
							}
						}
					}
				}
			}

			if (!isChanged) {
				System.out.println(t);
				break;
			}
			nations = nextNations.clone();
		}

	}

	static void openGukgyeong(int i, int j, int blockNum) {
		visited[i][j] = true;
		movingList.add(Arrays.asList(i, j));
		sum += nations[i][j];
		cnt++;

		int[][] canGo = { { i + 1, j }, { i - 1, j }, { i, j + 1 }, { i, j - 1 } };
		for (int[] next : canGo) {
			int r = next[0];
			int c = next[1];

			if (r < 0 || r >= N || c < 0 || c >= N) {
				continue;
			}
			if (visited[r][c]) {
				continue;
			}
			int diff = Math.abs(nations[i][j] - nations[r][c]);
			if (diff >= L && diff <= R)
				openGukgyeong(r, c, blockNum);
		}

	}
}
