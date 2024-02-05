package study.common.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class AE1_3_retry {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		List<Integer> S = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Math.pow(2, N) - 1; i++) {
			S.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> answer = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		int smallest = S.get(0);
		for (int j = 0; j < N; j++) {
			smallest = S.get(0);
			answer.add(smallest);
			List<Integer> newS = new ArrayList<>();
			for (int i = 1; i < S.size(); i++) {
				if (!queue.isEmpty() && queue.peek() + smallest == S.get(i)) {
					newS.add(queue.poll());
				} else
					queue.offer(S.get(i));
			}
			S = newS;
			System.out.println(S);
		}

		System.out.println("answer : " + answer);

	}
}
