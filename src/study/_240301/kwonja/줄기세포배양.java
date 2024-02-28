package study._240301.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	
	static int n,m,k;
	static int ans;
	static int time=0;
	static int[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static PriorityQueue<Point> pq;
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
			if(checktime == o.checktime)
			{
				return o.lifetime-this.lifetime ;
			}
			return Integer.compare(checktime, o.checktime);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++)
		{
			time=0;
			board= new int[400][400];
			ans=0;
			pq = new PriorityQueue<>();
			st=new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			k= Integer.parseInt(st.nextToken());
			for(int i=180;i<180 + n;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=180;j<180+ m;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
					//초기값 세팅
					if(board[i][j]!=0) pq.offer(new Point(i, j, board[i][j],board[i][j]));
				}
			}
			//탐색 시작!
			bfs();
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	public static void bfs()
	{
		while(!pq.isEmpty())
		{
			if(time==k)break;
			Point p = pq.peek();
			if(p.checktime>time)
			{
				time++;
				continue;
			}
			pq.poll();
			//time == lifetime 활성 상태가 된다면
			int curx = p.x;
			int cury = p.y;
			for(int i=0;i<4;i++)
			{
				int nx = curx +dx[i];
				int ny = cury +dy[i];
				if(board[nx][ny]>0)continue; //이미 세포가 있으면 방문x
				pq.offer(new Point(nx, ny,p.lifetime,time + p.lifetime + 1));
				board[nx][ny]=time + p.lifetime *2; //큐에 넣은 친구는 방문하지 못함
			}
		}
		print();
	}
	public static void print()
	{
		for(int i=0;i<400;i++)
		{
			for(int j=0;j<400;j++)
			{
				if(board[i][j]>=time)ans++;
//				System.out.print(board[i][j] + " ");
			}
//			System.out.println();
		}
	}

}
