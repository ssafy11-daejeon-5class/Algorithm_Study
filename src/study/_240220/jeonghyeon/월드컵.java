package study._240220.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵 {
	static int[][] fights = new int[6][3];
	static int[][] virtualFight;

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
			 * 사전에 검증할 것 :
			 * 
			 * 1. 나라별 승무패수 합이 5인지
			 * 
			 * 2. 무승부수합이 짝수이고 무승부수합의 과반을 차지하는 국가가 없는지
			 * 
			 * 3. 승수합과 패수합이 같은지
			 */

			// System.out.println("round " + (i + 1));

			// 나라별 승무패수 합이 5인지
			for (int j = 0; j < 6; j++) {
				int sum = 0;
				for (int k = 0; k < 3; k++) {
					sum += fights[j][k];
				}
				// System.out.println((j + 1) + "th sum : " + sum);

				if (sum != 5) {
					sb.append("0 ");
					continue L;
				}
			}

			// 무승부수합이 짝수이고 무승부수합의 과반을 차지하는 국가가 없는지
			int sum = 0;
			int maxVal = 0;
			for (int j = 0; j < 6; j++) {
				sum += fights[j][1];
				maxVal = Math.max(maxVal, fights[j][1]);
			}
			// System.out.println("sum : " + sum + ", maxVal : " + maxVal);
			if (sum % 2 == 1 || maxVal > sum / 2) {
				sb.append("0 ");
				continue L;
			}

			// 승수합과 패수합이 같은지
			int winSum = 0;
			int loseSum = 0;
			for (int j = 0; j < 6; j++) {
				winSum += fights[j][0];
				loseSum += fights[j][0];
			}
			// System.out.println("winSum : " + winSum + ", loseSum : " + loseSum);
			if (winSum != loseSum) {
				sb.append("0 ");
				continue L;
			}

			virtualFight = new int[6][3];
			if (combination(0, 0) == true)
				sb.append("1 ");
			else
				sb.append("0 ");

		}

		System.out.println(sb);
	}

	private static boolean combination(int country1, int country2) {

		if (country1 == 4 && country2 == 5) {
			if (itsRight()) {
				return true;
			}
			return false;
		}

		int nc1, nc2;
		if (country2 == 5) {
			nc1 = country1 + 1;
			nc2 = nc1 + 1;
		} else {
			nc1 = country1;
			nc2 = country2 + 1;
		}

		// 1국 승
		virtualFight[nc1][0]++;
		virtualFight[nc2][2]++;
		if (combination(nc1, nc2))
			return true;
		virtualFight[nc1][0]--;
		virtualFight[nc2][2]--;

		// 2국 승
		virtualFight[nc1][2]++;
		virtualFight[nc2][0]++;
		if (combination(nc1, nc2))
			return true;
		virtualFight[nc1][2]--;
		virtualFight[nc2][0]--;

		// 무승부
		virtualFight[nc1][1]++;
		virtualFight[nc2][1]++;
		if (combination(nc1, nc2))
			return true;
		virtualFight[nc1][1]--;
		virtualFight[nc2][1]--;

		return false;

	}

	private static boolean itsRight() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (fights[i][j] != virtualFight[i][j])
					return false;
			}
		}

		return true;
	}

}
