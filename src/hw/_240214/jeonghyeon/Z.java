package hw._240214.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	static int N, R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int answer = 0;

		for (int n = N; n > 0; n--) {
			int midVal = (int) Math.pow(2, n - 1);
			System.out.println(midVal);

			if (R < midVal) {
				if (C < midVal) {
					continue;
				} else {
					C -= midVal;
					answer += midVal * midVal;
				}
			} else {
				if (C < midVal) {
					R -= midVal;
					answer += midVal * midVal * 2;
				} else {
					R -= midVal;
					C -= midVal;
					answer += midVal * midVal * 3;
				}
			}

		}

		System.out.println(answer);

	}
}
