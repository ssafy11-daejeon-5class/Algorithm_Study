package hw._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ3040 {
	static int n;
	static int[] num = new int[9];
	static int[] sel = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		recursive(0, 0, 0);
	}

	private static void recursive(int idx, int k, int sum) {
		// basis part

		if (k == sel.length) {

			if (sum == 100) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 7; i++) {
					sb.append(sel[i]);
					sb.append("\n");
				}
				System.out.println(sb);
			}
			return;
		}

		if (idx == 9)
			return;

		// inductive part
		sel[k] = num[idx];
		recursive(idx + 1, k + 1, sum + num[idx]);
		recursive(idx + 1, k, sum);
	}

}