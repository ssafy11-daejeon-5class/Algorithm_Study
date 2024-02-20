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

	static int T, N, answerCnt, answer, lineSum, coreCnt, addNum;
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
			combi(0, 0, 0);
			System.out.println("#" + t + " " + answer);
		}

	}
	static int test = 0;
	private static void combi(int depth, int idx, int lineCnt) { // 탐색의 깊이, List의 인덱스, 전선의 길이
		// TODO Auto-generated method stub
		if (depth == coreCnt) {
			if (answerCnt < idx) {
//				System.out.println(test++);
				answerCnt = idx;
				answer = lineCnt;
			} else if (answerCnt == idx) {
//				System.out.println(test++);
				answer = Math.min(answer, lineCnt);
			}
			return;
		}

		// 체크해서 해당 방향으로 직진이 가능하다면 check() -> 재귀타고 돌아와서 unCheck() 해주고 제외하고 재귀한번 더 타기.
		for (int i = 0; i < 4; i++) {
			if (valid(i, depth)) {
				addNum = 0;
				check(i, depth, 2);
				combi(depth + 1, idx + 1, lineCnt + addNum);
				check(i, depth, 0);
			}
		}
		combi(depth + 1, idx, lineCnt);
	}

	private static void check(int direction, int index, int num) { // 체크할 방향, 프로세서 index, 변경할 숫자
		int curi = cores.get(index).i;
		int curj = cores.get(index).j;

		for (int k = 1; k < N; k++) {
			curi = curi + di[direction];
			curj = curj + dj[direction];
			if (curi >= 0 && curi < N && curj >= 0 && curj < N) {
				maps[curi][curj] = num;
				addNum++;
			} else {
				break;
			}
		}
	}

	private static boolean valid(int direction, int index) { // 탐색할 방향, 프로세서 index
		int curi = cores.get(index).i;
		int curj = cores.get(index).j;
		for (int k = 1; k < N; k++) {
			curi = curi + di[direction];
			curj = curj + dj[direction];

			if (curi >= 0 && curi < N && curj >= 0 && curj < N) {
				if (maps[curi][curj] != 0) {
					return false;
				}
			} else {
				break;
			}
		}
		return true;
	}
}
