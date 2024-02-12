package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1974 {
	/*
	 * 스도쿠 검증
	 * 가로,세로,3*3박스
	 */
	static int [][]arr1;
	static int [][]arr2;
	static int [][]arr3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T;test_case++)
		{
			arr1 = new int[9][9];
			arr2 = new int[9][9];
			arr3 = new int[9][9];
			for(int i=0;i<9;i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++)
				{
					int temp =Integer.parseInt(st.nextToken());
					arr1[i][temp-1]++;
					arr2[j][temp-1]++;
					//i/3*3 + j/3 
					arr3[i/3*3 + j/3][temp-1]++;
				}
			}
			System.out.println("#" + test_case +" "+check());
		}
	}
	public static int check()
	{
		for(int i=0;i<9;i++)
		{
			Arrays.sort(arr1[i]);
			Arrays.sort(arr2[i]);
			Arrays.sort(arr3[i]);
			if(arr1[i][0]==0 || arr2[i][0]==0 || arr3[i][0]==0)return 0;
		}
		return 1;
	}

}
