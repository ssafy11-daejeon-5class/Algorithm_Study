package study._240227.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

	static class Node {
		int i, j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return i + " " + j;
		}
	}

	static int R, C, T;
	static int[][] maps;
	static StringTokenizer st;
	static Node[] refresher = new Node[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		maps = new int[R][C];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == -1) {
					refresher[cnt++] = new Node(i, j);
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			maps = spread();
			maps = refresh();
			System.out.println();
			print();
		}
	}
	
	private static int[][] spread() {
		int[][] res = new int[R][C];
		int count;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(maps[i][j] != 0 && maps[i][j] == -1){
					count = 0;
					for (int k = 0; k < 4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						if(ni >= 0 && ni < R && nj >= 0 && nj < C){
							if(maps[ni][nj] != -1){
								count++;
								
							}
						}
					}
				}
			}	
		}
		return res;
	}
	
	// 시계방향으로 설정
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	
	private static int[][] refresh() { 
		int[][] res = new int[R][C];
		Node up = refresher[0];		// 반시계방향으로 도는 위쪽 공기청정기
		Node down = refresher[1];	// 시계방향으로 도는 아래쪽 공기청정기
		return res;
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
