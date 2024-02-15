package hw._240215.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 준환이의양팔저울_SWEA3234 {
	static int N;
	static int[] chu;
	static int[] sel;
	static boolean[] v;
	static int total;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			chu = new int[N];
			sel = new int[N];
			v = new boolean[N];
			total = 0;
			answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				total += chu[i];
			}

			/*
			 * 순열을 9!만큼 만들고 하나씩 돌려봄
			 * 
			 * 왼쪽에 먼저 쌓고 그 다음은 분기를 해주는데
			 * 
			 * 오른쪽이 무거워지면 바로 컷
			 * 
			 * 왼쪽의 앞선 무게가 남은 모든 추의 합보다 크면 경우의 수 계산해서 answer에 더하고 끝
			 */

			permutation(0);

			System.out.println("#" + t + " " + answer);
		}

	}

	private static void permutation(int k) {
		// basis part
		// 다 골랐어요
		if (k == sel.length) {
			// System.out.println(Arrays.toString(sel));
			weighing(sel[0], 0, total - sel[0], 1);
			return;
		}

		// inductive part
		for (int i = 0; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[k] = chu[i];
				permutation(k + 1);
				v[i] = false;
			}
		}
	}

	private static void weighing(int left, int right, int leftover, int idx) {
		// basis part
		if (idx == N) {
			answer++;
			return;
		}

		// inductive part
		leftover -= sel[idx];
		weighing(left + sel[idx], right, leftover, idx + 1);

		// 오른쪽 무거워지면 컷
		if (right + sel[idx] <= left) {
			weighing(left, right + sel[idx], leftover, idx + 1);
		}
	}

}
