package study._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 프로세서연결하기 {

	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.i + " " + this.j;
		}
	}

	static int T, N, answer, lineSum;
	static List<Node> cores;
	static Node[] sel;
	static StringTokenizer st;
	static boolean[][] v;
	static int[][] maps;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine());
			maps = new int[N][N];
			cores = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					if (maps[i][j] == 1 && i != 0 && i != N-1 && j != 0 && j != N-1) {
						cores.add(new Node(i, j));
					}
				}
			}
			
			sel = new Node[cores.size()];
			combi(0, cores.size());
			
			
//			for (int i = 0; i < cores.size(); i++) {
//				sel = new Node[cores.size() - i];
//				combi(0, cores.size() - i);
//				if(answer != Integer.MAX_VALUE) {
//					System.out.println("#" + t + " " + answer);
//					break;
//				}
//			}
		}

	}

	private static void combi(int depth, int cnt) {
		if(cnt == 0) {
			// 조합 발견 -> 비즈니스 로직 시작
			lineSum = 0;
			v = new boolean[N][N];
			if(check(0, 0)) {
				answer = Math.min(answer, lineSum);
			}
			return;
		} if (depth == cores.size()) {
			return;
		}
		
		sel[sel.length - cnt] = cores.get(depth);
		combi(depth + 1, cnt - 1);
		combi(depth + 1, cnt);
	}

	private static boolean check(int depth, int sum) {
		if(depth == sel.length) {
			lineSum = sum;
			return true;
		}
		for (int i = 0; i < 4; i++) {
			
		}
		return false;
	}
}
