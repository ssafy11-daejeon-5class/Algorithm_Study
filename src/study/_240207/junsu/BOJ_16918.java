package study._240207.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {

	public static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int R, C, N;
	static int[][] maps;
	static Queue<Node> cand;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maps = new int[R][C];
		cand = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String map = br.readLine();
			for (int j = 0; j < C; j++) {
				if (map.charAt(j) == '.') {
					maps[i][j] = 0;
				} else {
					maps[i][j] = 1;
					cand.offer(new Node(i, j));
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) {
				fillBomb();
				continue;
			} else {
				bomb();
			}
		}

		printMaps();

	}

	private static void bomb() {
		// TODO Auto-generated method stub
		while(!cand.isEmpty()) {
			Node cur = cand.poll();
			maps[cur.i][cur.j] = 0;
			for(int k = 0 ; k < 4 ; k++) {
				int ni = cur.i + di[k];
				int nj = cur.j + dj[k];
				if( ni>= 0 && ni < R && nj >= 0 && nj < C ) {
					maps[ni][nj] = 0;
				}
			}
		}
		// maps 순회하며 현재 남아있는 폭탄의 위치 cand에 저장하기
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(maps[i][j] == 1) {
					cand.offer(new Node(i,j));
				}
			}
		}
	}

	private static void printMaps() {
		// TODO Auto-generated method stub
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (maps[i][j] == 1) {
					System.out.print("O");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	private static void fillBomb() {
		// TODO Auto-generated method stub
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				maps[i][j] = 1;
			}
		}
	}

}
