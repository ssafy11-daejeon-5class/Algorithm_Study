package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ_4963 {
	/*
	 * 섬의 개수
	 * 섬의 개수를 세어보자
	 */
	static int[][] board;
	static int[][] visited;
	static int[] dx= {0,1,-1,0,1,-1,-1,1};
	static int[] dy= {1,0,0,-1,1,-1,1,-1};
	static int w,h;
	static int res;
	static Queue<Pair> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0 && h==0)break;
			board = new int[h][w];
			visited = new int[h][w];
			res=0;
			for(int i=0;i<h;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
				{
					if(board[i][j]==1 && visited[i][j]==0)bfs(i,j);
				}
			}
			System.out.println(res);	
		}
		

	}
	public static void bfs(int x, int y)
	{
		q.offer(new Pair(x,y));
		visited[x][y]=1;
		res++;
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury = q.peek().getY();
			q.poll();
			for(int i=0;i<8;i++)
			{
				int nx =curx + dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
				if(board[nx][ny]==0 || visited[nx][ny]==1)continue;
				q.offer(new Pair(nx,ny));
				visited[nx][ny]=1;
			}
			
		}
	}

}
