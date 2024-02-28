package hw._240228.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//dfs 완전탐색 -> n이 15,16정도 까지만 가능하다-> 가지를 친다고하면 할만하다 정도?
// 파이프 옮기기 2는 n이 32까지 있다 -> 완전탐색이 어렵다 -> DP를 사용해야한다!
public class 파이프옮기기1 {
	
	static int n;
	static int[][] board;
	static int ans;
	static int[] dx= {0,1,1};
	static int[] dy= {1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		n= Integer.parseInt(br.readLine());
		board = new int[n][n];
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				board[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		print();
		dfs(0,1,0);
		System.out.println(ans);
		//탐색 시작
	}
	public static void dfs(int curx ,int cury ,int type)
	{
		//basis part
		if(curx==n-1 && cury==n-1)
		{
			ans++;
			return;
		}
		
		//inductive part
		
		// 현재 파이프가 가로 일때
		if(type == 0)
		{
			for(int i=0;i<2;i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(board[nx][ny] ==1 )continue; //벽
				if(i==1) //대각선으로 이동할때 가로세로도 확인해줘야함
				{
					int checkx =curx + dx[0];
					int checky =cury + dy[0];
					if(checkx<0 || checkx>=n || checky<0 || checky>=n)continue;
					if(board[checkx][checky] ==1 )continue;
					checkx =curx + dx[2];
					checky =cury + dy[2];
					if(checkx<0 || checkx>=n || checky<0 || checky>=n)continue;
					if(board[checkx][checky] ==1 )continue;
				}
				dfs(nx,ny,i);
			}
		}
		//대각선일때
		if(type == 1)
		{
			for(int i=0;i<3;i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(board[nx][ny] ==1 )continue; //벽	
				if(i==1) //대각선으로 이동할때 가로세로도 확인해줘야함
				{
					int checkx =curx + dx[0];
					int checky =cury + dy[0];
					if(checkx<0 || checkx>=n || checky<0 || checky>=n)continue;
					if(board[checkx][checky] ==1 )continue;
					checkx =curx + dx[2];
					checky =cury + dy[2];
					if(checkx<0 || checkx>=n || checky<0 || checky>=n)continue;
					if(board[checkx][checky] ==1 )continue;
				}
				dfs(nx,ny,i);
			}
		}
		//세로일때
		if(type == 2)
		{
			for(int i=1;i<3;i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(board[nx][ny] ==1 )continue; //벽
				if(i==1) //대각선으로 이동할때 가로세로도 확인해줘야함
				{
					int checkx =curx + dx[0];
					int checky =cury + dy[0];
					if(checkx<0 || checkx>=n || checky<0 || checky>=n)continue;
					if(board[checkx][checky] ==1 )continue;
					checkx =curx + dx[2];
					checky =cury + dy[2];
					if(checkx<0 || checkx>=n || checky<0 || checky>=n)continue;
					if(board[checkx][checky] ==1 )continue;
				}
				dfs(nx,ny,i);
			}
		}
		
		
	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
