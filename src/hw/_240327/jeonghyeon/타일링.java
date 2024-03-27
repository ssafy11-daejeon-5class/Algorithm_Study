package hw._240327.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 타일링 {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+2];
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.println(dp(N) % 10007);
	}

	static int dp(int N) {

		if (dp[N] != 0) {
			return dp[N];
		}
		return dp[N] = dp(N-1) + dp(N-2);
	}

}

