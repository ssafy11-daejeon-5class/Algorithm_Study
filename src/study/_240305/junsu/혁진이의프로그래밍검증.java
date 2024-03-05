package study._240305.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 혁진이의프로그래밍검증 {

	static int mem, T, R, C;
	static String answer;
	static char[][] maps;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			maps = new char[R][C];

			for (int i = 0; i < R; i++) {
				String temp = br.readLine();
				for (int j = 0; j < C; j++) {
					maps[i][j] = temp.charAt(j);
				}
			}

			print();
			answer = null;
			mem = 0;
			func(0, 0, 0);
			System.out.printf("#%d %s\n", t, answer);
		}
	}

	static int[] 
	private static void func(int r, int c, int dir) {
		// TODO Auto-generated method stub

	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
