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

	static int K;
	static int[][] values;
	static StringTokenizer st;
	static List<List<Integer>> sides;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		sides = new ArrayList<>();

		for(int i = 0 ; i < 4; i++){
			sides.add(new ArrayList<>());
		}
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			sides.get(dir-1).add(length);
		}
		int i = 0;
		values = new int[2][2];
		for (List list : sides) {
			if(list.size() == 2){
				values[i][0] = (int) list.get(0);
				values[i][1] = (int) list.get(1);
				i++;
			}
		}
		Arrays.sort(values[0]);
		Arrays.sort(values[1]);

		System.out.println(values[0][1] * values[1][1] - values[0][0]*values[1][0]);
	}

}
