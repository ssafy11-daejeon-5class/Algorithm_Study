package hw._240201.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int row = 0; row < N; row++) {
				st= new StringTokenizer(br.readLine());
				for(int col = 0; col < N; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] killCnt = new int[N-M+1][N-M+1];
			killCnt[0][0] = 0;
			for(int row = 0; row < N-M+1; row++) {
				for(int col = 0; col < N-M+1; col++) {
					if(row == 0 && col == 0) {
						for(int r = 0; r < M; r++) {
							for(int c = 0; c < M; c++) {
								killCnt[0][0] += map[r][c];
							}
						}
					} 
					else if(col == 0) {
						killCnt[row][0] = killCnt[row-1][0];
						for(int c = 0; c < M; c++) {
							killCnt[row][0] += map[row+M-1][c] - map[row-1][c];
						}
					}
					else {
						killCnt[row][col] = killCnt[row][col-1];
						for(int r = 0; r < M; r++) {
							killCnt[row][col] += map[row + r][col+M-1] - map[row + r][col-1];
						}
					}
				}
			}
			
			int maxKillCnt = -1;
			for(int row = 0; row < N-M+1; row++) {
				for(int col = 0; col < N-M+1; col++) {
					maxKillCnt = Math.max(maxKillCnt, killCnt[row][col]);
				}
			}
			
			
			System.out.println("#" + t + " " + maxKillCnt);			
		}
	}
}
