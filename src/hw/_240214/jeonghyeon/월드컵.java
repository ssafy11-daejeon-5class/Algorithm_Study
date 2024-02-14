package hw._240214.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵 {
	static int[][] fights = new int[6][3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		L: for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 18; j++) {
				fights[j / 3][j % 3] = Integer.parseInt(st.nextToken());
			}

			/*
			 * 검증할 것 :
			 * 
			 * 1. 나라별 승무패수 합이 5인지
			 * 
			 * 2. 무승부수합이 짝수이고 무승부수합의 과반을 차지하는 국가가 없는지
			 * 
			 * 3. 승수합과 패수합이 같은지
			 */

			System.out.println("round " + (i + 1));

			for (int j = 0; j < 6; j++) {
				int sum = 0;
				for (int k = 0; k < 3; k++) {
					sum += fights[j][k];
				}

				System.out.println((j + 1) + "th sum : " + sum);

				if (sum != 5) {
					sb.append("0 ");
					continue L;
				}
			}

			int sum = 0;
			int maxVal = 0;
			for (int j = 0; j < 6; j++) {
				sum += fights[j][1];
				maxVal = Math.max(maxVal, fights[j][1]);
			}
			System.out.println("sum : " + sum + ", maxVal : " + maxVal);
			if (sum % 2 == 1 || maxVal > sum / 2) {
				sb.append("0 ");
				continue L;
			}

			int winSum = 0;
			int loseSum = 0;
			for (int j = 0; j < 6; j++) {
				winSum += fights[j][0];
				loseSum += fights[j][0];
			}
			System.out.println("winSum : " + winSum + ", loseSum : " + loseSum);
			if (winSum != loseSum) {
				sb.append("0 ");
				continue L;
			}

			int[][] league = new int[6][6];
			while (true) {

			}

			sb.append("1 ");

		}

		System.out.println(sb);
	}
}
