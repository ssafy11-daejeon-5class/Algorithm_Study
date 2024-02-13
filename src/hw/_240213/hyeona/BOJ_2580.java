package hw._240213.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
		
		//System.out.println(Arrays.deepToString(arr));
		// 가로, 세로 돌면서 비어있는 칸이 하나라면 채우기
		
		check_garo();
		check_sero();
		check_square();
		
		System.out.println(Arrays.deepToString(arr));
		
		

	}
	
	private static void check_square() {
		
		
		// 0,0 -> 0,3 -> 0,6
		// 3,0 -> 3,3 -> 3,6

		for(int i=0; i<7; i+=3)
		{
			for(int j=0; j<7; j+=3)
			{
				
				for(int x=0; x<3; x++)
				{
					int count=0;
					int sum=0;
					int nx=0;
					int ny=0;
					for(int y=0; y<3; y++)
					{
						sum += arr[i+x][j+y];
						if(arr[i+x][j+y]==0)
						{
							count++;
							nx = i+x;
							ny = j+y;
						}
					}

					if(count==1)
					{
						arr[nx][ny] = 45-sum;
					}
					
				}
			}
		}
		
		
		
	}

	private static void check_sero() {
		
		
		
		int x=0, y=0;
		for(int i=0; i<9; i++)
		{
			int sum=0;
			int count=0;
			for(int j=0; j<9; j++)
			{
				sum += arr[j][i];
				if(arr[j][i]==0)
				{
					x=j;
					y=i;
					count++;
				}
				if(count>2) break;
			}
			
			if(count==1)
			{
				arr[x][y] = 45-sum;
			}
		}
		
		
		
		
	}

	// 1 2 3 4 5 6 7 8 9 = 45
	private static void check_garo() {
		
		
		
		int x=0, y=0;
		for(int i=0; i<9; i++)
		{
			int sum=0;
			int count=0;
			for(int j=0; j<9; j++)
			{
				sum += arr[i][j];
				if(arr[i][j]==0)
				{
					x=i;
					y=j;
					count++;
				}
				if(count>2) break;
			}
			
			if(count==1)
			{
				arr[x][y] = 45-sum;
			}
		}	
		
	}

}
