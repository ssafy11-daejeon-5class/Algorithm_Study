package hw._240327.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 계단오르기 {
	static int N;
	static int[][] dp;
	static int[] stairs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];
		stairs = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		if(N == 1) {
			System.out.println(stairs[1]);
			return;
		}
		
		dp[1][0] = stairs[1];
		dp[2][0] = stairs[2];

		dp(1, 0);
		dp(2, 0);
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}

	static void dp(int idx, int dimension) {

		if(dimension == 0) {
			if(idx+1 <= N && dp[idx+1][1] <= dp[idx][0] + stairs[idx+1]) {
				dp[idx+1][1] = dp[idx][0] + stairs[idx+1];
				dp(idx+1, 1);
			}
			if(idx+2 <= N && dp[idx+2][0] <= dp[idx][0] + stairs[idx+2]) {
				dp[idx+2][0] = dp[idx][0] + stairs[idx+2];
				dp(idx+2, 0);
			}
		}

		if(dimension == 1) {
			if(idx+2 <= N && dp[idx+2][0] <= dp[idx][1] + stairs[idx+2]) {
				dp[idx+2][0] = dp[idx][1] + stairs[idx+2];
				dp(idx+2, 0);
			}
		}
		
	}
}