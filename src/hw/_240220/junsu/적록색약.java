package hw._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 적록색약 {

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] v;
	static boolean[][] vRG;
	static char[][] maps;
	static int N, answer, answerRG;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maps = new char[N][N];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				maps[i][j] = temp.charAt(j);
			}
		}

		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs(i, j, maps[i][j]);
					answer++;
				}
			}
		}

		vRG = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vRG[i][j]) {
					bfsRG(i, j, maps[i][j]);
					answerRG++;
				}
			}
		}

		System.out.println(answer + " " + answerRG);
	}

	private static void bfs(int i, int j, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && maps[ni][nj] == c && !v[ni][nj]) {
					q.offer(new int[] { ni, nj });
					v[ni][nj] = true;
				}
			}
		}
	}
	
	private static void bfsRG(int i, int j, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		vRG[i][j] = true;
		if(c == 'B') {			
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = cur[0] + di[k];
					int nj = cur[1] + dj[k];
					if (ni >= 0 && ni < N && nj >= 0 && nj < N && maps[ni][nj] == c && !vRG[ni][nj]) {
						q.offer(new int[] { ni, nj });
						vRG[ni][nj] = true;
					}
				}
			}
		} else {
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int k = 0; k < 4; k++) {
					int ni = cur[0] + di[k];
					int nj = cur[1] + dj[k];
					if (ni >= 0 && ni < N && nj >= 0 && nj < N && !vRG[ni][nj]) {
						if(maps[ni][nj] == 'R' || maps[ni][nj] == 'G') {							
							q.offer(new int[] { ni, nj });
							vRG[ni][nj] = true;
						}
					}
				}
			}
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
