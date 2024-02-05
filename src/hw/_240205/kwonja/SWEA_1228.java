package hw._240205.kwonja;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		for(int test_case=1;test_case<=10;test_case++)
		{
			Queue<String> q = new LinkedList<>();
			Queue<String> res=null;
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
			{
				q.offer(st.nextToken());
			}
			int n2=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n2;i++)
			{
				
				st.nextToken(); // | 제거 
				int x = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				res = new LinkedList<>();
				for(int j=0;j<x;j++)
				{
					res.offer(q.peek());
					q.poll();
				}
				for(int j=0;j<s;j++)
				{
					res.offer(st.nextToken());
				}
				while(!q.isEmpty())
				{
					res.offer(q.peek());
					q.poll();
				}
				q=res;
			}
			
			System.out.print("#"+test_case);
			int count=0;
			while (count < 10 && !res.isEmpty()) {
				System.out.print(" "+res.peek());
				res.poll();
				count++;
			}
			System.out.print("\n");
			
		}
		
	}

}
