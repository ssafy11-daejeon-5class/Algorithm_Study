package study._240301.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	static int N;
	static int[][] map;
	static int[][][] numOfCases; // 가로(0), 세로(2), 대각선(1) 별로 가능한 경우의 수 
	
	public static void main(String[] args) throws Exception {
		
		getInputAndInitializeMap();
		dp();
		printAnswer();
		
	}

	private static void getInputAndInitializeMap() throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		numOfCases = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		for (int i = 0; i < N; i++) {
			if(map[0][i] == 1) break;
			numOfCases[0][i][0] = 1;
		}
		if(map[1][2] != 1 && map[1][1] != 1 && map[0][2] != 1)
			numOfCases[1][2][1] = 1;
		if(numOfCases[1][2][1] == 0)
			return;
		for (int i = 2; i < N; i++) {
			if(map[i][2] == 1) break;
			numOfCases[i][2][2] = 1;	
		}
	}

	private static void dp() {
		for(int sumRC = 4; sumRC  < N*2-1; sumRC++) {
			for(int c = Math.min(N-1, sumRC); c >= 3; c--) {
				int r = sumRC - c;
				if(r < 1 || r >= N)
					continue;
				
				if(map[r][c] == 1) continue; 
				// 왼쪽에서 온 경우
				numOfCases[r][c][0] = numOfCases[r][c-1][0] + numOfCases[r][c-1][1];
				// 오른쪽에서 온 경우	
				numOfCases[r][c][2] = numOfCases[r-1][c][1] + numOfCases[r-1][c][2];
				
				if(map[r][c-1] != 1 && map[r-1][c] != 1) {
					// 대각선에서 온 경우
					numOfCases[r][c][1] = numOfCases[r-1][c-1][0] + numOfCases[r-1][c-1][1] + numOfCases[r-1][c-1][2];
				}
			}
		}
		
	}

	private static void printAnswer() {
		int answer = numOfCases[N-1][N-1][0] + numOfCases[N-1][N-1][1] + numOfCases[N-1][N-1][2];
		System.out.println(answer);
	}
	
	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] >= 0 && map[r][c] < 10)
					sb.append(" ");
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb + "\n");

	}
	
	
	private static void printNumOfCases() {
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(numOfCases[r][c][0] >= 0 && numOfCases[r][c][0] < 10)
					sb.append(" ");
				sb.append(numOfCases[r][c][0] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(numOfCases[r][c][1] >= 0 && numOfCases[r][c][1] < 10)
					sb.append(" ");
				sb.append(numOfCases[r][c][1] + " ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(numOfCases[r][c][2] >= 0 && numOfCases[r][c][2] < 10)
					sb.append(" ");
				sb.append(numOfCases[r][c][2] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb + "\n");
	}

}
