package hw._240206.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16918 {

	static String[] area;
	static int R;
	static int C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		area = new String[R];
		for (int i = 0; i < R; i++) {
			area[i] = br.readLine();
		}
		
		if (N == 1) {
			// 원본 출력
			print();
		} else if (N % 2 == 0) {
			// 모두 폭탄으로 출력, N이 2의 배수면 모두 같음
			printEverybodyBomb();
		} else if (N % 4 == 3) {
			// 한 번 터진 모습 출력, N%4가 3인 N들은 모두 같음
			pang();
			print();
		} else if (N % 4 == 1) {
			// 두 번 터진 모습 출력, 1을 제외하고 N%4가 1인 N들은 모두 같음
			pang();
			pang();
			print();			
		}
	}
	
	static void pang() {
		String[] tempArea = new String[R];
		for (int r = 0; r < R; r++) {
			StringBuilder newLine = new StringBuilder();
			for (int c = 0; c < C; c++) {
				if (isBomb(r, c) || isBombNextToMe(r, c)) {
					newLine.append(".");
				} else {
					newLine.append("O");
				}
			}
			tempArea[r] = newLine.toString();
		}
		area = tempArea;
	}

	static boolean isBombNextToMe(int r, int c) {
		int[] nextR = { r, r + 1, r, r - 1 };
		int[] nextC = { c + 1, c, c - 1, c };
		for (int i = 0; i < 4; i++) {
			if (isInArea(nextR[i], nextC[i])) {
				if (area[nextR[i]].charAt(nextC[i]) == 'O') {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isBomb(int r, int c) {
		if (area[r].charAt(c) == 'O') {
			return true;
		}
		return false;
	}

	static boolean isInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return false;
		return true;
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			sb.append(area[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void printEverybodyBomb() {
		StringBuilder sb = new StringBuilder();
		String oneLine = "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"
		.substring(0, C);
		for (int i = 0; i < R; i++) {
			sb.append(oneLine);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
