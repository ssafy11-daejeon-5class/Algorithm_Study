package hw._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전 { // SWEA_5644

	static int T, M, A, answer; // 테스트 케이스 수, 총 이동 시간, 충전기 개수
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
