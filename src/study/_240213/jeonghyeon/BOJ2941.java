package study._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int answer = 0;
		String[] croatia = { "c=", "c-", "d-", "lj", "nj", "s=", "z=" };

		for (int i = 0; i < s.length(); i++) {
			answer++;

			if (i < s.length() - 2 && s.substring(i, i + 3).equals("dz=")) {
				i += 2;
			} else if (i < s.length() - 1) {
				for (String word : croatia) {
					if (s.substring(i, i + 2).equals(word)) {
						i++;
						break;
					}
				}
			}
		}

		System.out.println(answer);

	}
}

/*
 * 
 * c= c- dz= d- lj nj s= z=
 */