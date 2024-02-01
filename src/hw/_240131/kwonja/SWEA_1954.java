package hw._240131.kwonja;


import java.util.Scanner;

public class SWEA_1954 {
	static int[][] board;
	static int[] dx = new int[]{ 0,1,0,-1 };
	static int[] dy = new int[]{ 1,0,-1,0};
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int test_case = 1; test_case <= T; ++test_case)
		{
			n=sc.nextInt();
			board = new int[n][n];
			dfs(0,0,0,0,0);
			System.out.print("#"+test_case+"\n");
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					System.out.print(board[i][j] +" ");
				}
				System.out.print("\n");
			}
		}

	}
	
	public static void dfs(int x, int y, int prex,int prey, int idx)
	{
		board[x][y] = board[prex][prey] + 1;
		int curx = x;
		int cury = y;
		int nx = curx + dx[idx];
		int ny = cury + dy[idx];
		if (nx < 0 || nx >= n || ny < 0 || ny >= n)
		{
			idx = idx + 1;
			idx = idx % 4;
		}
		else if (board[nx][ny] != 0) {
			idx = idx + 1;
			idx = idx % 4;
		}
		else {
			dfs(nx, ny, curx, cury, idx);
		}
		for (int i = idx; i < 4; i++)
		{
				int nx1 = curx + dx[i];
				int ny1 = cury + dy[i];
				if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n)continue;
				if (board[nx1][ny1] != 0)continue;
				dfs(nx1, ny1,curx,cury,i); //
		}
	}

}
