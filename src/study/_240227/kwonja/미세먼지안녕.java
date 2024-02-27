package study._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미세먼지안녕 {
	static class Pair{
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	/*
	 * 미세먼지 확산이 먼저 일어나고, 공기청정기가 작동한다
	 */
	static int r,c,t;
	static int[][] board;
	static int[][] tempboard;
	static List<Pair> dust;
	static Pair[] cleaner = new Pair[2];
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int[] downdx= {1,0,-1,0};
	static int[] downdy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		r =Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		t =Integer.parseInt(st.nextToken());
		board = new int[r][c];
		int check=0;
		for(int i=0;i<r;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==-1)cleaner[check++]=new Pair(i,j);
			}
		}
		for(int i=0;i<t;i++)
		{
			find();
			All_dust_sperad();
			copy();
			print(board);
			up_rotation(cleaner[0].x, cleaner[0].y, 0);
			down_rotation(cleaner[1].x, cleaner[1].y, 0);
			System.out.println();
			print(board);
		}
		System.out.println(sum());
		
	}
	public static void print(int[][] board)
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void All_dust_sperad()
	{
		tempboard = new int[r][c];
		for(int i=0;i<dust.size();i++)
		{
			Pair p = dust.get(i);
			sperad(p.x, p.y);
		}
	}
	
	//확산된 먼지 원래 판에 대입
	public static void copy()
	{
		//미세먼지
		for(int i=0;i<r;i++)
		{
			board[i]=Arrays.copyOf(tempboard[i],c);
		}
		//청소기 위치
		board[cleaner[0].x][cleaner[0].y]=-1;
		board[cleaner[1].x][cleaner[1].y]=-1;
	}
	//먼지 확산
	public static void sperad(int x ,int y)
	{
		int count=0;
		//미세먼지 확산
		for(int i=0;i<4;i++)
		{
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			if(nx<0 || nx>=r || ny<0 || ny>=c)continue;//확산불가
			if(board[nx][ny]==-1)continue; //청소기도 확산불가
			tempboard[nx][ny]+=(board[x][y]/5);
			count++;
		}
		tempboard[x][y]+=board[x][y]-(board[x][y]/5)*count;
		
	}
	public static void find()
	{
		dust = new ArrayList<>();
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				//이동하기 전 먼지들 구하기
				if(board[i][j]>0)
				{
					dust.add(new Pair(i,j));
				}
					
			}
		}	
	}
	public static void up_rotation(int x ,int y,int rot)
	{
		
		//청소기 부터 위 오른쪽 아래 왼쪽으로 이동
		
		int nx = x + dx[rot];
		int ny = y + dy[rot];
		//방향전환
		if(nx<0 || nx>cleaner[0].x || ny<0 || ny>=c)
		{
			up_rotation(x, y, rot+1);
		}
		//다시 돌아올때
		else if(board[nx][ny]==-1)
		{
			board[x][y]=0;
		}
		//잘 도착했을때
		else
		{
			if(board[x][y] != -1)
			{
				board[x][y] = board[nx][ny];			
			}
			up_rotation(nx, ny, rot);
		}
		
	}
	public static void down_rotation(int x ,int y,int rot)
	{
		
		//청소기 부터 위 오른쪽 아래 왼쪽으로 이동
		
		int nx = x + downdx[rot];
		int ny = y + downdy[rot];
		//방향전환
		if(nx<cleaner[1].x || nx>=r || ny<0 || ny>=c)
		{
			down_rotation(x, y, rot+1);
		}
		//다시 돌아올때
		else if(board[nx][ny]==-1)
		{
			board[x][y]=0;
		}
		//잘 도착했을때
		else
		{
			if(board[x][y] != -1)
			{
				board[x][y] = board[nx][ny];			
			}
			down_rotation(nx, ny, rot);
		}
		
	}
	public static int sum()
	{
		int count=0;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(board[i][j]>0)count+=board[i][j];
			}
		}
		return count;
	}

}
