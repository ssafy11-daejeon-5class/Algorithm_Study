package hw._240215.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Chess{
	int x, y, dist;

	public Chess(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	
}
public class BOJ_7562 {

	
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int start_x, start_y, end_x, end_y, I;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0; i<T; i++)
		{
			I = Integer.parseInt(br.readLine());
			arr = new int[I][I];
			visited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());
			
			bfs(start_x, start_y);

		}

	}
	private static void bfs(int x, int y) {
		
		Queue<Chess> queue = new LinkedList<>();
		queue.offer(new Chess(x, y, 0));
		visited[x][y] = true;
		
		while(!queue.isEmpty())
		{
			Chess p = queue.poll();
			
			if(p.x == end_x && p.y == end_y)
			{
				System.out.println(p.dist);
				break;
			}
			
			for(int i=0; i<8; i++)
			{
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<I && ny<I)
				{
					if(!visited[nx][ny])
					{
						visited[nx][ny]=true;
						queue.offer(new Chess(nx, ny, p.dist+1));
						
					}
				}
			}
		}
		
	}

}
