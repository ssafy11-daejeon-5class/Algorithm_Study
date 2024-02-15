package hw._240214.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {

	static int N;
	static int[][] maps;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				if(temp.charAt(j) == '0') {
					maps[i][j] = 0;
				} else {
					maps[i][j] = 1;
				}
			}
		}
		
		
	}

}
