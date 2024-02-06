package hw._240206.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int answer = 1;
			if (N % 2 == 0) {
				answer = 0;
			}
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				if (answer == 0)
					continue;
				st.nextToken();
				char c = st.nextToken().charAt(0);
				if (i <= N / 2 && !isOperator(c)) {
					answer = 0;
				} else if (i > N / 2 && !isNumber(c)) {
					answer = 0;
				}
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}

	static boolean isNumber(char c) {
		if ((int) c >= 48 && (int) c <= 57) {
			return true;
		}
		return false;
	}

}
