package hw._240201.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] sours;
	static int[] bitters;
	static boolean[] isUsed;
	static int minCha = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		sours = new int[N];
		bitters = new int[N];
		isUsed = new boolean[N];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sours[n] = Integer.parseInt(st.nextToken());
			bitters[n] = Integer.parseInt(st.nextToken());
			isUsed[n] = false;
		}

		

		powerSet(0, 0);
		System.out.println(minCha);
	}
	
	private static void powerSet(int idx, int k) {
		// basis part
		// 선택했으면
		if(idx == sours.length) {
			int sour = 1;
			int bitter = 0;
			for(int i = 0; i < sours.length; i++) {
				if(isUsed[i]) {
					sour *= sours[i];
					bitter += bitters[i];
				}
			}
			if(bitter == 0) return;
			minCha = Math.min(minCha, Math.abs(bitter-sour));
			return;
		}
		
		// inductive part
		isUsed[idx] = true;
		powerSet(idx+1, k+1);
		isUsed[idx] = false;
		powerSet(idx+1, k);
	}
}
