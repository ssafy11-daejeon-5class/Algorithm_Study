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

	static int T, N, answerCnt, answer, lineSum, coreCnt;
	static List<Node> cores;
	static StringTokenizer st;
	static boolean[][] v;
	static int[][] maps;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = Integer.MAX_VALUE;
			answerCnt = Integer.MIN_VALUE;

			N = Integer.parseInt(br.readLine());
			maps = new int[N][N];
			cores = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
					if (maps[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						cores.add(new Node(i, j));
					}
				}
			}

			coreCnt = cores.size();
			combi(0, 0, 0, 0);

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

	private static void combi(int depth, int idx, int cnt, int lineCnt) {
		// TODO Auto-generated method stub
		if (depth == coreCnt) {
			if (answerCnt < cnt) {
				answerCnt = cnt;
				answer = lineCnt;
			} else if (answerCnt == cnt) {
				answer = Math.min(answer, lineCnt);
			}
			return;
		}

		// 체크해서 해당 방향으로 직진이 가능하다면 check() -> 재귀타고 돌아와서 unCheck() 해주고 제외하고 재귀한번 더 타기.
		for (int i = 0; i < 4; i++) {

		}
	}
}
