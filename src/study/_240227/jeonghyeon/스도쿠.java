package study._240227.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스도쿠 {
	static int[][] map, newMap;
	static int[] emptyCntOfRow;
	static int[] emptyCntOfCol;
	static int[][] emptyCntOfArea;
	static Queue<Point> queue;

	public static void main(String[] args) throws Exception {
		
		getInput();
		
		printMap();
	}

	private static void getInput() throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		emptyCntOfRow = new int[9];
		emptyCntOfCol = new int[9];
		emptyCntOfArea = new int[3][3];
//		Arrays.fill(emptyCntOfRow, 9);
//		Arrays.fill(emptyCntOfCol, 9);
//		for(int i = 0; i < 3; i++)
//			Arrays.fill(emptyCntOfArea[i], 9);
		
		map = new int[9][9];
		queue = new ArrayDeque();
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					queue.offer(new Point(i, j));
					emptyCntOfRow[i]++;
					emptyCntOfCol[j]++;
					emptyCntOfArea[i/3][j/3]++;
				}
			}
		}
	}
	
	private static void fillMap() {
		
	}
	
	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb + "\n");
	}
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
}
