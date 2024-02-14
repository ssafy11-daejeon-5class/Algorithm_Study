package hw._240214.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992 {

	static char[][] arr;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			for(int j=0; j<N; j++)
			{
				arr[i][j] = str.charAt(j);
			}
		}
		
		// System.out.println(Arrays.deepToString(arr));
		dfs(0,0,N);
		System.out.print(sb);
		

	}

	private static void dfs(int x, int y, int s) {
		
		// basis part
		if(!check(x,y,s))
		{
			// 분할의 모든 쿼드가 다 같은 경우
			sb.append(arr[x][y]);
			return;
		}
		
		// inductive part
		
		int ns = s/2;
		
		sb.append("(");
		dfs(x,y, ns);
		
		dfs(x, y+ns, ns);
		
		dfs(x+ns, y, ns);
	
		dfs(x+ns, y+ns, ns);
		sb.append(")");
		
		
	}

	private static boolean check(int x, int y, int s) {
		
		char quad = arr[x][y];
		
		
		for(int i=x; i<x+s; i++)
		{
			for(int j=y; j<y+s; j++)
			{
				if(arr[i][j] !=quad)
				{
					// 색 다르면 더 쪼개자
					return true;
				}
			}
		}
		
		return false;
	}

}
