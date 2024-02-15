package study._240213.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	/*
	 * 배열 돌리기
	 * 배열을 기가막히게 돌려보자
	 * 
	 * 문제에 기가막힌 조건이 존재했다
	 * min(N, M) mod 2 = 0
	 * 둘중에 작은수가 짝수 -> 짝수가 있으면 무조건 한바퀴가 도는것으로 끝난다.
	 * 홀수면 안돌고 일찍선인 경우가 생기는데 이를 방지하기 위해 만들어진 조건인듯 ㄷㄷㄷ
	 */
	static int n,m,r;
	static int[][] board;
	static int[][] Newboard;
	static int[][] visitied;
	//하 우 상 좌
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		board=new int[n][m];
		visitied=new int[n][m];
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int test_case=1;test_case<=r;test_case++)
		{
			Newboard=new int[n][m];
			int i=0;
			while( i<n && i<m)
			{
				if(visitied[i][i]==0)dfs(i,i,i,i,0);
				i++;
			}
			visitied=new int[n][m];
			for(int j=0;j<n;j++)
			{
				for(int h=0;h<m;h++)
				{
					board[j][h]=Newboard[j][h];
				}
			}
		}
		print();
	}
	
	public static void dfs(int curx,int cury,int prex,int prey,int rot)
	{
//		System.out.println(curx + " " + cury + " " + prex + " " + prey);
		//숫자대입
		Newboard[curx][cury]=board[prex][prey];
		int nx=curx+dx[rot];
		int ny=cury+dy[rot];
		if(nx<0 || nx>=n || ny<0 || ny>=m || visitied[nx][ny]==1) //벽에 부딪히면
		{
			//한바퀴돌았다 -> 종료
//			System.out.println(nx + " " + ny + "rot" + " : " + rot);
			if(rot == 3)
			{
				return;
			}
			//방향전환
			nx=curx+dx[rot+1];
			ny=cury+dy[rot+1];
			visitied[nx][ny]=1;
			dfs(nx,ny,curx,cury,rot+1);
		}
		else //앞으로 나아갈수 있으면
		{
			visitied[nx][ny]=1;
			dfs(nx,ny,curx,cury,rot);			
		}
		
	}
	public static void print()
	{
		for(int j=0;j<n;j++)
		{
			for(int h=0;h<m;h++)
			{
				System.out.print(board[j][h] +" ");
			}
			System.out.println();
		}
	}

}
