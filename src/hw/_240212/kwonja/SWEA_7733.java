package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733 {
	static int[] dx= {0,1,-1,0};
	static int[] dy= {1,0,0,-1};
	static Queue<Pair> q  = new ArrayDeque<Pair>();
	static int[][] board;
	static int[][] liveCheese;
	static int n;
	static int res=Integer.MIN_VALUE;
	static int count;
	static int maxn=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			n= Integer.parseInt(br.readLine());
			board = new int[n][n];
			liveCheese = new int[n][n];
			maxn=Integer.MIN_VALUE;
			res=Integer.MIN_VALUE; //최대값 초기화를 안해줘서 오래걸림 ㅠㅠ
			for(int i=0;i<n;i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
					maxn=Math.max(maxn, board[i][j]);
				}
			}
			
			for(int i=0;i<=maxn;i++)
			{
				count=0;
				for(int j=0;j<n;j++)
				{
					for(int h=0;h<n;h++)
					{
						if(board[j][h]>i && liveCheese[j][h]==0)
						bfs(j,h,i);
					}
				}
				res=Math.max(res,count);
				liveCheese = new int[n][n];
			}
			System.out.println("#" + test_case + " "+ res);
		}
		

	}
	public static void bfs(int x, int y,int taste)
	{
		q.offer(new Pair(x,y));
		System.out.println(x + " "+y + taste);
		liveCheese[x][y]=1;
		count++;
		while(!q.isEmpty())
		{
			int curx = q.peek().getX();
			int cury = q.peek().getY();
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nx=curx+ dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(board[nx][ny]<=taste || liveCheese[nx][ny]==1)continue;
				liveCheese[nx][ny]=1;
				q.offer(new Pair(nx,ny));
			}
		}
	}

}
