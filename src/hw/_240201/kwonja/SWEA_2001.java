package hw._240201.kwonja;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_2001 {
	static int[][] arr;
	static int[][] dp;
	static int res;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input1.txt"));
		Scanner sc =new Scanner(System.in);
		
		int T= sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			arr=new int[n+1][n+1];
			dp=new int[n+1][n+1];
			res=Integer.MIN_VALUE;
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
				}
			}
			for(int i=1;i<=n-m+1;i++)
			{
				for(int j=1;j<=n-m+1;j++)
				{
					int totalkill = dp[i+m-1][j+m-1]-dp[i+m-1][j-1]-dp[i-1][j+m-1]+dp[i-1][j-1];
					res=Math.max(res, totalkill);
				}
			}
			System.out.print("#"+test_case +" "+res+"\n");
		}
	}

}
