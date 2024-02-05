package study._240205.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

	static int N, L, R, cnt;
	static int[][] maps;
	static StringTokenizer st;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		maps = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		migration();

	}

	private static void migration() {
		// TODO Auto-generated method stub
		cnt = 0;
		visited = new boolean[N][N];
		while (movePeople()) {
			cnt++;
			visited = new boolean[N][N];
		}
		System.out.println(cnt);
	}

	private static boolean movePeople() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		return false;
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> visit = new ArrayDeque<>();
		int[] arr = new int[2];
		arr[0] = i;
		arr[1] = j;

		int count = 1;
		int sum = maps[i][j];

		q.offer(arr);
		while (!q.isEmpty()) {
			int[] info = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = info[0] + di[k];
				int nj = info[1] + di[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
					int gap = Math.abs(maps[ni][nj] - maps[info[0]][info[1]]);
					if (gap >= L && gap <= R) {
						q.offer(new int[] { ni, nj });
						visit.offer(new int[] { ni, nj });
						sum += maps[ni][nj];
						count++;
					}
				}
			}
		}
		
		while(!visit.isEmpty()) {
			int[] temp = visit.poll();
			maps[temp[0]][temp[1]] = sum / count;
		}

	}
}
