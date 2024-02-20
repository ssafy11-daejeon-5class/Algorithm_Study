package hw._240220.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	char result; 
	public Point(int x, int y, char result) {
		super();
		this.x = x;
		this.y = y;
		this.result = result;
	}

}





public class BOJ_적록색약 {

	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int N;
	
	static char[][] arr;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		arr = new char[N][N];
		v = new boolean[N][N];
		
		int sum=0;
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			
			for(int j=0; j<N; j++)
			{
				arr[i][j] = str.charAt(j);
			}
		}
		
		// 적록 색약이 아닌 사람
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(!v[i][j])
				{
					bfs(i,j, arr[i][j]);
					sum++;
				}
			}
		}
		
		sb.append(sum).append(" ");
		sum=0;
		v = new boolean[N][N];
		
		
		for(int i=0; i<N; i++)
		{

			for(int j=0; j<N; j++)
			{
				if(arr[i][j] == 'R') arr[i][j] = 'G';
			}
		}
		
		
		// 적록색약인 사람
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(!v[i][j])
				{
					bfs(i,j, arr[i][j]);
					sum++;
				}
			}
		}
		
		sb.append(sum);
		
		System.out.print(sb);

	}

	
	
	
	private static void bfs(int x, int y, char result) {
	
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, result));
		v[x][y] = true;
		
		while(!queue.isEmpty())
		{
			Point p = queue.poll();
			
			for(int i=0; i<4; i++)
			{
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !v[nx][ny])
				{
					if(arr[nx][ny] == result)
					{
						v[nx][ny] = true;
						queue.offer(new Point(nx, ny, result));
					}
					
				}
			}
				
		}

	}

}
