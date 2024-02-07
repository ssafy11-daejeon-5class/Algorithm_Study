package hw._240207.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1861 {
/*
 * 정사각형 방
 */
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] board;
	static int[][] visitied;
	static int n;
	static int res=Integer.MIN_VALUE;
	static Queue<Pair> q= new ArrayDeque<Pair>();
	static int x,y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			StringTokenizer st =null;
			n =Integer.parseInt(br.readLine());
			board = new int[n][n];
			visitied = new int[n][n];
			res=Integer.MIN_VALUE;
			x=y=-1;
			for(int i=0;i<n;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					bfs(i,j);
					visitied = new int[n][n];
				}
			}
			System.out.println("#" +test_case +" "+board[x][y] +" "+res);
		}
		
	}
	private static void bfs(int startx ,int starty) {
		
		
		q.offer(new Pair(startx,starty));
		visitied[startx][starty]=1;
		while(!q.isEmpty())
		{
			int curx=q.peek().getX();
			int cury=q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(visitied[nx][ny]>0)continue;
				if((board[nx][ny]-board[curx][cury])==1)
				{
					q.offer(new Pair(nx,ny));
					visitied[nx][ny] = visitied[curx][cury]+1;
					if(visitied[nx][ny]==res)
					{
//						System.out.println(board[startx][starty] +" "+ res);
						res=visitied[nx][ny];
						if(x==-1)
						{
							x=startx;
							y=starty;
						}
						else if(board[startx][starty]<=board[x][y])
						{
							x=startx;
							y=starty;	
						}
					}else if(visitied[nx][ny] > res)
					{
						res=visitied[nx][ny];
						x=startx;
						y=starty;
					}
				}
			}
		}
	}

}
