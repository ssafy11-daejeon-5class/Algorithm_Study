package hw._240327.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일로만들기 {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[1] = 1;
		
		System.out.println(dp(N) - 1);
	}
	
	static int dp(int N) {
		 
		if (dp[N] == 0) {
			// 6으로 나눠지는 경우 
			if (N % 6 == 0) {
				dp[N] = Math.min(dp(N - 1), Math.min(dp(N / 3), dp(N / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (N % 3 == 0) {
				dp[N] = Math.min(dp(N / 3), dp(N - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (N % 2 == 0) {
				dp[N] = Math.min(dp(N / 2), dp(N - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = dp(N - 1) + 1;
			}
		}
		return dp[N];
	}
	
}
/*
82 41 40 20 10 5 4 2 1
82 81 27 9 3 1


*/