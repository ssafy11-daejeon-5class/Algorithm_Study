package hw._240327.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일이삼더하기 {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[11 + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append(dp(Integer.parseInt(br.readLine())) + "\n");
		}
		
		System.out.println(sb.toString());
	}

	static int dp(int N) {

		if (dp[N] == 0) {
			dp[N] = dp(N-1) + dp(N-2) + dp(N-3);
		}
		return dp[N];
	}

}

/*
 * 
 * 
 * 1 : 1 2 : 2 3 : 4
 * 
 * 
 * 
 */