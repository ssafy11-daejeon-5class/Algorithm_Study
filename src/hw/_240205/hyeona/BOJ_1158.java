package hw._240205.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++)
		{
			queue.offer(i);
		}
		int K = Integer.parseInt(st.nextToken());
		
		while(queue.size()!=1)
		{
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
			
		}
		sb.append(queue.poll());
		sb.append(">");
		
		System.out.print(sb);
		

	}

}
