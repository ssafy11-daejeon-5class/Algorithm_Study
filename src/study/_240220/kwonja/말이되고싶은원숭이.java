package study._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class 말이되고싶은원숭이 {
	static int k,Ans=Integer.MAX_VALUE;
	static int r,c;
	static int[][] board;
	static int[][][] visitied;
	static Queue<Point> q = new ArrayDeque<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int[] horx = {1,2,2,1,-2,-1,-2,-1};
	static int[] hory = {2,1,-1,-2,1,2,-1,-2};
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		c=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
		visitied = new int[r][c][k+1];
		for(int i=0;i<r;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs(0,0);
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
		
	}
 	public static void bfs(int x, int y)
 	{
 		q.offer(new Point(x,y,0));
 		visitied[x][y][0]=1;
 		
 		while(!q.isEmpty())
 		{
 			int curx =  q.peek().x;
 			int cury = q.peek().y;
 			int curcnt = q.peek().cnt;
 			q.poll();
 			if(curx==r-1 && cury==c-1)
 			{
 				Ans = visitied[curx][cury][curcnt]-1;
 				return;
 			}
 			
 			//원숭이가 걸어갈때
 			for(int i=0;i<4;i++)
 			{
 				int nx=curx+dx[i];
 				int ny=cury+dy[i];
 				if(nx<0 || nx>=r || ny<0 || ny>=c)continue;
 				if(visitied[nx][ny][curcnt]>0 || board[nx][ny]==1)continue;
 				q.offer(new Point(nx, ny, curcnt));
 				visitied[nx][ny][curcnt]= visitied[curx][cury][curcnt]+1;
 			}
 			
 			//원숭이가 말처럼 이동할때
 			if(curcnt<k)
 			{
 				for(int i=0;i<8;i++)
 	 			{
 	 				int nx=curx+horx[i];
 	 				int ny=cury+hory[i];
 	 				if(nx<0 || nx>=r || ny<0 || ny>=c)continue;
 	 				//원숭이가 점프할 곳이 3번점프해서 갔던곳이면 먼저 들어간것이기때문에 최소값으로써 방문할 필요가 없다
 	 				//visitied[nx][ny][curcnt]>0 만약 뒤로 점프한다면 이미 방문을 했으니 점프하지 않는다는 의미인듯
 	 				//
 	 				if(visitied[nx][ny][curcnt+1]>0 || board[nx][ny]==1)continue;
 	 				q.offer(new Point(nx, ny, curcnt+1));
 	 				visitied[nx][ny][curcnt+1]=visitied[curx][cury][curcnt]+1;
 	 			}
 			}
 		}
 	}

}

class Point{
	int x,y;
	int cnt;
	public Point(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
	}
	
}
