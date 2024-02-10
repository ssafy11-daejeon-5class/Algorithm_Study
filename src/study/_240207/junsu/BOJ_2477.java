package study._240207.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

	static int K, maxR, indexR, maxC, indexC;
	static int[][] values;
	static StringTokenizer st;
	static int[] input;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		input = new int[6];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			if(dir==3 || dir==4) {// r
				maxR=maxR<distance?distance:maxR;
				if (maxR==distance) indexR=i;
			}else { // c
				maxC=maxC<distance?distance:maxC;
				if (maxC==distance) indexC=i;
			}
			input[i] = distance;
		}

		System.out.println();
	}

}
