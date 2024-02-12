package hw._240208.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17406 {
	static int N;
	static int M;
	static int K;
	static String[][] mapOriginal;
	static int[][] operation;
	static int[] sel;
	static boolean[] v;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		mapOriginal = new String[N][M];
		for (int i = 0; i < N; i++) {
			mapOriginal[i] = br.readLine().split(" ");
		}
		operation = new int[K][3];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			operation[k][0] = Integer.parseInt(st.nextToken()) - 1;
			operation[k][1] = Integer.parseInt(st.nextToken()) - 1;
			operation[k][2] = Integer.parseInt(st.nextToken());
		}
		sel = new int[K];
		v = new boolean[K];
		
			
		recursive(0);
		System.out.println(answer);
	}

private static void recursive(int k) {
	// basis part
	// 다 골랐어요
	if(k==sel.length) {
		turnOneRound(sel);
		return;
	}
	
	// inductive part
	for(int i=0;i<K;i++){
		if(v[i]==false) {
			v[i] = true;
			sel[k]=i;
			recursive(k+1);
			v[i] = false;
		}
	}
}

static void turnOneRound(int[] sel) {
	String[][] map = Arrays.copyOf(mapOriginal, mapOriginal.length);
	
	for(int j = 0; j < sel.length; j++) {
		System.out.print(sel[j]);
	}
	System.out.println();
	System.out.println();
	
	for(int j = 0; j < sel.length; j++) {
		int R = operation[sel[j]][0];
		int C = operation[sel[j]][1];
		int S = operation[sel[j]][2];
		for (int s = S; s > 0; s--)                    
			turnOneLine(map, R, C, s);
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < N; i++) {
			for (int j1 = 0; j1 < M; j1++) {
				sb.append(map[i][j1]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);	
		
	}
	
	

	for (int i = 0; i < N; i++) {
		int val = 0;
		for (int j = 0; j < M; j++) {
			val += Integer.parseInt(map[i][j]);
		}
		System.out.println(val + " val");
		answer = Math.min(answer, val);
	}
}

	static void turnOneLine(String[][] map, int R, int C, int S) {
		int smallR = R - S;
		int largeR = R + S;
		int smallC = C - S;
		int largeC = C + S;
		String[] upString = map[smallR].clone();
		for (int r = smallR; r < largeR; r++) {
			map[r][smallC] = map[r + 1][smallC];
		}
		for (int c = smallC; c < largeC; c++) {
			map[largeR][c] = map[largeR][c + 1];
		}
		for (int r = largeR; r > smallR; r--) {
			map[r][largeC] = map[r - 1][largeC];
		}
		for (int c = largeC; c > smallC; c--) {
			map[smallR][c] = upString[c - 1];
		}
		
	}
}

//StringBuilder sb = new StringBuilder();
//sb.append("\n");
//for (int i = 0; i < N; i++) {
//	for (int j = 0; j < M; j++) {
//		sb.append(map[i][j]);
//		sb.append(" ");
//	}
//	sb.append("\n");
//}
//System.out.println(sb);
