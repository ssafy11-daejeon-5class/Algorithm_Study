package hw._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 최소힙
// 1이면 자리 바꾼다
public class BOJ_11286 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap1 = new PriorityQueue<>((o1, o2) -> 
		{
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			// 음수가 앞으로 와야함
			if(abs1 == abs2) return o1>o2 ? 1:-1;
			
			// 절댓값이 다르면, 작은게 앞으로 와야함
			return abs1-abs2;
			
		});
		
		
		
		for(int i=0; i<N; i++)
		{
			int number = Integer.parseInt(br.readLine());
			
			if(number!=0)
			{
				heap1.offer(number);
			}else
			{
				if(heap1.isEmpty()) System.out.println(0);
				else System.out.println(heap1.poll());
			}

		}

	}
		

}

