package hw._240215.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집void {
	static int R;
	static int C;
	static char[][] map;
	static int flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int answer = 0;

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		for (int i = 0; i < R; i++) {
			if (map[i][1] == '.') {
				map[i][1] = '*';
				flag = 0;
				dfs(i, 1);
				if (flag == 1)
					answer++;

			}
//			for (int k = 0; k < R; k++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[k][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

		}
		System.out.println(answer);

	}

	private static void dfs(int r, int c) {
		if (c == C - 1) {
			flag = 1;
			return;
		}

		int[] nr = new int[] { r - 1, r, r + 1 };
		int nc = c + 1;

		for (int i = 0; i < 3; i++) {
			if (nr[i] < R && nr[i] >= 0 && map[nr[i]][nc] == '.') {
				map[nr[i]][nc] = '*';
				dfs(nr[i], nc);
				if (flag == 1) {
					return;
				}
			}
		}
	}

}
