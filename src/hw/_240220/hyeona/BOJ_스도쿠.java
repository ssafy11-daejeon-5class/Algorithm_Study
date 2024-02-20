package hw._240220.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * 0행부터 탐색 시작, 조건에 맞게 9행까지 왔으면 스도쿠 완성
 * 마지막 열에 도달했으면 다음행으로
 * 
 * 
 * 빈칸에 1~9까지 다 넣어보고 (가로, 세로, 사각형) 확인 
 * -> 조건 맞으면 다음 빈칸을 채우러 떠나자
 * -> 조건이 안맞으면? 이전에 채운 빈칸이 잘 못 된거임. 돌아가자
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */




public class BOJ_스도쿠 {
	
	
	
	static int[][] arr = new int[9][9];
	static int flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<9; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}

	private static void dfs(int x, int y) {
		
		if(y == 9)
		{
			// 한 줄을 다 채웠다고 해서 그게 맞는 값일 보장이 없음
			// 돌아가야함
			//System.out.println("1");
			dfs(x+1, 0);
			return;

		}
		
		if(x == 9)
		{
			// 스도쿠 완성
			//System.out.println("2");
			print();
			flag = 1;
			return; 
		}
		
		
	
		if(arr[x][y]==0)
		{
			for(int j=1; j<=9; j++)
			{
				
				//System.out.println("4");
				if(check_sdoku(x, y, j))
				{
					arr[x][y] = j;
					// 조건 만족 후 다음 칸 채우러 고고
					dfs(x, y+1);
					//System.out.println("3");
					// 스도쿠 완성 했으면 밑에꺼 안하고 계속 돌아감
					if(flag == 1) return;
						
				}
				arr[x][y] = 0;
			}
				
			// 다 돌았는데 맞는 값 없으면 돌아가야함
			return;
		}
		
		dfs(x, y+1);
		


	}

	private static boolean check_sdoku(int x, int y, int number) {
		
		// 가로
		for(int i=0; i<9; i++)
		{
			// 중복 있음
			if(arr[x][i] == number)
			{
				return false;
			}
		}
		
		// 세로
		for(int i=0; i<9; i++)
		{
			if(arr[i][y] == number)
			{
				return false;
			}
		}
		
		
		// 사각형
		x = 3 * (x / 3);
		y = 3 * (y / 3);
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(arr[x+i][y+j] == number) return false;
			}
		}

		return true;
		
	}

}
