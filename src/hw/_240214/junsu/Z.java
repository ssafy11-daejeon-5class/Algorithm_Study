package hw._240214.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, r, c, sum = 0;
	static int[][] maps;
	static StringTokenizer st;
	static int dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		recursive(r, c, N);
		System.out.println(sum);
	}

	private static void recursive(int curRow, int curCol, int depth) {
		if (depth == 0) {
			return;
		}
		int mid = 1 << (depth - 1);
		// 첫번째
		if (curCol < mid && curRow < mid) {
			recursive(curRow, curCol, depth - 1);
		} else if (curRow < mid && curCol >= mid) {
			sum += mid * mid;
			recursive(curRow, curCol - mid, depth - 1);
		} else if (curRow >= mid && curCol < mid) {
			sum += mid * mid * 2;
			recursive(curRow - mid, curCol, depth - 1);
		} else if (curRow >= mid && curCol >= mid) {
			sum += mid * mid * 3;
			recursive(curRow - mid, curCol - mid, depth - 1);
		}
	}

}
