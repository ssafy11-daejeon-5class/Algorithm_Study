package hw._240213.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 스도쿠
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
		

		
		
		print();
		


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
