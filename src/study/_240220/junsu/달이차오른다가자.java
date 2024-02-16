package study._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자 {

	static int N, M, answer;
	static char[][] maps;
	static StringTokenizer st;
	static int[] start;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;

		maps = new char[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				maps[i][j] = temp.charAt(j);
				if (maps[i][j] == '0') {
					start = new int[] { i, j };
					maps[i][j] = '.';
				}
			}
		}
		bfs(start[0], start[1]);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] v = new boolean[N][M][(1 << 6)];
		q.offer(new int[] { i, j, 0, 0 });		// row, column, count, key(Using Bit-Masking)
		v[i][j][0] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if (maps[ni][nj] == '.' && !v[ni][nj][cur[3]]) {
						v[ni][nj][cur[3]] = true;
						q.offer(new int[] {ni, nj, cur[2] + 1 , cur[3]});
					} else if(maps[ni][nj]>= 'a' && maps[ni][nj] <='f') { // 옮기려는 좌표에 열쇠가 있다면 -> 해당 칸에는 소문자가 있다
						int res = cur[3]|(1<<(maps[ni][nj]-'a'));
						if(!v[ni][nj][res]) {
							v[ni][nj][res] = true;
							q.offer(new int[] {ni, nj, cur[2] + 1, res});
						}
					} else if((maps[ni][nj]>= 'A' && maps[ni][nj] <='F') && !v[ni][nj][cur[3]]) { 	// 옮기려는 좌표에 문이 있다면 -> 해당 칸에는 대문자가 있다
						if((cur[3] & (1<<(maps[ni][nj]-'A'))) != 0) { 			// 해당 문의 열쇠가 있다면
							v[ni][nj][cur[3]] = true;
							q.offer(new int[] {ni, nj, cur[2] + 1, cur[3]});
						}
					} else if(maps[ni][nj] == '1') {
						answer = Math.min(answer, cur[2] + 1);
					}
				}
			}
		}

	}

}
