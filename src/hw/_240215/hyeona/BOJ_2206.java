package hw._240215.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단 경로 : bfs

// 다 부숴봐야하나 ? No. N과 M의 범위가 크다
// 벽을 만났을 때, 어떤 벽을 부숴야하나 



// 최단 경로니까 N-1, M-1에 가장 먼저 도착하는 길이 최단 경로겠쥐


// N-1, M-1 에 도달했으면 정답 출력 후 종료

// 문제 : 큐가 비어서 끝나버린다

/* 벽을 뿌수고 도착한 x,y -> 이게 먼저 도착해서 방문처리를 해버리면
벽을 뿌수지 않고 도착한 x,y가 나중에 도착했을 때 큐에 안들어감 ㅜㅜ

-> 큐가 비기 전에 visited[x][y]를 되돌려야함 !
-> 3차원 방문 배열이 필요하다


*
*
*/

class Point{
	int x;
	int y;
	int wall;
	int dist;
	
	public Point(int x, int y, int wall, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.wall = wall;
		this.dist = dist;
	}
}


public class BOJ_2206 {

	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	static int[][] arr;
	static boolean[][][] visited;
	
	static int N, M, Ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			for(int j=0; j<M; j++)
			{
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		bfs(0,0,0,1);
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);


	}

	private static void bfs(int x, int y, int wall, int dist) {
		
		Queue<Point> queue = new LinkedList<>();
		
		// 안부수고 왔을 때 [0]
		visited[x][y][0]= true;
		queue.offer(new Point(x, y, 0, dist));
		
		while(!queue.isEmpty())
		{
			Point p = queue.poll();
			x = p.x;
			y = p.y;
			wall = p.wall;
			dist = p.dist;
			
			
			if(x == N-1 && y == M-1)
			{
				Ans = dist;
				break;
			}
			
			for(int i=0; i<4; i++)
			{
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M)
				{
					// 길일 때, 그냥 간다
					if(arr[nx][ny]==0 && !visited[nx][ny][wall])
					{
						visited[nx][ny][wall] = true;
						queue.offer(new Point(nx, ny, wall, dist+1));
					}

					// 벽을 부쉈는데 벽을 지나가면 못 지나감 !
					// 벽일 때, 부술건지 말건지 ㅋ
					else if(arr[nx][ny]==1 && wall ==0)
					{
						visited[nx][ny][1] = true;
						queue.offer(new Point(nx, ny, 1, dist+1));
					}
				}
			}

		}
		
	}

}
