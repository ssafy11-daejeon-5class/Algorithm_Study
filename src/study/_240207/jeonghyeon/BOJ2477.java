package study._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int[] lines = new int[6];
		int[] directions = new int[6];
		StringTokenizer st;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			directions[i] = Integer.parseInt(st.nextToken());
			lines[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++) {
			if (directions[i] == directions[(i + 2) % 6] && directions[(i + 1) % 6] == directions[(i + 3) % 6]) {
				int answer = (lines[(i + 4) % 6] * lines[(i + 5) % 6] - lines[(i + 1) % 6] * lines[(i + 2) % 6]) * K;
				System.out.println(answer);
				return;
			}
		}
	}
}
