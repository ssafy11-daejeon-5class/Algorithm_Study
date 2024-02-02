package hw._240202.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1225 {
	// [S/W 문제해결 기본] 7일차 - 암호생성기
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=10 ; i++) {
			int t = Integer.parseInt(br.readLine());
			
			// 
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[8];
			for(int j=0 ; j<8 ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			// 
			
		}
	}

}
