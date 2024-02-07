package study._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = (int) Math.sqrt((double) s.length()); i > 1; i--) {
			if (s.length() % i == 0) {
				for (int j = 0; j < i; j++) {
					for (int k = 0; k < s.length() / i; k++) {
						sb.append(s.charAt(k * i + j));
					}
				}
				break;
			}
		}
		if (sb.length() == 0)
			System.out.println(s);
		else
			System.out.println(sb);
	}

}
