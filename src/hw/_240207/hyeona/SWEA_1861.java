package hw._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 어떤 수가 적힌 방에서 출발해야 최대한 많은 개수의 방을 이동할 수 있을까?
// 다 해봐야지

class Point
{
	int x; 
	int y;
	int number;
	
	public Point(int x, int y, int number) {
		super();
		this.x = x;
		this.y = y;
		this.number = number;
	}
	
	
	
	
}
public class SWEA_1861 {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int[][] arr;
	static boolean[][] visited;
	static int N, cnt;
	
	static int max;
	
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=T; i++)
		{
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			List<Point> list = new ArrayList<>();
			int result=Integer.MAX_VALUE;
			for(int x=0; x<N; x++)
			{
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<N; y++)
				{
					arr[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int x=0; x<N; x++)
			{
				for(int y=0; y<N; y++)
				{
					cnt = 1;
					visited = new boolean[N][N];
					visited[x][y] = true;
					dfs(x,y);
					
					if(cnt >=max)
					{
						max = cnt;
						list.add(new Point(x, y, cnt));
					}
				}
			}
			
			for(int k=0; k<list.size(); k++)
			{
				if(list.get(k).number == max)
				{
					result = Math.min(arr[list.get(k).x][list.get(k).y], result);
				}
			}
			
			
			
			sb.append("#").append(i).append(" ").append(result).append(" ").append(max).append("\n");
		}
		
		System.out.print(sb);
		
	

	}
	
	
	private static void dfs(int x, int y) {
		
		// inductive part
		for(int i=0; i<4; i++)
		{
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny])
			{
				if(arr[nx][ny] == arr[x][y]+1)
				{
					visited[nx][ny]= true;
					cnt +=1;
					dfs(nx, ny);
					visited[nx][ny]= false;
				}
			}
		
		}
		
		
		
	}

}
