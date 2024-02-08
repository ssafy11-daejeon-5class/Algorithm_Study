package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.*;

public class BOJ_2563 {
	static int n;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] visitied =new int[110][110];
	static int [][] board= new int[110][110];
	static int width,startx,starty;
	static Queue<Pair> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++)
		{
			StringTokenizer st =new StringTokenizer(br.readLine());
			startx =Integer.parseInt(st.nextToken());
			starty =Integer.parseInt(st.nextToken());
			for(int j=startx;j<startx+10;j++)
			{
				for(int h=starty;h<starty+10;h++)
				{
					board[j][h]=1;
				}
			}
			
		}
		
		bfs();
		System.out.println(width);

	}
private static void bfs() {
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(board[i][j]==1 && visitied[i][j]==0)
				{
					q.offer(new Pair(i,j));
					visitied[i][j]=1;
					while(!q.isEmpty())
					{
						int curx=q.peek().getX();
						int cury=q.peek().getY();
						q.poll();
						width++;
						for(int h=0;h<4;h++)
						{
							int nx = curx + dx[h];
							int ny = cury + dy[h];
							if(nx<0 || nx>=100 || ny<0 || ny>=100)continue;
							if(visitied[nx][ny] ==1 || board[nx][ny]==0)continue;
							q.offer(new Pair(nx,ny));
							visitied[nx][ny]=1;
						}
					}
				}
			}
		}
	}

}
