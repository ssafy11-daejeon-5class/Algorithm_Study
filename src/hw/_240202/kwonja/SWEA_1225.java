package hw._240202.kwonja;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class SWEA_1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		for(int test_case=1;test_case<=10;test_case++)
		{
			int  n= sc.nextInt();
			for(int i=0;i<8;i++)
			{
				q.offer(sc.nextInt());
			}
			
			int cycle=1;
			while(true)
			{
				if(q.peek()-cycle <= 0)
				{
					q.offer(0);q.poll();
					break;
				}
				q.offer(q.peek()-cycle);q.poll();
				cycle=cycle%5+1;
			}
			System.out.print("#"+test_case);
			while(!q.isEmpty())
			{
				System.out.print(" "+q.peek());
				q.poll();
			}
			System.out.print("\n");
		}
	}

}
