package hw._240221.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 감시 {
	/*
	 * 사각지대의 최소값을 구해보자
	 * 내 생각엔 시물레이션 완전탐색인듯?
	 */
	static int n,m,Ans=Integer.MAX_VALUE;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int[] dx2= {1,-1,0,0};
	static int[] dy2= {0,0,1,-1};
	static int[] dx3= {-1,0,1,0,-1};
	static int[] dy3= {0,1,0,-1,0};
	static int[] dx4= {-1,0,1,0,-1,0,1,0};
	static int[] dy4= {0,1,0,-1,0,1,0,-1};
	static List<Point> cctvs=new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int[][] board=new int[n][m];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				//cctv 위치와 종류 저장
				if(board[i][j]>0 && board[i][j]!=6)cctvs.add(new Point(i,j,board[i][j]));
			}
		}
		recursive(0,board);
		System.out.println(Ans);
	}
	public static int[][] copyboard(int [][] board)
	{
		int[][] copyboard=new int[n][];
		for(int i=0;i<n;i++)
		{
			copyboard[i]=Arrays.copyOf(board[i], m);
		}
		return copyboard;
	}
	public static int cal(int[][] board)
	{
		int res=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
//				System.out.print(board[i][j] + " ");
				if(board[i][j]==0)res++;
			}
//			System.out.println();
		}
		return res;
	}
	private static void recursive(int idx, int[][] copyboard) {
		
		if(idx==cctvs.size())
		{
			//모든 cctv가 작동했을때 사각지대를 카운트하자
			Ans = Math.min(cal(copyboard), Ans);
//			System.out.println();
			return;
		}
		//1번 cctvs 일때
		if(cctvs.get(idx).num==1)
		{
			//사방 탐색
			Point p =cctvs.get(idx);
			int curx=p.x;
			int cury=p.y;
			for(int i=0;i<4;i++)
			{
				int[][] board = copyboard(copyboard);
				int count=0;
				int nx=curx;
				int ny=cury;
				while (true) {
					nx+=dx[i];
					ny+=dy[i];
					if(nx<0 || nx>=n || ny<0 || ny>=m)break;
					//cctv가 마주보고있으면 어카지?
					//벽을 만나면
					if(board[nx][ny]==6)break;
					
					count++;
				}
				
				int fillx=curx;
				int filly=cury;
				//cctv영역 채우기
				for(int j=0;j<count;j++)
				{
					fillx+=dx[i];
					filly+=dy[i];
					//cctv인 경우
					if(board[fillx][filly] !=0)continue;
					board[fillx][filly]=9;
				}
				//다음 cctv 적용
				recursive(idx+1,board);
//				fillx=curx;
//				filly=cury;
//				for(int j=0;j<count;j++)
//				{
//					fillx+=dx[i];
//					filly+=dy[i];
//					if(board[fillx][filly] !=9)continue;
//					board[fillx][filly]=0;
//				}
			}
		}
		//2번 카메라 일때
		else if(cctvs.get(idx).num==2)
		{
			Point p =cctvs.get(idx);
			int curx=p.x;
			int cury=p.y;
			for(int i=0;i<4;i=i+2)
			{
				int[][] board = copyboard(copyboard);
				int count1=0;
				int count2=0;
				int nx=curx;
				int ny=cury;
				
				//왼쪽
				while (true) {
					nx+=dx2[i];
					ny+=dy2[i];
					if(nx<0 || nx>=n || ny<0 || ny>=m)break;
					//cctv가 마주보고있으면 어카지?
					//벽을 만나면
					if(board[nx][ny]==6)break;
					
					count1++;
				}
				//오른쪽
				nx=curx;
				ny=cury;
				while (true) {
					nx+=dx2[i+1];
					ny+=dy2[i+1];
					if(nx<0 || nx>=n || ny<0 || ny>=m)break;
					//cctv가 마주보고있으면 어카지?
					//벽을 만나면
					if(board[nx][ny]==6)break;
					
					count2++;
				}
				
				int fillx=curx;
				int filly=cury;
				//cctv영역 채우기
				for(int j=0;j<count1;j++)
				{
					fillx+=dx2[i];
					filly+=dy2[i];
					//cctv인 경우
					if(board[fillx][filly] !=0)continue;
					board[fillx][filly]=9;
				}
				fillx=curx;
				filly=cury;
				for(int j=0;j<count2;j++)
				{
					fillx+=dx2[i+1];
					filly+=dy2[i+1];
					//cctv인 경우
					if(board[fillx][filly] !=0)continue;
					board[fillx][filly]=9;
				}
				//다음 cctv 적용
				recursive(idx+1,board);
//				fillx=curx;
//				filly=cury;
//				for(int j=0;j<count1;j++)
//				{
//					fillx+=dx2[i];
//					filly+=dy2[i];
//					if(board[fillx][filly] !=9)continue;
//					board[fillx][filly]=0;
//				}
//				fillx=curx;
//				filly=cury;
//				for(int j=0;j<count2;j++)
//				{
//					fillx+=dx2[i+1];
//					filly+=dy2[i+1];
//					if(board[fillx][filly] !=9)continue;
//					board[fillx][filly]=0;
//				}
			}
		}
				//3번 카메라 일때
				else if(cctvs.get(idx).num==3)
				{
					
					Point p =cctvs.get(idx);
					int curx=p.x;
					int cury=p.y;
					for(int i=0;i<4;i++)
					{
						int[][] board = copyboard(copyboard);
						int count1=0;
						int count2=0;
						int nx=curx;
						int ny=cury;
						
						//왼쪽
						while (true) {
							nx+=dx3[i];
							ny+=dy3[i];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count1++;
						}
						//오른쪽
						nx=curx;
						ny=cury;
						while (true) {
							nx+=dx3[i+1];
							ny+=dy3[i+1];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count2++;
						}
						
						int fillx=curx;
						int filly=cury;
						//cctv영역 채우기
						for(int j=0;j<count1;j++)
						{
							fillx+=dx3[i];
							filly+=dy3[i];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						fillx=curx;
						filly=cury;
						for(int j=0;j<count2;j++)
						{
							fillx+=dx3[i+1];
							filly+=dy3[i+1];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						//다음 cctv 적용
						recursive(idx+1,board);
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count1;j++)
//						{
//							fillx+=dx3[i];
//							filly+=dy3[i];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count2;j++)
//						{
//							fillx+=dx3[i+1];
//							filly+=dy3[i+1];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
					}
				}
				//4번 카메라 일때
				else if(cctvs.get(idx).num==4)
				{
					
					Point p =cctvs.get(idx);
					int curx=p.x;
					int cury=p.y;
					for(int i=0;i<4;i++)
					{
						int[][] board = copyboard(copyboard);
						int count1=0;
						int count2=0;
						int count3=0;
						int nx=curx;
						int ny=cury;
						
						//왼쪽
						while (true) {
							nx+=dx4[i];
							ny+=dy4[i];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count1++;
						}
						//오른쪽
						nx=curx;
						ny=cury;
						while (true) {
							nx+=dx4[i+1];
							ny+=dy4[i+1];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count2++;
						}
						nx=curx;
						ny=cury;
						while (true) {
							nx+=dx4[i+2];
							ny+=dy4[i+2];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count3++;
						}
						
						int fillx=curx;
						int filly=cury;
						//cctv영역 채우기
						for(int j=0;j<count1;j++)
						{
							fillx+=dx4[i];
							filly+=dy4[i];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						fillx=curx;
						filly=cury;
						for(int j=0;j<count2;j++)
						{
							fillx+=dx4[i+1];
							filly+=dy4[i+1];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						fillx=curx;
						filly=cury;
						for(int j=0;j<count3;j++)
						{
							fillx+=dx4[i+2];
							filly+=dy4[i+2];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						//다음 cctv 적용
						recursive(idx+1,board);
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count1;j++)
//						{
//							fillx+=dx4[i];
//							filly+=dy4[i];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count2;j++)
//						{
//							fillx+=dx4[i+1];
//							filly+=dy4[i+1];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count3;j++)
//						{
//							fillx+=dx4[i+2];
//							filly+=dy4[i+2];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
					}
				}
				//5번 카메라 일때
				else if(cctvs.get(idx).num==5)
				{
					int[][] board = copyboard(copyboard);
					Point p =cctvs.get(idx);
					int curx=p.x;
					int cury=p.y;
					for(int i=0;i<1;i++)
					{
						int count1=0;
						int count2=0;
						int count3=0;
						int count4=0;
						int nx=curx;
						int ny=cury;
						
						//왼쪽
						while (true) {
							nx+=dx[i];
							ny+=dy[i];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count1++;
						}
						//오른쪽
						nx=curx;
						ny=cury;
						while (true) {
							nx+=dx[i+1];
							ny+=dy[i+1];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count2++;
						}
						nx=curx;
						ny=cury;
						while (true) {
							nx+=dx[i+2];
							ny+=dy[i+2];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count3++;
						}
						nx=curx;
						ny=cury;
						while (true) {
							nx+=dx[i+3];
							ny+=dy[i+3];
							if(nx<0 || nx>=n || ny<0 || ny>=m)break;
							//cctv가 마주보고있으면 어카지?
							//벽을 만나면
							if(board[nx][ny]==6)break;
							
							count4++;
						}
						
						int fillx=curx;
						int filly=cury;
						//cctv영역 채우기
						for(int j=0;j<count1;j++)
						{
							fillx+=dx[i];
							filly+=dy[i];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						fillx=curx;
						filly=cury;
						for(int j=0;j<count2;j++)
						{
							fillx+=dx[i+1];
							filly+=dy[i+1];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						fillx=curx;
						filly=cury;
						for(int j=0;j<count3;j++)
						{
							fillx+=dx[i+2];
							filly+=dy[i+2];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						fillx=curx;
						filly=cury;
						for(int j=0;j<count4;j++)
						{
							fillx+=dx[i+3];
							filly+=dy[i+3];
							//cctv인 경우
							if(board[fillx][filly] !=0)continue;
							board[fillx][filly]=9;
						}
						//다음 cctv 적용
						recursive(idx+1,board);
						//5는 전부라서 그냥 넘어가도 된다.
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count1;j++)
//						{
//							fillx+=dx[i];
//							filly+=dy[i];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count2;j++)
//						{
//							fillx+=dx[i+1];
//							filly+=dy[i+1];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count3;j++)
//						{
//							fillx+=dx[i+2];
//							filly+=dy[i+2];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
//						fillx=curx;
//						filly=cury;
//						for(int j=0;j<count4;j++)
//						{
//							fillx+=dx[i+3];
//							filly+=dy[i+3];
//							if(board[fillx][filly] !=9)continue;
//							board[fillx][filly]=0;
//						}
					}
				}
	}

}
class Point{
	int x,y,num;

	public Point(int x, int y, int num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
	}
	
}
