package hw._240216.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
public class 달이차오른다 {
	static char[][] board;
	static int n,m,Ans=Integer.MAX_VALUE;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int s,e;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		board = new char[n][m];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<m;j++)
			{
				board[i][j]=str.charAt(j);
				if(board[i][j]=='0')
				{
					s=i;
					e=j;
					board[i][j]='.';
				}
			}
		}
//		print();
		bfs(s,e);
		System.out.println(Ans ==Integer.MAX_VALUE ? -1 : Ans);
	}
	public static void bfs(int startx,int starty)
 	{
 		Queue<Point> Q = new ArrayDeque<>();
 		Q.offer(new Point(startx,starty,0,new int[6]));
 		boolean[][][]v = new boolean[n][m][64];
 		
 		//처음 열쇠없을때 시작
 	
 		v[startx][starty][0]=true;
 		
 		while(!Q.isEmpty())
 		{
 			Point p=Q.poll();
// 			System.out.println(p);
 			//목적지에 도착 했을때
 			if(board[p.r][p.c]=='1')
 			{
 				//몇칸만에 왔는지 Ans에 저장
 				Ans=p.cnt;
 				break;
 			}
 			for(int i=0;i<4;i++)
 			{
 				int nr=p.r+dx[i];
 				int nc=p.c+dy[i];
 				if(nr>=0 && nr<n && nc>=0 && nc<m)
 				{
// 					if(board[nr][nc] =='#')continue;
 					//연산자 우선순위에 허덕이고 있었다 ㄹㅈㄷ .... AND(&&) 는 논리곱 OR(||)은 논리합 곱이 합보다 우선이다 절때 않잊을듯
 					//일반 길인경우
 					if((board[nr][nc]=='.' || board[nr][nc]=='1') && !v[nr][nc][p.keybittoInt()])
 					{
 						v[nr][nc][p.keybittoInt()]=true;
 	 					Q.add(new Point(nr,nc,p.cnt+1,p.key));	
 					}
 					//열쇠를 먹는경우
 					else if(Character.isLowerCase(board[nr][nc])  && !v[nr][nc][p.keybittoInt()])
 					{
 						int[] newkey = Arrays.copyOf(p.key, 6);
 						newkey[board[nr][nc]-'a']=1;
 						v[p.r][p.c][p.keybittoInt()]=true;
 						int bit=calkey(newkey);
 						v[nr][nc][bit]=true;
 						Q.add(new Point(nr,nc,p.cnt+1,newkey));
 					}
 					//대문인경우
 					else if(Character.isUpperCase(board[nr][nc])  && !v[nr][nc][p.keybittoInt()])
 					{
 						if(p.key[board[nr][nc]-'A']==1) //열쇠가 있을때
 						{
 							v[nr][nc][p.keybittoInt()]=true;
 	 						Q.add(new Point(nr,nc,p.cnt+1,p.key));	
 						}
 					}
 					//벽을 만나는 경우
 					//그냥 지나감
 					
 				}
 			}
 		}
 	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static int calkey(int[] key)
	{
			int sum=0;
			for(int i=5;i>-1;i--)
			{
				if(key[i]==1)
				{
					sum+= (1<<i);
				}
			}
			return sum;
	}

}
class Point{
	int r,c,cnt;
	int[] key;
	public Point(int r, int c, int cnt, int[] key) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.key = key;
	}
	
	public int keybittoInt()
	{
		int sum=0;
		for(int i=5;i>-1;i--)
		{
			if(key[i]==1)
			{
				sum+= (1<<i);
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", key=" + Arrays.toString(key)+", "+keybittoInt() +"]";
	}
	


}
