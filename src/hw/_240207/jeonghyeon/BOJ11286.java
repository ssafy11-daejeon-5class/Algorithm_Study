package hw._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) != Math.abs(o2))
				return Math.abs(o1) - Math.abs(o2);
			else
				return o1 - o2;
		});

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (queue.isEmpty()) {
					sb.append(0);
					sb.append("\n");
				} else {
					sb.append(queue.poll());
					sb.append("\n");
				}
			} else {
				queue.offer(num);
			}
		}
		System.out.println(sb);
	}

}
