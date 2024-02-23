package study._240227.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * -1 : 공기청정기
 * -1, 0 아님 : 미세먼지
 * 
 * T초 동안 두가지의 액션이 계속 일어남
 * 그러면 먼지들의 위치가 계속 업뎃됨 -> 먼지들의 좌표를 매 확산마다 다시 구하기? 
 * add_dust도 초기화 해야함
 * 
 * 
 * 
 * 1. 미세먼지 확산 기능
 *  1) 미세먼지 위치 파악
 *  
 * 
 * 
 * 
 * 2. 공기청정기 작동
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */

class Dust{
	int x;
	int y;
	
	
	public Dust(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}




public class BOJ_미세먼지 {

	
	static int R, C, T, Ans;
	static int[][] arr;
	static int[][] add_dust;
	
	static List<Dust> dust;
	static List<Integer> cleaner;
	
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		Ans = 0;
		arr = new int[R][C];
		cleaner = new ArrayList<>();
		
		for(int i=0; i<R; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1)
				{
					cleaner.add(i);
				}
			}
		}
		
		while(T>0)
		{
			// 미세먼지 위치 파악
			find_dust();
			
			// 미세먼지 확산
			diffuse_dust();
			
			// 공기청정기 작동
			clean_gogo();
			
			T--;
		}
		
		cal_dust();
		// System.out.println(Arrays.deepToString(arr));
		System.out.println(Ans);

	}


	private static void cal_dust() {
		
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				if(arr[i][j] != -1 && arr[i][j] != 0)
				{
					Ans += arr[i][j];
				}
			}
		}
		
		
	}


	private static void clean_gogo() {
		
		// 공기청정기 좌표 : cleaner.get(0), cleaner.get(1)
		// 공기청정기 기준 2번의 순환을 해야함
		// 첫번째 순환 (sr,sc)=(0,0) / er,ec = (cleaner.get(0), C-1)
		first_rotation();

		second_rotation();
		// print();
		
		// 두번째 순환 (sr,sc)=(cleaner.get(1), 0) / er,ec = (R-1, C-1)

		
		
	}


	private static void second_rotation() {
		

		// 아래, 오른쪽, 위, 왼쪽
		int[] dx1 = {1,0,-1,0};
		int[] dy1 = {0,1,0,-1};
		
		int dir = 0;
		
		int er = R-1;
		// System.out.println(er);
		int ec = C-1;
		
		int sr = cleaner.get(1);
		int sc = 0;
		
		int x=sr;
		int y=sc;
		
		int temp=0;
		//temp = arr[x+1][y];
		
		// 두번째 순환
		while(dir<4)
		{
			int nx = x+dx1[dir];
			int ny = y+dy1[dir];
			
			// System.out.println(nx + " " + ny);
			
			
			// -1은 옮기면 안됨
			if(nx>=sr && ny>=sc && nx<=er && ny<=ec)
			{
				if(arr[x][y] == -1)
				{
					x = nx;
					y = ny;
					continue;
				}
				
				
				if(arr[nx][ny] == -1) arr[x][y]=0;
				else {
					arr[x][y] = arr[nx][ny];
				}
				
				x = nx;
				y = ny;
				
			}else dir++;
			
			// System.out.println(dir);
			// System.out.println(x+" "+y);
			
		}
		
		arr[sr][sc+1] = 0;
		
		
	}


	private static void first_rotation() {
		
		// 오 아래 왼 위
		int[] dx1 = {0,1,0,-1};
		int[] dy1 = {1,0,-1,0};
		
		int dir = 0;
		
		int er = cleaner.get(0);
		// System.out.println(er);
		int ec = C-1;
		
		int sr = 0;
		int sc = 0;
		
		int x=sr;
		int y=sc;
		
		int temp=0;
		temp = arr[x][y];
		
		// 첫번째 순환
		while(dir<4)
		{
			int nx = x+dx1[dir];
			int ny = y+dy1[dir];
			
			// System.out.println(nx + " " + ny);
			
			// -1은 옮기면 안됨
			if(nx>=sr && ny>=sc && nx<=er && ny<=ec)
			{
				if(arr[x][y] == -1)
				{
					x = nx;
					y = ny;
					continue;
				}
				
				
				if(arr[nx][ny] == -1) arr[x][y]=0;
				else {
					arr[x][y] = arr[nx][ny];
				}
				
				x = nx;
				y = ny;
				
			}else dir++;
			
			// System.out.println(dir);
			// System.out.println(x+" "+y);
			
		}
		
		arr[sr+1][sc] = temp;
		
	}


	private static void diffuse_dust() {
		
		add_dust = new int[R][C];
		for(int i=0; i<dust.size(); i++)
		{
			int x = dust.get(i).x;
			int y = dust.get(i).y;
			int count=0;
			
			int amount = arr[x][y]/5;
			
			for(int k=0; k<4; k++)
			{
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx>=0 && ny>=0 && nx<R && ny<C)
				{
					// 공기청정기만 아니면 확산 가능
					if(arr[nx][ny] != -1)
					{
						add_dust[nx][ny] += amount;
						count++;
					}
				}
			}
			
			arr[x][y] -= (amount*count);
		}
		
		
		additional_extense();
		

	}


	private static void additional_extense() {
			
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				if(arr[i][j] !=-1)
				{
					arr[i][j] += add_dust[i][j];
				}
			}
		}
		
		// print();
		
	}


	private static void print() {
		
		// Scanner sc = new Scanner(System.in);
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		// sc.nextInt();
	}


	private static void find_dust() {
		
		dust = new ArrayList<>();
		
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				if(arr[i][j] !=0 && arr[i][j] != -1)
				{
					dust.add(new Dust(i,j));
				}
			}
		}
		
	}

}
