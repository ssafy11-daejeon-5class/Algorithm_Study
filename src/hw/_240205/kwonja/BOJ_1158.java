package hw._240205.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 요세푸스 문제
 * q를 사용해서 문제를 풀이한다
 * <1>  처럼 size 1일때 출력 처리를 진행해줘야한다 
 */
public class BOJ_1158 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q= new LinkedList<>();
		
		for(int i=1;i<=n;i++) q.offer(i);
		System.out.print("<");
		while(!q.isEmpty())
		{
			if(q.size()==1)
				{
					System.out.print(q.poll());
					break;
				}
				
			for(int i=0;i<k-1;i++) q.offer(q.poll());
			System.out.print(q.poll() +", ");
		}
		System.out.print(">");
	}
}
