package codingTestPack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		int [][] map = new int[2][7];
		for(int i=0;i<n;i++)
		{
			int gender=sc.nextInt();
			int grade=sc.nextInt();
			map[gender][grade]++;
		}
		
		int room=0;
		for(int i=0;i<2;i++)
		{
			for(int j=1;j<7;j++)
			{
				if(map[i][j] % k == 0) room += map[i][j]/k;
				else room += map[i][j]/k +1;
			}
		}
		System.out.println(room);
	}
}
