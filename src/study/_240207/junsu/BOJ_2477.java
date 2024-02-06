package study._240207.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

	static int K, min_c, min_l, max_c, max_l;
	static StringTokenizer st;
	static List<int[]> sides;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		sides = new ArrayList<>();
		
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
		}
		
		for
		
	}

}
