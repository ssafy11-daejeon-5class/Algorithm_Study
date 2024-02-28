package hw._240228.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {
	static int T, west, east;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			west = Integer.parseInt(st.nextToken());
			east = Integer.parseInt(st.nextToken());
			dp = new int[west][east];
			for (int i = 0; i < west; i++) {
				dp[i][i] = 1;
			}
			for (int i = 0; i <= east - west; i++) {
				dp[0][i] = i + 1;
			}
			sb.append(dp(west - 1, east - 1) + "\n");
		}
		System.out.println(sb);
	}

	private static int dp(int west, int east) {

		if (west < 0 || east < 0)
			return 0;
		if (dp[west][east] != 0)
			return dp[west][east];

		int cnt = 0;
		for (int e = west - 1; e < east; e++) {
			cnt += dp(west - 1, e);
		}

		return dp[west][east] = cnt;
	}

}
