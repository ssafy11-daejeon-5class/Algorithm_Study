package hw._240202.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			t = Integer.parseInt(br.readLine());
			int[] nums = new int[8];
			int minNum = Integer.MAX_VALUE; // 8개의 수 중 최소값을 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				minNum = Math.min(minNum, nums[i]);
			}
			
			minNum = ((minNum - 1) / 15)*15; 
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				queue.add(nums[i] - minNum); // 8개 수를 15로 나눈 나머지를 큐에 넣음
			}
			int minusNum = 0;
			while(true) {
				minusNum = minusNum % 5 + 1;
				int tmp = Math.max(0, queue.poll() - minusNum);
				queue.offer(tmp);
				if(tmp == 0) break;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			
			System.out.println("#" + t + " " + sb.toString());
			
		}
		
	}
}
