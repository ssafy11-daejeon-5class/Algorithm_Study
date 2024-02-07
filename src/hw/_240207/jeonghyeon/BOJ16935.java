package hw._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {

	static int N;
	static int M;
	static int R;
	static String[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int operNum = Integer.parseInt(st.nextToken());
			operSomething(operNum);
		}
		print();
	}

	static void operSomething(int operNum) {
		switch (operNum) {
		case 1: {
			oper1();
			break;
		}
		case 2: {
			oper2();
			break;
		}
		case 3: {
			oper3();
			break;
		}
		case 4: {
			oper4();
			break;
		}
		case 5: {
			oper5();
			break;
		}
		case 6: {
			oper6();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operNum);
		}

	}

	static void oper1() {
		String[][] newArr = new String[N][M];
		for (int i = 0; i < N; i++) {
			newArr[i] = arr[N - 1 - i];
		}
		arr = newArr;
	}

	static void oper2() {
		String[][] newArr = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[i][j] = arr[i][M - 1 - j];
			}
		}
		arr = newArr;
	}

	static void oper3() {
		swapNM();
		String[][] newArr = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[i][j] = arr[M - 1 - j][i];
			}
		}
		arr = newArr;
	}

	static void oper4() {
		swapNM();
		String[][] newArr = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[i][j] = arr[j][N - 1 - i];
			}
		}
		arr = newArr;
	}

	static void oper5() {
		String[][] newArr = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 1사분면 -> 2사분면
				if (i < N / 2 && j >= M / 2)
					newArr[i + N / 2][j] = arr[i][j];
				// 2사분면 -> 3
				else if (i >= N / 2 && j >= M / 2)
					newArr[i][j - M / 2] = arr[i][j];
				// 3사분면 -> 4
				else if (i >= N / 2 && j < M / 2)
					newArr[i - N / 2][j] = arr[i][j];
				// 4사분면 -> 1
				else if (i < N / 2 && j < M / 2)
					newArr[i][j + M / 2] = arr[i][j];
			}
		}
		arr = newArr;
	}

	static void oper6() {
		String[][] newArr = new String[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 1사분면 -> 4사분면
				if (i < N / 2 && j >= M / 2)
					newArr[i][j - M / 2] = arr[i][j];
				// 2사분면 -> 1
				else if (i >= N / 2 && j >= M / 2)
					newArr[i - N / 2][j] = arr[i][j];
				// 3사분면 -> 2
				else if (i >= N / 2 && j < M / 2)
					newArr[i][j + M / 2] = arr[i][j];
				// 4사분면 -> 3
				else if (i < N / 2 && j < M / 2)
					newArr[i + N / 2][j] = arr[i][j];
			}
		}
		arr = newArr;
	}

	static void swapNM() {
		int temp = N;
		N = M;
		M = temp;
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
