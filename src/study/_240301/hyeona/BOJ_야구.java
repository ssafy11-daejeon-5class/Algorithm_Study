/*
 * 가능한 모든 타선 뽑아서 다 경기 시켜보기
 * 1번 선수는 무조건 < 4번 타자 >
 * 
 * 
 * 
 * 
 * */
package study;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_야구 {

	static int N, flag;
	static int[][] arr;
	static boolean[] v;
	static int[] sel;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		

		
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
			{
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		// 타순 만들기

		v = new boolean[10];
		sel = new int[10];
			
		v[4] = true;
		sel[4] = 1;
			
		permutation(2);
			
			
			
		

	}
	
	private static void permutation(int num) {
		
		
		if(num == 10)
		{
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=1; i<=9; i++)
		{
			if(!v[i])
			{
				v[i] = true;
				sel[i] = num; 
				permutation(num+1);
				v[i] = false;
			}
			
			
		}
		
	}


}
