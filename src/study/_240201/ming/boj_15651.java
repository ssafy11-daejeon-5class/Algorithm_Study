package study._240201.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651 {
	// N과 M (3) - 중복 수열
	static int n, m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// initialize
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];

		// function call
		recursive(0);

		// output
		System.out.println(sb);
	}

	private static void recursive(int k) {
		// basis part
		if (k == m) {
			for (int i : selected)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		// inductive part
		for (int i = 1; i <= n; i++) {
			selected[k] = i;
			recursive(k + 1);
		}
	}

}
