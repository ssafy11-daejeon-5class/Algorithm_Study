package study._240227.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 스도쿠 {

	static List<int[]> cand; 
	static StringTokenizer st;
	static int[][] maps;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cand = new ArrayList<int[]>();
		maps = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if(maps[i][j] == 0) {
					cand.add(new int[] {i, j});
				}
			}
		}
		recursive(0);
		
	}
	
	private static boolean recursive(int depth) {
		// basis part
		if(depth == cand.size()) {
			print(maps);
			return true;
		}
		int r = cand.get(depth)[0];
		int c = cand.get(depth)[1];
		for (int i = 1; i <= 9; i++) {
			if(check(r,c,i)) {
				maps[r][c] = i;
				if(recursive(depth+1)) return true;
				maps[r][c] = 0;
			}
		}
		return true;
	}

	private static void print(int[][] maps) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean check(int r, int c, int num) {
		boolean flag = true;
		// 가로 점검
		for (int i = 0; i < 9; i++) {
			if(num == maps[i][c]) {
				flag = false;
			}
		}
		
		// 세로 점검
		for (int i = 0; i < 9; i++) {
			if(num == maps[r][i]) {
				flag = false;
			}
		}
		
		// 사각형 점검
		for (int i = (r/3) * 3; i < 3 + r/3; i++) {
			for (int j = (c/3) * 3; j < 3 + c/3; j++) {
				if(maps[i][j] == num) {
					flag = false;
				}
			}
		}
		return flag;
	}

}
