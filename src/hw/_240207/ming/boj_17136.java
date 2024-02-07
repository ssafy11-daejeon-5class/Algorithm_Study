package hw._240207.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17136 {
	// 색종이 붙이기
	static int[][] map = new int[10][10];
	
	public static void main(String[] args) {
		
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i<10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
