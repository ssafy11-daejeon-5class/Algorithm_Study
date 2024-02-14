package hw._240214.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 빵집 {

	static int R, C, answer;
	static int[][] maps;
	static StringTokenizer st;
	static int[] dr = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 0;

		maps = new int[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (temp.charAt(j) == '.') {
					maps[i][j] = 0;
				} else if (temp.charAt(j) == 'x') {
					maps[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		System.out.println(answer);
	}
	
	private static boolean dfs(int r, int c) {
		if (c == C - 1) {
			answer++;
			return true;
		}
		

		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			if (nr >= 0 && nr < R && maps[nr][c + 1] == 0) {
				maps[nr][c + 1] = 1;
				if (dfs(nr, c + 1)) return true;
//				maps[nr][c + 1] = 0;
			}
		}
		return false;
	}

}
