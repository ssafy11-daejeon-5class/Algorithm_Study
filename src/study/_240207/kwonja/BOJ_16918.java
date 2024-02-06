package study._240207.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.*;

public class BOJ_16918 {
 /*
 * 봄버맨
 * 폭탄을 큐에 넣는다->처음
 * 전부 폭탄으로 채워 넣음 -> 2초
 * 폭탄을 터트린다, 남은 폭탄을 채워 큐에 채운다 -> 3초
 * 전부 폭탄으로 채워 넣음 -> 4초
 * 폭탄을 터트린다, 남은 폭탄을 채워 큐에 채운다 -> 5초
 * 폭탄으로 채워넣는다 -> 6초
 * 
 * 짝수는 폭탄을 채우고
 * 홀수는 폭탄을 터트리고 남은 폭탄을 채워 큐에 채운다
 */
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static char[][] board;
	static int r,c,n;
	static int timer=1;
	static Queue<Pair> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		for(int i=0;i<r;i++)
		{
			st= new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			for(int j=0;j<c;j++)
			{
				board[i][j]=str.charAt(j);
				if(board[i][j]=='O')q.offer(new Pair(i,j));
			}
		}
		
		while(timer<=n) //n초 후 라서 n에서 작업을 하고 멈춘다
		{
			if(timer!=1) //1초는 봄버맨이 쉰다.
			{
				//전체에 폭탄 세팅
				if(timer % 2 ==0) insertBomb();
				else {
					//폭탄터트리기
					BombBomb();
					//폭탄 큐에 넣기
					BombSetQueue();				
				}	
			}
			timer++;
		}
		Print();
		
		

	}
	public static void BombBomb()
	{
		//폭탄에 인접한 board 제거
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury= q.peek().getY();
			q.poll();
			board[curx][cury]='.'; //자기자신도 제거
			for(int i=0;i<4;i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=r || ny<0 || ny>=c)continue;
				board[nx][ny]='.'; //폭탄제거
			}
		}
		
	}
	public static void insertBomb()
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				board[i][j]='O';
			}
		}
	}
	public static void BombSetQueue()
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(board[i][j]=='O')q.offer(new Pair(i,j));
			}
		}
	}
	public static void Print()
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}


