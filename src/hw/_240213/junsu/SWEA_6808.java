package hw._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_6808 { // 규영이와 인영이의 카드게임

	static int T, win, lose;
	static int[] com;
	static int[] arr;
	static int[] cand;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[18];
		for (int i = 0; i < 18; i++) {
			arr[i] = i + 1;
		}
		
		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			com = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 9 ; i++) {
				com[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(com);
			for(int i = 0 ; i < 18 ; i++) {
				
			}
			System.out.println("#" + t + " " + win + " " + lose);
			
		}
	}

}
