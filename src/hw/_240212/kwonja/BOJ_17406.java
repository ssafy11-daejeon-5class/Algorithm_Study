package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	/*
	 * 배열돌리기 4
	 * 배열을 야무지게 돌려보자!
	 */
	static int n,m,k;
	static int[][] board;
	static int[][] Newboard;
	static int[][] visitied;
	//우 하 좌 상
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static Way[] oper;
	static int[] opervisited;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		oper = new Way[k];
		opervisited = new int[k];		
		board=new int[n][m];
		visitied=new int[n][m];
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<k;i++)
		{
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int s= Integer.parseInt(st.nextToken());
			oper[i]=new Way(r-1, c-1, s);
		}
//		rotation(oper[0]);
		recursive(0, board);
		System.out.println(result);
	}
	
	public static void dfs(int curx,int cury,int prex,int prey,int rot,Way way, int[][] arr)
	{
		//숫자대입
		Newboard[curx][cury]=arr[prex][prey];
		int nx=curx+dx[rot];
		int ny=cury+dy[rot];
		
		if(nx<way.getR()-way.getS() || nx>way.getR()+way.getS() || ny<way.getC()-way.getS() || ny>way.getC()+way.getS() || visitied[nx][ny]==1) //벽에 부딪히면
		{
			//한바퀴돌았다 -> 종료
//			System.out.println(nx + " " + ny + "rot" + " : " + rot);
			if(rot == 3)
			{
				return;
			}
			nx=curx+dx[rot+1];
			ny=cury+dy[rot+1];
			//방향전환
			if(visitied[nx][ny]==1) //방향을 전환했음에도 갈수 없을때 -> 혼자일때
			{
				return;
			}
			visitied[nx][ny]=1;
			dfs(nx,ny,curx,cury,rot+1,way,arr);
		}
		else //앞으로 나아갈수 있으면
		{
			visitied[nx][ny]=1;
			dfs(nx,ny,curx,cury,rot,way,arr);			
		}
		
	}
	public static void recursive(int cnt,int[][] arr)
	{
		if(cnt==k)
		{
//			print(arr);
			result=Math.min(result,arrsum(arr));
			return;
		}
		for(int i=0;i<k;i++)
		{
			if(opervisited[i]==0)
			{
				int [][]map = new int[n][m];
				for(int j=0;j<n;j++)
				{
					for(int h=0;h<m;h++)
					{
						map[j][h]=arr[j][h];
					}
				}
				opervisited[i]=1;
				rotation(oper[i],map);
				recursive(cnt+1,map);
				opervisited[i]=0;
			}
		}
	}
	public static void rotation(Way way,int[][] arr)
	{
		Newboard=new int[n][m];
		int startx=way.getR()-way.getS();
		int starty=way.getC()-way.getS();
		while( startx <=way.getR() && starty <=way.getC())
		{
			if(visitied[startx][starty]==0)dfs(startx,starty,startx,starty,0,way,arr);
			startx++;
			starty++;
		}
		visitied=new int[n][m];
		//바꾼 내용 원래 배열에 담기
		for(int j=way.getR()-way.getS();j<=way.getR()+way.getS();j++)
		{
			for(int h=way.getC()-way.getS();h<=way.getC()+way.getS();h++)
			{
				arr[j][h]=Newboard[j][h];
			}
		}
	}
	public static void print(int[][] arr)
	{
		for(int j=0;j<n;j++)
		{
			for(int h=0;h<m;h++)
			{
				System.out.print(arr[j][h] +" ");
			}
			System.out.println();
		}
	}
	//어떤 배열의 현재 최소값
	public static int arrsum(int[][] arr)
	{
		int res=Integer.MAX_VALUE;
		for(int j=0;j<n;j++)
		{
			int sum=0;
			for(int h=0;h<m;h++)
			{
				sum+=arr[j][h];
			}
			res=Math.min(res, sum);
		}
		return res;
	}

}

class Way{
	int r;
	int c;
	int s;
	
	public Way(int r, int c, int s) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	
}
