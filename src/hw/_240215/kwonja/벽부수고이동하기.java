package hw._240215.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
	static int n,m,Ans=Integer.MAX_VALUE;
	static int[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		board= new int[n+1][m+1];
		for(int i=1;i<=n;i++)
		{
			st = new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=1;j<=m;j++)
			{
				board[i][j]=str.charAt(j-1)-'0';
			}
		}
		bfs();
		print();
		System.out.println(Ans ==Integer.MAX_VALUE ? -1 : Ans);
		
	}
 	
 	public static void bfs()
 	{
 		Queue<Point> Q = new ArrayDeque<>();
 		Q.offer(new Point(1,1,1,0));
 		boolean[][][]v = new boolean[n+1][m+1][2];
 		
 		//부시지 않았을때 0
 		//부셨을때 1
 		v[1][1][0]=true;
 		while(!Q.isEmpty())
 		{
 			
 			Point p=Q.poll();
 			if(p.r==n && p.c==m)
 			{
 				//몇칸만에 왔는지 Ans에 저장
 				Ans=p.cnt;
 				break;
 			}
 			for(int i=0;i<4;i++)
 			{
 				int nr=p.r+dx[i];
 				int nc=p.c+dy[i];
 				if(nr>=1 && nr<=n && nc>=1 && nc<=m)
 				{
 					//길인경우
 					//그냥간다.
 					if(board[nr][nc]==0 && !v[nr][nc][p.puk])
 					{
 						v[nr][nc][p.puk]=true;
 	 					Q.add(new Point(nr,nc,p.cnt+1,p.puk));	
 					}
 					//벽을 부신다
 					else if(board[nr][nc]==1 && p.puk==0)
 					{
 						v[p.r][p.c][1]=true;
 						v[nr][nc][1]=true;
 						Q.add(new Point(nr,nc,p.cnt+1,1)); 						
 					}
 					
 					//벽을 부셨다면 안부시기
 					
 				}
 			}
 		}
 	}
 	public static void print()
 	{
 		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
 	}
}

//class Point{
//	int r,c,cnt,puk;
//	public Point(int r,int c,int cnt,int puk) {
//		this.r=r;
//		this.c=c;
//		this.cnt=cnt;
//		this.puk=puk;
//		
//	}
//}
