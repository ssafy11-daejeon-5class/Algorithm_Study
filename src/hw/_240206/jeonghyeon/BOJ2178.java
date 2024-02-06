package hw._240206.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	static char[][] miroh;
	static boolean[][] visited;
	static int R;
	static int C;
	static Queue<Kan> queue = new ArrayDeque<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		miroh = new char[R][C];
		for (int r = 0; r < R; r++) {
			miroh[r] = br.readLine().toCharArray();
		}

		// dfs(0, 0, 1); <- 시간초과
		bfs(0, 0, 1);

		System.out.println(answer);
	}

	static void bfs(int r, int c, int cnt) {
		queue.offer(new Kan(0, 0, 1));
		while (true) {
			Kan thisKan = queue.poll();
			if (thisKan.r == R - 1 && thisKan.c == C - 1) {
				answer = thisKan.cnt;
				return;
			}

			int[] nextR = { thisKan.r, thisKan.r + 1, thisKan.r, thisKan.r - 1 };
			int[] nextC = { thisKan.c + 1, thisKan.c, thisKan.c - 1, thisKan.c };
			for (int i = 0; i < 4; i++) {
				if (isInArea(nextR[i], nextC[i]) && canWeGo(nextR[i], nextC[i])) {
					if (!visited[nextR[i]][nextC[i]]) {
						visited[nextR[i]][nextC[i]] = true;
						queue.offer(new Kan(nextR[i], nextC[i], thisKan.cnt + 1));
					}
				}
			}
		}
	}

	static void dfs(int r, int c, int cnt) {
		if (r == R - 1 && c == C - 1) {
			answer = Math.min(answer, cnt);
			return;
		}

		int[] nextR = { r, r + 1, r, r - 1 };
		int[] nextC = { c + 1, c, c - 1, c };
		for (int i = 0; i < 4; i++) {
			if (isInArea(nextR[i], nextC[i]) && canWeGo(nextR[i], nextC[i])) {
				if (!visited[nextR[i]][nextC[i]]) {
					visited[nextR[i]][nextC[i]] = true;
					dfs(nextR[i], nextC[i], cnt + 1);
					visited[nextR[i]][nextC[i]] = false;
				}
			}
		}
	}

	static boolean canWeGo(int r, int c) {
		if (miroh[r][c] == '1') {
			return true;
		}
		return false;
	}

	static boolean isInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return false;
		return true;
	}
}

class Kan {
	public int r;
	public int c;
	public int cnt;

	Kan(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
