package hw._240131.kwonja;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
	static int[][] dp;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr=new int[n+1][n+1];
		dp= new int[n+1][n+1];
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());				
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dp[i+1][j+1]=dp[i][j+1]+dp[i+1][j]-dp[i][j]+arr[i][j];
			}
		}
		for(int i=0;i<m;i++)
		{
			st=new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			
			int res=dp[endx][endy]-dp[endx][starty-1]-dp[startx-1][endy]+dp[startx-1][starty-1];
			System.out.print(res +"\n");
		}
	}
}
