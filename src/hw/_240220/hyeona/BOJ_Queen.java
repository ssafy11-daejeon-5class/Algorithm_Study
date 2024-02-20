package hw._240220.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Queen {

	
	static int N, Ans;
	
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		
		dfs(0);
		System.out.println(Ans);
		
		

	}
	private static void dfs(int x) {
		
		if(x == N)
		{
			Ans++;
			return;
		}
		
		
		for(int i=0; i<N; i++)
		{
			if(check_range(x, i))
			{
				// 하나를 놓으면 바로 다음행으로 가기 때문에 왼쪽은 확인할 필요가 없다
				arr[x][i] = 1;
				dfs(x+1);
				arr[x][i] = 0;
			}
		}
		
	}
	private static boolean check_range(int x, int y) {

		// 현재 좌표 : x, y
		// 상
		for(int i=x-1; i>=0; i--)
		{
			if(arr[i][y]==1) return false;
		}
		
		// 좌상 (x감소, y감소)
		for(int i=x, j=y; i>=0 && j>=0; i--, j--)
		{
			if(arr[i][j]==1) return false;
		}
		
		
		// 우상 (x감소, y증가)
		for(int i=x, j=y; i>=0 && j<N; i--, j++)
		{
			if(arr[i][j]==1) return false;
		}
		
		return true;
	}

}
