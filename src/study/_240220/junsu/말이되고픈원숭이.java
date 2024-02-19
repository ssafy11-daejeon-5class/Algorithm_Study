package study._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이 {	// 백준 1600

	static StringTokenizer st;
	static int K, W, H, answer;
	static int[][] maps;
	static boolean[][][] v;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[] hi = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hj = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		maps = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		if(H == 1 && W == 1 && maps[0][0] == 0) answer = 0;
		bfs();
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
		
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[H][W][K+1];
		q.offer(new int[] {0, 0, 0, 0}); // row, column, Horse Count, count
		v[0][0][0] = true;
		
		L : while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ni = cur[0] + di[i];
				int nj = cur[1] + dj[i];
				
				if(ni >= 0 && ni < H && nj >= 0 && nj < W && !v[ni][nj][cur[2]] && maps[ni][nj] == 0) {
					if(ni == H - 1 && nj == W -1) {
						answer = cur[3] + 1;
						break L;
					}
					v[ni][nj][cur[2]] = true;
					q.offer(new int[] {ni, nj, cur[2], cur[3] + 1});
				}
			}
			if(cur[2] < K) {				
				for (int i = 0; i < 8; i++) {
					int ni = cur[0] + hi[i];
					int nj = cur[1] + hj[i];
					
					if(ni >= 0 && ni < H && nj >= 0 && nj < W && !v[ni][nj][cur[2] + 1]	&& maps[ni][nj] == 0) {
						if(ni == H - 1 && nj == W -1) {
							answer = cur[3] + 1;
							break L;
						}
						v[ni][nj][cur[2] + 1] = true;
						q.offer(new int[] {ni, nj, cur[2] + 1, cur[3] + 1});
					}
				}
			}
		}
		
		
	}
}
