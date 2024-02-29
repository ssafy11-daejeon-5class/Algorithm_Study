package study._240228.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 파이프옮기기1 {

	static int N, answer;
	static char[][] maps;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maps = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = st.nextToken().charAt(0);
			}
		}

		recursive(0, 0, 0);

		System.out.println(answer);
	}

	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	
	private static void recursive(int r, int c, int direction) {
		if (r == N - 1 && c == N - 1) {
			return;
		}
		if(r+1 )
		
	}

}
