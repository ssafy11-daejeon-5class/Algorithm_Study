package hw._240207.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 { // 배열 돌리기3

	static int N, M, R, cmd, temp;
	static StringTokenizer st;
	static int[][] arr;
	static int[][] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		// 배열 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case 1:
				arr = fun1();
				break;
			case 2:
				arr = fun2();
				break;
			case 3:
				arr = fun3();
				temp = N;
				N = M;
				M = temp;
				break;
			case 4:
				arr = fun4();
				temp = N;
				N = M;
				M = temp;
				break;

			case 5:
				arr = fun5();
				break;

			case 6:
				arr = fun6();
				break;
			}
		}
		print();

	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] fun6() {
		// TODO Auto-generated method stub
		answer = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				answer[i + N / 2][j] = arr[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				answer[i][j - M / 2] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				answer[i - N /2][j] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				answer[i][j+M/2] = arr[i][j];
			}
		}
		return answer;
	}

	private static int[][] fun5() {
		// TODO Auto-generated method stub
		answer = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				answer[i][j + M / 2] = arr[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				answer[i + N / 2][j] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				answer[i][j - M / 2] = arr[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				answer[i - N / 2][j] = arr[i][j];
			}
		}
		return answer;

	}

	private static int[][] fun4() { // 왼쪽 90도 회전
		// TODO Auto-generated method stub
		answer = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[M - 1 - j][i] = arr[i][j];
			}
		}
		return answer;
	}

	private static int[][] fun3() { // 오른쪽 90도 회전
		// TODO Auto-generated method stub
		answer = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[j][N - 1 - i] = arr[i][j];
			}
		}
		return answer;
	}

	private static int[][] fun2() { // 좌우 반전
		// TODO Auto-generated method stub
		answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[i][M - 1 - j] = arr[i][j];
			}
		}
		return answer;
	}

	private static int[][] fun1() { // 상하 반전
		// TODO Auto-generated method stub
		answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[N - 1 - i][j] = arr[i][j];
			}
		}
		return answer;
	}
}
