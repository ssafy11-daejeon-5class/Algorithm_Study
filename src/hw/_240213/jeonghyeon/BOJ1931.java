package hw._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				if (o1[0] == o1[1])
					return 1;
				else if (o2[0] == o2[1])
					return -1;
				return o2[0] - o1[0];
			}
			return o1[1] - o2[1];
		});

		int minVal = meetings[0][1];
		int cnt = 1;
		for (int idx = 1; idx < meetings.length; idx++) {
			if (minVal <= meetings[idx][0]) {
				minVal = meetings[idx][1];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
