package hw._240202.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 카드 2
 */
public class BOJ_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		Queue<Integer> q= new LinkedList<>();
		
		for(int i=1;i<=n;i++)
		{
			q.offer(i);
		}
		
		while(q.size()!=1)
		{
			q.poll();
			q.offer(q.peek());
			q.poll();
		}
		System.out.println(q.peek());
	}

}
