package ws._240229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {

	static int N, answer;
	static int[][] maps;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maps = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		recursive(0, 1, 0);
		System.out.println(answer);
	}

	private static void recursive(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			answer++;
			return;
		}
		switch(dir) {
		case 0:	
			// 가로 방향으로 들어왔을때 -> 가로, 대각선
			if(c+1 < N && maps[r][c+1] == 0) {
				recursive(r, c+1, 0);
			}
			if(r+1 < N && c+1 < N && maps[r][c+1] == 0 && maps[r+1][c] == 0 && maps[r+1][c+1] == 0) {
				recursive(r+1, c+1, 1);
			}
			break;
		case 1:
			// 대각선 방향으로 들어왔을때 -> 가로, 대각선, 세로
			if(c+1 < N && maps[r][c+1] == 0) {
				recursive(r, c+1, 0);
			}
			if(r+1 < N && c+1 < N && maps[r][c+1] == 0 && maps[r+1][c] == 0 && maps[r+1][c+1] == 0) {
				recursive(r+1, c+1, 1);
			}
			if(r+1 < N && maps[r+1][c] == 0) {
				recursive(r+1, c, 2);
			}
			break;
		case 2:
			// 세로 방향으로 들어왔을때 -> 대각선, 세로
			if(r+1 < N && c+1 < N && maps[r][c+1] == 0 && maps[r+1][c] == 0 && maps[r+1][c+1] == 0) {
				recursive(r+1, c+1, 1);
			}
			if(r+1 < N && maps[r+1][c] == 0) {
				recursive(r+1, c, 2);
			}
			break;
		}
	}
}