package study._240205.sungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 * SWEA 줄기 세포 배양
 * 우선순위 큐를 배우고 다시해보자!
 */
public class SWEA_5563 {
	
	
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int[][] board = new int[350][350];
	static int[][] visitied = new int[350][350];
	static int timer;
	static Queue<Ceil> q = new LinkedList<>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			for(int i=0;i<n;i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
				{
					board[150 + i][150 +j]=Integer.parseInt(st.nextToken());
					if(board[150 + i][150 +j] != 0)
					{
						q.offer(new Ceil(150+i,150+j,timer));
						board[150 + i][150 +j]=1; //방문 처리
					}
				}
			}
			//배양 시작
			bfs();
		}
	}
	public static void bfs()
	{
		int qsize =q.size();
		timer++;
		
		while(true)
		{
			//한번씩 이동할수 있는지 확인한다.
			for(int i=0;i<q.size();i++)
			{
				int curx =q.peek().getX();
				int cury =q.peek().getY();
				
				
				for(int j=0;j<4;j++)
				{
					int nx= curx+dx[j];
					int ny = cury+dy[j];
					if(nx<0 || nx>=350 || ny<0 || ny>=350)continue;
					if(visitied[nx][ny]==1 || board[ny][ny]!=0) continue; //배양을 했다면 패스
					
					
					//활성일때
					
					//비활성 일때
					
					//죽었을때
					q.offer(new Ceil(ny,ny,timer));//배양
					board[ny][ny]=board[curx][cury];
				}
			}
		}
		//q에 들어 있는 대기열이 한번씩 다 돌면 1시간치 배양이 진행된다.
		//배양이 시작할때 timer를 올리고, 증식할수 있는지 판단
		//판단 방법
		//현재 타이머-증식해서 비활성화 될때의 시간    board[i][j]이상 board[i][j]*2 미만 가능
	}
}


class Ceil{
	private int x;
	private int y;
	private int time;
	public Ceil(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}

