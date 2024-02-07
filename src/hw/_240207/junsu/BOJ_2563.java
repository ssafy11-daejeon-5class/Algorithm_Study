package hw._240207.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2563 {	// 색종이

	static int N, x, y, answer;
	static boolean[][] maps;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maps = new boolean[101][101];
		answer = 0;

		for (int s = 0; s < N; s++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (i >= 0 && i < 100 && j >= 0 && j < 100) {
						maps[i][j] = true;
					}
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(maps[i][j]) answer++;
			}
		}
		
		System.out.println(answer);

	}

}
