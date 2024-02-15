package study._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

	static int N, answer, count, sec;
	static StringTokenizer st;
	static int[][] maps;
	static int size = 2;
	static int[] di = new int[] { -1, 1, 0, 0 };
	static int[] dj = new int[] { 0, 0, -1, 1 };
	static int[] start;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maps = new int[N][N];
		answer = 0;
		count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 9) {
					start = new int[] { i, j };
				}
			}
		}
		
		bfs(start);
		bfs(start);
		bfs(start);
		bfs(start);
//		while(bfs(start)) {
//			continue;
//		}
		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean bfs(int[] s) {
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[N][N];
		List<int[]> cand = new ArrayList<>();
		
		q.offer(new int[] {s[0], s[1], 1});
		v[s[0]][s[1]] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
					if(maps[ni][nj] == 0 || maps[ni][nj] == size) {
						v[ni][nj] = true;
						q.offer(new int[] {ni, nj, cur[2] + 1});
					}
					if(maps[ni][nj] < size && maps[ni][nj] != 0) {
						v[ni][nj]= true;
						sec = cur[2];
						cand.add(new int[] {ni, nj, cur[2]});
					}
				}
			}
		}
		if(cand.size() != 0) {
			cand.sort((a,b)-> a[2] == b[2]? a[0] == b[0]?Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]):Integer.compare(a[2], b[2]));
			for (int[] is : cand) {
				System.out.println(Arrays.toString(is));
			}
			count++;
			answer += sec;
			if(count == size) {
				count = 0;
				size++;
			}
			System.out.println(cand.get(0)[0] + " " + cand.get(0)[1]);
			maps[cand.get(0)[0]][cand.get(0)[1]] = 0;
			start = new int[] {cand.get(0)[0], cand.get(0)[1]};
			return true;
		}
		return false;
	}
}
