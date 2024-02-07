package hw._240206.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_BFS {
	/*
	 * 미로 탐색
	 * BFS는 Level 별로 탐색하기때문에 먼저 도착한다
	 */
	static int n,m;
	static int[][] board;
	static int[][] dist;
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static Queue<Pair> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		board=new int[n][m];
		dist = new int[n][m];
		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<m;j++)
			{
				board[i][j]=str.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.print(dist[n-1][m-1]);
		
	}
	public static void bfs(int x, int y) {
		q.offer(new Pair(x,y));
		dist[x][y]=1;
		while(!q.isEmpty())
		{
			int curx=q.peek().getX();
			int cury=q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx=curx + dx[i];
				int ny =cury+ dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=m)continue;
				if(dist[nx][ny] > 0 || board[nx][ny]==0)continue;
				q.offer(new Pair(nx,ny));
				dist[nx][ny]=dist[curx][cury]+1;
			}
			
		}
		
	}

}
