package hw._240202.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {
	// [S/W 문제해결 기본] 7일차 - 암호생성기
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=10 ; i++) {
			int t = Integer.parseInt(br.readLine());
			
			// array input
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue = new LinkedList<>();
			for(int j=0 ; j<8 ; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			// password
			make();
			
			// result
			sb.append("#").append(t).append(" ");
			for (int q : queue) sb.append(q).append(" ");
			sb.append("\n");
		}
		
		// output
		System.out.println(sb);
	}

	
	public static void make() {
		int cycle = 1;
		
		while(!queue.contains(0)) {
			int temp = queue.poll();
			
			if(temp-cycle < 0) queue.add(0);
			else queue.add(temp-cycle);
			
			cycle++;
			if(cycle > 5) cycle = 1;
		}
	}
}
