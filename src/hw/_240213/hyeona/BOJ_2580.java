package hw._240213.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

	static Integer[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new Integer[9][9];
		StringTokenizer st;
		for(int i=0; i<9; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		print();
		


	}
	
	
	
	
	
	private static void check_duplicate(int x, int y, int number) {
		
		
		// 가로
		// 세로
		// 사각형

		
		
		
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
