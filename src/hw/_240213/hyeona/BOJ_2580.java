package algorithm.Algorithm_Study.src.hw._240213.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠

/*
 * 빈칸이 있으면 넣을 수 있는 수 : 1~9
 * 가로줄, 세로줄, 사각형에 들어갈 수랑 중복수가 있는지 확인하고 없으면 넣기
 * 
 * 끝 열에 도달하면 다음행으로
 * 끝 행에 도달하면 출력하고 종료
 * 
 * 
*/


public class BOJ_2580 {

	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		StringTokenizer st;
		for(int i=0; i<9; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// print();
		dfs(0,0);


	}

	private static boolean dfs(int x, int y) {

		if(y==9)
		{
			dfs(x+1, 0);
			return true;
		}

		if(x==9)
		{
			print();
			//System.exit(0);
			return true;
		}

		if(arr[x][y]==0)
		{
			for(int i=1; i<=9; i++)
			{
				if(check_duplicate(x,y,i))
				{
					arr[x][y]=i;
					if(dfs(x, y+1)) return true;
				}
			}
			// 다 돌았는데 맞는 값이 없다면 0으로 원복시켜주고 앞선 재귀로 ㄱ ㄱ
			arr[x][y]=0;
			return false;
		}

		dfs(x, y+1);
		return false;

	}

	private static boolean check_duplicate(int x, int y, int number) {

		// 가로
		for(int i=0; i<9; i++)
		{
			if(arr[x][i] == number)
				return false;
		}

		// 세로
		for(int i=0; i<9; i++)
		{
			if(arr[i][y] == number)
				return false;
		}

		// 사각형
		// 0,3,6
		if(x>=0 && x<=2) x=0;
		else if(x>=3 && x<=5) x=3;
		else if(x>=6 && x<=8) x=6;

		if(y>=0 && y<=2) y=0;
		else if(y>=3 && y<=5) y=3;
		else if(y>=6 && y<=8) y=6;

		for(int i=x; i<x+3; i++)
		{
			for(int j=y; j<y+3; j++)
			{
				if(arr[i][j] == number)
				{
					return false;
				}
			}
		}
		return true;
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
	
	
	
	

}
