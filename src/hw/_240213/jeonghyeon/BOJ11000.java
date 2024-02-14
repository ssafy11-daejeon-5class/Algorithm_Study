package hw._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				if (o1[0] == o1[1])
					return 1;
				else if (o2[0] == o2[1])
					return -1;
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		for (int i = 0; i < meetings.length; i++) {
			System.out.println(meetings[i][0] + " " + meetings[i][1] + " dd");
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(meetings[0][1]);
		for (int idx = 1; idx < meetings.length; idx++) {
			if (queue.peek() <= meetings[idx][0]) {
				queue.poll();
			}
			queue.offer(meetings[idx][1]);

			// System.out.println("new " + meetings[idx][1] + " and peek : " + queue.peek()
			// + " and size : " + queue.size());
		}

		System.out.println(queue.size());
	}
}

/*
 * 10 1 3 3 5 5 7 2 4 4 6 5 6 6 6 2 7 7 10 3 10
 */