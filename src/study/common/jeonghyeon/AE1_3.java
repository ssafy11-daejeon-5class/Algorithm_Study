package study.common.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AE1_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		List<Integer> S = new ArrayList<>();
		S.add(0);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Math.pow(2, N) - 1; i++) {
			S.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			System.out.println(S);
			List<Integer> newS = new ArrayList<>();
			int smallestNum = S.get(1);
			answer.add(smallestNum);
			for (int j = 0; j < S.size() - 1; j++) {
				for (int k = j + 1; k < S.size(); k++) {
					System.out.println("s : " + S);
					if (S.get(k) > 0 && S.get(j) + smallestNum == S.get(k)) {
						S.set(k, -1);
						newS.add(S.get(j));
						break;
					}
				}
			}
			S = newS;
		}

		System.out.println("answer : " + answer);

	}
}
