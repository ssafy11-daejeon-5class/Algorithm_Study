package study._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {	// 크로아티아 알파벳
	/*
	 * 
	 */

	static String input;
	static String[] croatic = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		for (String s : croatic) {
			input = input.replace(s, "*");
		}
		System.out.println(input.length());
	}

}
