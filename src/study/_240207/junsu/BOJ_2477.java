package study._240207.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {

	static class Side {
		int dir;
		int length;

		public Side(int dir, int length) {
			this.dir = dir;
			this.length = length;
		}
	}

	static int K;
	static Side[] sides;
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		arr = new int[4];
		sides = new Side[6];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			sides[i] = new Side(dir, length);
			arr[dir] += 1;
		}
		
	}

}
