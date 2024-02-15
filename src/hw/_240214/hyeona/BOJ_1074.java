package hw._240214.hyeona;

import java.util.Arrays;
import java.util.Scanner;


// N = 2일 때, 4*4 / 4->2->1
// N = 3일 때, 8*8 / 8->4->2->1

public class BOJ_1074 {

	static int number=0,N,R, C, flag;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		N = (int) Math.pow(2, N);
		
		
		//System.out.println(N);
		
		dfs(0,0,N);
		
		

	}

	private static void dfs(int x, int y, int s) {
		
		//System.out.print(x+" "+y+" "+s);
		if(s==1)
		{
			if(x==R && y==C) 
			{
				System.out.println(number);
			}else
			{
				number++;
			}

			return;

		}
		
		
		if(R >= x+s || C>=y+s)
		{
			number += s*s;
			return;
		}
		
			
		int ns = s/2;
			
		dfs(x,y,ns);
		dfs(x,y+ns,ns);
		dfs(x+ns,y,ns);
		dfs(x+ns,y+ns,ns);
		
	}

}
