package hw._240201.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023{
	static int n;
	static int[] arr= new int[] {2,3,5,7};
	static int[] arr1= new int[] {1,3,5,7,9};
	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
//		int[] isPrime = new int[10000000];
		res=new int[n];
		int s=(int) Math.pow(10, n);
//		for(int i=2;i<Math.sqrt(s);i++)
//		{
//			for(int j=i*i;j<s;j=j+i)
//			{
//				isPrime[j]=1; //소수아님
//			}
//		}
		func1(0,0);
	}
	public static void func1(int num,int k)
	{
		if(k==n)
		{
			System.out.print(num+"\n");
			return;
		}
		if(k==0)
		{
			for(int i=0;i<arr.length;i++)
			{
				func1(num+arr[i],k+1);
			}
		}
		else
		{
			for(int i=0;i<arr1.length;i++)
			{
				if(checkprime(num*10+arr1[i])==1)
				{
					func1(num*10+arr1[i],k+1);					
				}
			}
		}
	}
	public static int checkprime(int num)
	{
		
		if (num == 1)return 0;
		for (int i = 2; i < num; i++)
		{
			if (num%i == 0)return 0;
		}
		return 1;
	}

}