package study._240305.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이붙이기 {
	static int[] paperCnt = new int[6];
	static char[][] map = new char[10][10];
	static int totalCnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		} 
		recursive(0, 0);
		System.out.println((totalCnt == Integer.MAX_VALUE)?-1:totalCnt);
		
	}

	private static void recursive(int idx, int cnt) {
		if(cnt >= totalCnt) {
			return;
		}
		if(idx == 100) {
			totalCnt = cnt;
			return;
		}
		
		int r = idx/10;
		int c = idx%10;
		if(map[r][c] == '1') {
			for(int length = 5; length >= 1; length--) {
				if(doIt(r, c, length)) {
					recursive(idx+length, cnt+1);
					redoIt(r, c, length);
				}
			}
		}
		else
			recursive(idx+1, cnt);
	}
	
	private static boolean doIt(int R, int C, int length) {
		if(R+length > 10 || C + length > 10) {
			return false;
		}
		
		for(int r = R; r < R+length; r++) {
			for(int c = C; c < C+length; c++) {
				if(map[r][c] == '0') {
					return false;
				}
			}
		}
		
		if(++paperCnt[length] == 6) {
			paperCnt[length]--;
			return false;
		}
		for(int r = R; r < R+length; r++) {
			for(int c = C; c < C+length; c++) {
				map[r][c] = '0';
			}
		}
		
		return true;
	}
	
	private static void redoIt(int R, int C, int length) {
		for(int r = R; r < R+length; r++) {
			for(int c = C; c < C+length; c++) {
				map[r][c] = '1';
			}
		}
		paperCnt[length]--;
	}

}
