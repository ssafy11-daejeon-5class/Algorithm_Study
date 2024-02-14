package hw._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] chemicals = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			chemicals[i][0] = Integer.parseInt(st.nextToken());
			chemicals[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(chemicals, (o1, o2) -> o1[0] - o2[0]);

		int answer = 1;
		int minTemp = chemicals[0][0];
		int maxTemp = 10001;

		for (int i = 0; i < N; i++) {
			if (chemicals[i][0] > maxTemp) {
				minTemp = chemicals[i][0];
				maxTemp = 10001;
				answer++;
			}

			maxTemp = Math.min(maxTemp, chemicals[i][1]);

		}

		System.out.println(answer);
	}
}
