package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {

	/*
	 * 절대값 힙
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(a,b)->{
				if(Math.abs(a) ==Math.abs(b))return a-b;
				return Math.abs(a)-Math.abs(b);
				});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			int c = Integer.parseInt(br.readLine());
			if(c!=0)pq.offer(c);
			else
			{
				if(pq.isEmpty())System.out.println(0);
				else System.out.println(pq.poll());
			}	
		}
		
	}

}
