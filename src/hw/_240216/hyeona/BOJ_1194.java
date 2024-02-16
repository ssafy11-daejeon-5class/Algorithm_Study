package hw._240216.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Moon{

	int x;
	int y;
	int cnt;
	int key;
	
	public Moon(int x, int y, int cnt, int key) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.key = key;
	}
	
	
}


public class BOJ_1194 {

	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	static int N, M, flag, number;
	static int Ans = Integer.MAX_VALUE;
	
	static char[][] arr;
	static Queue<Moon> queue; 
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		queue = new LinkedList<>();
		visited = new boolean[N][M][1<<6];		
		// key = 000 000
		int x=0;
		int y=0;
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			for(int j=0; j<M; j++)
			{
				arr[i][j] = str.charAt(j);
				if(arr[i][j]=='0')
				{
					x=i;
					y=j;
				}
			}
		}
		
		bfs(x,y);
		
		//if(flag==0) System.out.println(-1);
		//else System.out.println(number);
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
		// System.out.println(Arrays.deepToString(arr));
	

	}
	private static void bfs(int x, int y) {
		
		queue.offer(new Moon(x, y, 0,0));
		visited[x][y][0]=true;
		
		while(!queue.isEmpty())
		{
			Moon m = queue.poll();
			
			System.out.println(m.x+" "+m.y+" "+m.key+" "+m.cnt);
			
			if(arr[m.x][m.y] == '1')
			{
				Ans = m.cnt;
				
			}
		
			for(int i=0; i<4; i++)
			{
				int nx = m.x+dx[i];
				int ny = m.y+dy[i];
				//int nk = m.key;
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny][m.key] && arr[nx][ny]!='#')
				{
					// 열쇠를 만나면 먹는다
					if(arr[nx][ny] >='a' && arr[nx][ny] <='f')
					{
						// m.key 값을 바꿔주면 안됨 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
						m.key = m.key | (1<<arr[nx][ny]-'a');
					}
					
					// 문을 만나면 열쇠가 있는지 확인하고 지나간다
					// 열쇠가 없다면 못 지나감
					if(arr[nx][ny] >='A' && arr[nx][ny] <='F')
					{
						// 열쇠가 있는지 확인한다, 0이면 열쇠가 없는 것
						if((m.key & (1 << (arr[nx][ny]-'A')))==0)
						{
							continue;
						}
					}
					
					
					queue.offer(new Moon(nx, ny, m.cnt+1, m.key));
					visited[nx][ny][m.key] = true;
					number++;
					
				}
			}	
			
		}
	}
}
