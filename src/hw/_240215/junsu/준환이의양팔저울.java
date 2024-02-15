package hw._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {

	static int T, N, answer;
	static int[] weights;
	static int[] sel;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			
			// 무게 추 입력 받기
			weights = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			solve();
			System.out.println("#" + t + " " + answer);
		}
	}
	
	private static void solve() {
		sel = new int[N];
		v = new boolean[N];
		permu(0);
	}

	
	private static void permu(int depth) {
		if(depth == N) {
			recursive(1, sel[0], 0);
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[depth] = weights[i];
			permu(depth+1);
			v[i] = false;
		}
	}

	private static void recursive(int depth, int leftSum, int rightSum) {
		if(depth == N) {
			answer++;
			return;
		}
		if(rightSum + sel[depth] <= leftSum) { // 두 가지 recursive 모두 호출
			recursive(depth + 1, leftSum + sel[depth], rightSum);
			recursive(depth + 1, leftSum, rightSum + sel[depth]);
		} else {								// 왼쪽에 추가하는 recursive만 호출
			recursive(depth + 1, leftSum + sel[depth], rightSum);
		}
	}
}
