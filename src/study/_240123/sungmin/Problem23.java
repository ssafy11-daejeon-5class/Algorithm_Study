package study._240123.sungmin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem23 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			int n=sc.nextInt();
			int d=sc.nextInt();
			
			int [] map = new int[n+2];
			for(int i=1;i<=n;i++)
			{
				map[i]=sc.nextInt();
			}
			map[0]=1;map[n+1]=1;
			int count=0;
			int discount=0;
			for(int i=0;i<n+2;i++)
			{
				if(map[i]==1)discount=0;
				else if(discount==d && map[i]==0)
				{
					count++;
					discount=0;
				}
				discount++;
			}
			
			System.out.println("#"+test_case+" "+count);
			
		}
		
		
	}
}