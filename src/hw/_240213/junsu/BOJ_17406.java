package hw._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406 {	// 배열 돌리기4

	static int N, M, K, r, c, s, answer;
	static int[][] cmd;
	static int[][] arr;
	static int[] sel;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cmd = new int[K][3];
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			cmd[i] = new int[] {r-1, c-1, s};
		}
		
		sel = new int[K];
		v = new boolean[K];
		permutation(0);
		System.out.println(answer);
		
	}

	private static void permutation(int depth) {
		if(depth == K) {
			int[][] tmp = copy(arr);
			int cand = Integer.MAX_VALUE;
			for (int i = 0; i < K; i++) {
				tmp = rotate(cmd[sel[i]][0], cmd[sel[i]][1], cmd[sel[i]][2], tmp);
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += tmp[i][j];
				}
				cand = Math.min(cand, sum);
			}
			answer = Math.min(cand, answer);
			return;
		}
		for (int i = 0; i < cmd.length; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[depth] = i;
			permutation(depth + 1);
			v[i] = false;
		}
		
	}

	private static void print(int[][] t) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] rotate(int R, int C, int S, int[][] tmp) {
		int[][] res = copy(tmp);
		for (int i = 1; i <= S; i++) {
			for (int k = C - i ; k < C + i; k++) {
				res[R-i][k+1] = tmp[R-i][k];
			}
			for (int k = R - i ; k < R + i; k++) {
				res[k+1][C+i] = tmp[k][C+i];
			}
			for (int k = C - i + 1; k <= C + i; k++) {
				res[R+i][k-1] = tmp[R+i][k];
			}
			for (int k = R - i + 1; k <= R + i; k++) {
				res[k-1][C-i] = tmp[k][C-i];
			}
		}
		return res;
	}

	private static int[][] copy(int[][] tt) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = tt[i][j];
			}
		}
		return tmp;
	}

}
