package hw._240215.kwonja;

import java.io.*;
import java.util.*;

public class 무선충전 {
	/*
	 * 무선 충전
	 */
	
	static int t;
	static int[] play1,play2;
	static Pair player1;
	static Pair player2;
	static int[][][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int m,a,x,y,c,p;
	static int[] movex ={0,-1,0,1,0};
	static int[] movey={0,0,1,0,-1};
	static Queue<Point> q = new ArrayDeque<>();
	static int res;
	public static void main(String[] args) throws Exception, IOException {
	
		
	//각 배터리에 대한 배열을 생성한다-> 엄청난 메모리 낭비일거같지만
	//각 배터리 영역을 배열에 표시한다.
		
	//주어진 방향을 배열에 넣고 각각 1번씩 이동한다
	//이동한 좌표에 대해서 3개의 배열을 체크하고 겹치지 않는다면 그대로 더한다
	//겹치는 부분이 있으면 해당 겹치는 배터리의 퍼포먼스를 계산한다
	//직관적으로 나눠가지는게 최대값이 아니긴하다
	//이렇게 모든 방향을 움직이고 결과를 출력한다
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	t=Integer.parseInt(br.readLine());
	
	for(int test_case=1;test_case<=t;test_case++)
	{
		StringTokenizer st =new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		a=Integer.parseInt(st.nextToken());
		play1=new int[m];
		play2=new int[m];
		board = new int[11][11][a];
		res=0;
		player1=new Pair(1,1);
		player2=new Pair(10,10);
		st =new StringTokenizer(br.readLine());
		for(int j=0;j<m;j++)
		{
			play1[j]=Integer.parseInt(st.nextToken());
		}
		st =new StringTokenizer(br.readLine());
		for(int j=0;j<m;j++)
		{
			play2[j]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<a;i++)
		{
			st =new StringTokenizer(br.readLine()); //배터리 위치 및 성능
			//x,y가 반대이다...
			y=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			p=Integer.parseInt(st.nextToken());
			bfs(i);
		}
		playermove();
		System.out.println("#" + test_case + " "+res);
//		print();
	}
		
}
	public static void bfs(int i)
	{
		q.offer(new Point(x,y,0));
		board[x][y][i]=p; //충전량
		
		while(!q.isEmpty())
		{
			int curx = q.peek().x;
			int cury = q.peek().y;
			int curcnt=q.peek().cnt;
			q.poll();
			for(int j=0;j<4;j++)
			{
				int nx= curx+dx[j];
				int ny = cury+dy[j];
				if(nx<1 || nx>10 || ny<1 || ny>10)continue;
				if(board[nx][ny][i]!=0 || curcnt>=c)continue;
				q.offer(new Point(nx,ny,curcnt+1));
				board[nx][ny][i]=p;
			}
		}
	}
	
	//
	public static void playermove()
	{
		check();
		//m번 이동
		for(int i=0;i<m;i++)
		{
			//A형 player 이동
			int nx = movex[play1[i]]+player1.x;
			int ny = movey[play1[i]]+player1.y;
			player1=new Pair(nx,ny);
			//B형 player 이동
			int nx1 = movex[play2[i]]+player2.x;
			int ny1 = movey[play2[i]]+player2.y;
			player2=new Pair(nx1,ny1);
			
			//이동한 위치에 대해서 어떻게 충전해야 최대값이 되는지 계산
			check();
		}
	}
	//위치에 대해서 충전량 계산
	public static void check()
	{
		//위치한 배터리가 있는지 계산 2개이상 겹친게 없기 때문에 겹쳤다면 나눠서 더하는게 가장 크다고 생각한다.
		//만약에 둘다 2개가 겹치는곳에 있을때는 둘중에 큰걸 선택해야한다.
		
		//배터리 위치를 체크하면서 완전탐색 A를 기준으로
		int max=0;
		for(int i=0;i<a;i++)
		{
			// A가 배터리에 있을때
			int sum=0;
			if(board[player1.x][player1.y][i]>0)
			{
				sum=board[player1.x][player1.y][i];
				for(int j=0;j<a;j++)
				{
					if(i!=j && board[player2.x][player2.y][j]>0)
					{
						max=Math.max(max, sum+board[player2.x][player2.y][j]);
					}
				}
				max=Math.max(max, sum);
			}
		}
		for(int i=0;i<a;i++)
		{
			// B가 배터리에 있을때
			int sum=0;
			if(board[player2.x][player2.y][i]>0)
			{
				sum=board[player2.x][player2.y][i];
				for(int j=0;j<a;j++)
				{
					if(i!=j && board[player1.x][player1.y][j]>0)
					{
						max=Math.max(max, sum+board[player1.x][player1.y][j]);
					}
				}
				max=Math.max(max, sum);
			}
		}
		res+=max;
//		System.out.println(res);
	}
	public static void print()
	{
		for(int h=0;h<a;h++)
		{
			for(int i=1;i<=10;i++)
			{
				for(int j=1;j<=10;j++)
				{
					System.out.print(board[i][j][h] +" ");
				}
				System.out.println();
			}
			System.out.println("=====================");
		}
	}
}
class Point
{
	int x;
	int y;
	int cnt;
	public Point(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
}
