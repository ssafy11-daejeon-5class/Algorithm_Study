package study._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	
	static int n,m,k;
	static int time=0;
	static int[][] board= new int[500][500];
	static int[][] visited= new int[500][500];
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	static class Point implements Comparable<Point>{
		int x, y,lifetime,checktime;

		public Point(int x, int y, int lifetime,int checktime) {
			super();
			this.x = x;
			this.y = y;
			this.lifetime = lifetime;
			this.checktime=checktime;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(lifetime, o.lifetime);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++)
		{
			time=0;
			st=new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			k= Integer.parseInt(st.nextToken());
			for(int i=250;i<250 + n;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=250;j<250+ m;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
					//초기값 세팅
					pq.offer(new Point(i, j, board[i][j],board[i][j]));
					visited[i][j]=1; //큐에 넣은 친구는 방문하지 못함
				}
			}
			//탐색 시작!
			
		}
	}
	
	public static void bfs()
	{
		while(!pq.isEmpty())
		{
			Point p = pq.poll();
			if(p.lifetime>time)
			{
				time++;
				continue;
			}
			//time == lifetime 활성 상태가 된다면
			int curx = p.x;
			int cury = p.y;
			for(int i=0;i<4;i++)
			{
				int nx = curx +dx[i];
				int ny = cury +dy[i];
				if(visited[nx][ny]==1)continue; //이미 세포가 있으면 방문x
				pq.offer(new Point(nx, ny, ));
				visited[i][j]=1; //큐에 넣은 친구는 방문하지 못함
			}
		}
	}

}
