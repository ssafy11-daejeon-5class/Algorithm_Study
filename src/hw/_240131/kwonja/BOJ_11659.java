package hw._240131.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr=new int[n];
		dp= new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		for(int i=1;i<n;i++)
		{
			dp[i]=arr[i]+dp[i-1];
		}
		for(int i=0;i<m;i++)
		{
			st=new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int res=dp[end]-dp[start]+arr[start];
			System.out.print(res +"\n");
		}
	}
}
