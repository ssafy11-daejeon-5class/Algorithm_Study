package hw._240206.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point
{
	int x; 
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class BOJ_2178 {

	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			for(int j=0; j<M; j++)
			{
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		//visited[0][0]=true;
		//dfs(0,0);
		//System.out.println(min);
	}
	

	public static void dfs(int r, int c)
	{
		// basis part
		if(r == N-1 && c == M-1)
		{
			//System.out.println(arr[r][c]);
			min = Math.min(min,  arr[r][c]);
			return;
		}
		
		// inductive part
		for(int i=0; i<4; i++)
		{
			int nx = r + dx[i];
			int ny = c + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M)
			{
				if(!visited[nx][ny] && arr[nx][ny] !=0)
				{
					visited[nx][ny] = true;
					arr[nx][ny] = arr[r][c]+1;
					dfs(nx, ny);
					visited[nx][ny] = false;
				}
			}
		}
		
	}
	
	public static void bfs(int x, int y)
	{
	
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty())
		{
			Point point = queue.poll();
			int r = point.x;
			int c = point.y;
			
			if(r==N-1 && c == M-1)
			{
				System.out.println(arr[r][c]);
				break;
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = r + dx[i];
				int ny = c + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M)
				{
					if(!visited[nx][ny] && arr[nx][ny] !=0)
					{
						queue.offer(new Point(nx, ny));
						visited[nx][ny] = true;
						arr[nx][ny] = arr[r][c]+1;
					}
				}
			}
		}

	}
}
