package study._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		String[] people = br.readLine().split(" ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < people.length; i++) {
			int p = Integer.parseInt(people[i]);
			int answer = 0;
			if ((p - 1) % (A + B) + 1 <= A)
				answer++;
			if ((p - 1) % (C + D) + 1 <= C)
				answer++;
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
