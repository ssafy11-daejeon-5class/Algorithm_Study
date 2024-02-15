package hw._240214.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Z {
	/*
	 * Z
	 */
	static int num=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		recursive(n,r,c);
		System.out.println(num);
	
	}
	public static void recursive(int n,int r, int c)
	{
		//basis
		if(n==0)
		{
			return;
		}
		//inductive
		int half = 1<<(n-1);
		
		// 0 ,0
		if(r<half && c<half)
		{
			num+=0;
			recursive(n-1 ,r,c);
		}
		// 0 , n/2
		if(r<half && c>=half)
		{
			num+=half*half;
			recursive(n-1,r,c-half);
		}
		// n/2 , 0
		if(r>=half && c<half)
		{
			num+=2*half*half;
			recursive(n-1,r-half,c);
		}
		// n/2,n/2
		if(r>=half && c>=half)
		{
			num+=3*half*half;
			recursive(n-1,r-half,c-half);
		}
	}

}
