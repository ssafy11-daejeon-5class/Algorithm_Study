package study._240326.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {
	static int len;
	static String gwalhos;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		gwalhos = br.readLine().toString();

		if (len % 2 == 1) {
			System.out.println("No");
			return;
		}

		int inputCnt = 0;
		int outputCnt = 0;
		for (int i = 0; i < len; i++) {
			if (gwalhos.charAt(i) == '(')
				inputCnt++;
			else if (gwalhos.charAt(i) == ')')
				outputCnt++;
		}

		int leftInputCnt = len / 2 - inputCnt;
		int leftOutputCnt = len / 2 - outputCnt;
		if (leftInputCnt < 0 || leftOutputCnt < 0) {
			System.out.println("No");
			return;
		}

		int innerPeopleCnt = 0;
		for (int i = 0; i < len; i++) {
			if (gwalhos.charAt(i) == '(')
				innerPeopleCnt++;
			else if (gwalhos.charAt(i) == ')')
				innerPeopleCnt++;
			else {
				if (leftInputCnt > 0) {
					leftInputCnt--;
					innerPeopleCnt++;
				} else {
					innerPeopleCnt--;
				}
			}

			if (innerPeopleCnt < 0) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
		return;

	}

}
