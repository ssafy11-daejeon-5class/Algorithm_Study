package hw._240228.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=t;test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			//mCn 구하기!
			int[][] combi = new int[m+1][m+1];
			
			for(int i=0;i<=m;i++)
			{
				combi[i][0]=combi[i][i]=1;
				for(int j=1;j<i;j++)
				{
					combi[i][j]=combi[i-1][j-1]+combi[i-1][j];
				}
			}
			System.out.println(combi[m][n]);
		}

	}

}
