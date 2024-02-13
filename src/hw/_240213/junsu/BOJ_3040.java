package hw._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040 {	// 백설 공주와 일곱 난쟁이
	static int[] nums;
	static int[] sel;
	static int sum;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[9];
		sel = new int[7];
		v = new boolean[9];
		
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0, 0);
	}

	private static void combi(int depth, int k) {
		if(k == 7) {
			sum = 0;
			for (int i : sel) {
				sum += i;
			}
			if(sum == 100) {
				for (int i : sel) {
					System.out.println(i);
				}
			}
			return;
		}
		if(depth == 9) {
			return;
		}
		sel[k] = nums[depth];
		combi(depth + 1, k + 1);
		combi(depth + 1, k);
	}

}
