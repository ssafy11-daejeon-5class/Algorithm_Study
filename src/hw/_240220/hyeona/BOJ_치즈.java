/*
 * 1. (0,0) 좌표에서 치즈 밖의 공간을 -1로 바꿔줌
 * 2. 1 상하좌우에 -1이 하나라도 있으면 1을 -1로 바꿔줌
 * 3. 판에 1이 없을 때 까지 반복
 * 
 * 
 * 
 * */
package hw._240220.hyeona;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese{
	int x;
	int y;
	
	public Cheese(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}



public class BOJ_치즈 {

	
	static int N, M, Ans, chee, noCheese;
	
	static int[][] arr;
	static boolean[][] v;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static List<Cheese> list;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		//list = new ArrayList<>();
		Ans = 0;
		chee = 0;
		
		noCheese=0;
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) noCheese++;
			}
		}
		

		while(noCheese !=0)
		{
			
			list = new ArrayList<>();
			v = new boolean[N][M];
			
			L:
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					if(arr[i][j]==0 || (arr[i][j]==1 && (i==N-1 || j == M-1)) )
					{
						change_background(i,j);
						break L;
					}
					
				}
			}
			
			v = new boolean[N][M];
			// print();
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					if(arr[i][j]==1 && !v[i][j])
					{
						melting_cheese(i,j);
					}
					
				}
			}
			
			
			// 치즈 녹이기
			for(int i=0; i<list.size(); i++)
			{
				arr[list.get(i).x][list.get(i).y] = -1;
				noCheese--;
			}
			
			Ans++;
			chee = list.size();

		}

		System.out.println(Ans);
		System.out.println(chee);

	}
	
	
	// 녹일 치즈를 한번에 어딘가에 담아서 녹여야함
	private static void melting_cheese(int x, int y) {
		
		Queue<Cheese> queue = new LinkedList<>();
		queue.offer(new Cheese(x, y));
		v[x][y]= true;
		
		while(!queue.isEmpty())
		{
			Cheese c = queue.poll();
			
			if(check_border(c.x, c.y))
			{
				list.add(new Cheese(c.x, c.y));
			}
			
			
			for(int i=0; i<4; i++)
			{
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !v[nx][ny])
				{
					if(arr[nx][ny] == 1)
					{
						queue.offer(new Cheese(nx, ny));
						v[nx][ny] = true;
					}
	
				}
			}	
		}
		
	}


	private static boolean check_border(int x, int y) {
		
		
		for(int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i]; 
			
			if(nx>=0 && ny>=0 && nx<N && ny<M)
			{
				if(arr[nx][ny] == -1) return true;
			}
		}
		return false;
		
	}



	private static void print() {
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}


	private static void change_background(int x, int y) {
		
		v = new boolean[N][M];
		
		Queue<Cheese> queue = new LinkedList<>();
		queue.offer(new Cheese(x, y));
		v[x][y] = true;
		
		while(!queue.isEmpty())
		{
			Cheese c = queue.poll();
			
			arr[c.x][c.y] = -1;
			
			for(int i=0; i<4; i++)
			{
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !v[nx][ny])
				{
					if(arr[nx][ny] == 0)
					{
						queue.offer(new Cheese(nx, ny));
						v[nx][ny] = true;
					}	
				}
			}		
		}
		
	}
	
	
	
	
	
//	private static boolean check_one() {
//		
//		// 1이 있으면 false를 리턴
//		for(int i=0; i<N; i++)
//		{
//			for(int j=0; j<M; j++)
//			{
//				if(arr[i][j] == 1)
//				{
//					return false;
//				}
//			}
//		}
//		
//		return true;
//		
//	}
	
	

}
