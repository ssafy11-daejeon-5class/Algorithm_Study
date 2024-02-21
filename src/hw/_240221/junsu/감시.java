package hw._240221.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 { // BOJ_15683

	static int N, M, cnt, answer = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[][] maps;
	static List<int[]> cctvs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] != 0 && maps[i][j] != 6) {
					cctvs.add(new int[] { i, j });
				}
			}
		}
		cnt = cctvs.size();
		recursive(0);
		System.out.println(answer);
	}

	private static void recursive(int depth) { //
		if (depth == cnt) {
			int temp = countZero();
			answer = Math.min(answer, temp);
			return;
		}
		int i = cctvs.get(depth)[0];
		int j = cctvs.get(depth)[1];
		switch (maps[i][j]) {
		case 1:
			for (int k = 0; k < 4; k++) {
				fillOne(k, i, j, -1);
				recursive(depth + 1);
				fillOne(k, i, j, 1);
			}
			break;
		case 2:
			for (int k = 0; k < 2; k++) {
				fillTwo(k, i, j, -1);
				recursive(depth + 1);
				fillTwo(k, i, j, 1);
			}
			break;
		case 3:
			for (int k = 0; k < 4; k++) {
				fillThree(k, i, j, -1);
				recursive(depth + 1);
				fillThree(k, i, j, 1);
			}
			break;
		case 4:
			for (int k = 0; k < 4; k++) {
				fillFour(k, i, j, -1);
				recursive(depth + 1);
				fillFour(k, i, j, 1);
			}
			break;
		case 5:
			fillFive(i, j, -1);
			recursive(depth + 1);
			fillFive(i, j, 1);
			break;
		}
	}

	private static void fillFour(int dir, int i, int j, int num) {
		// TODO Auto-generated method stub
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, -1, 0, 1};
		for (int l = 0; l < 3; l++) {
			for (int k = 1; k < 8; k++) {
				int ni = i + di[(dir+l)%4] * k;
				int nj = j + dj[(dir+l)%4] * k;
				if(ni>= 0 && ni < N && nj >= 0 && nj < M) { // 일단 범위 안일때
					if(maps[ni][nj] == 6) break; //벽이면 냅두기
					else if(maps[ni][nj] <= 0) maps[ni][nj] = maps[ni][nj] + num; // 일반지대였을때는 num을 더해준다. 돌이킬 경우가 있어서 num으로 일반화하였음.
					else continue; // cctv 있는 곳이면 그냥 통과
				} else {
					break;
				}
			}
		}
	}

	private static void fillThree(int dir, int i, int j, int num) {
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, -1, 0, 1};
		for (int l = 0; l < 2; l++) {
			for (int k = 1; k < 8; k++) {
				int ni = i + di[(dir+l)%4] * k;
				int nj = j + dj[(dir+l)%4] * k;
				if(ni>= 0 && ni < N && nj >= 0 && nj < M) { // 일단 범위 안일때
					if(maps[ni][nj] == 6) break; //벽이면 냅두기
					else if(maps[ni][nj] <= 0) maps[ni][nj] = maps[ni][nj] + num; // 일반지대였을때는 num을 더해준다. 돌이킬 경우가 있어서 num으로 일반화하였음.
					else continue; // cctv 있는 곳이면 그냥 통과
				} else {
					break;
				}
			}
		}
	}

	private static void fillTwo(int dir, int i, int j, int num) {
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, -1, 0, 1};
		for (int l = 0; l < 2; l++) {
			for (int k = 1; k < 8; k++) {
				int ni = i + di[dir+l*2] * k;
				int nj = j + dj[dir+l*2] * k;
				if(ni>= 0 && ni < N && nj >= 0 && nj < M) { // 일단 범위 안일때
					if(maps[ni][nj] == 6) break; //벽이면 냅두기
					else if(maps[ni][nj] <= 0) maps[ni][nj] = maps[ni][nj] + num; // 일반지대였을때는 num을 더해준다. 돌이킬 경우가 있어서 num으로 일반화하였음.
					else continue; // cctv 있는 곳이면 그냥 통과
				} else {
					break;
				}
			}
		}
		
	}

	private static void fillOne(int dir, int i, int j, int num) { // 방향, row, column, 더해줄값
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, -1, 1};
		for (int k = 1; k < 8; k++) {
			int ni = i + di[dir] * k;
			int nj = j + dj[dir] * k;
			if(ni>= 0 && ni < N && nj >= 0 && nj < M) { // 일단 범위 안일때
				if(maps[ni][nj] == 6) break; //벽이면 냅두기
				else if(maps[ni][nj] <= 0) maps[ni][nj] = maps[ni][nj] + num; // 일반지대였을때는 num을 더해준다. 돌이킬 경우가 있어서 num으로 일반화하였음.
				else continue; // cctv 있는 곳이면 그냥 통과
			} else {
				break;
			}
		}
	}

	private static void fillFive(int i, int j, int num) {
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, -1, 1};
		for (int l = 0; l < 4; l++) {
			for (int k = 1; k < 8; k++) {
				int ni = i + di[l] * k;
				int nj = j + dj[l] * k;
				if(ni>= 0 && ni < N && nj >= 0 && nj < M) { // 일단 범위 안일때
					if(maps[ni][nj] == 6) break; //벽이면 냅두기
					else if(maps[ni][nj] <= 0) maps[ni][nj] = maps[ni][nj] + num; // 일반지대였을때는 num을 더해준다. 돌이킬 경우가 있어서 num으로 일반화하였음.
					else continue; // cctv 있는 곳이면 그냥 통과
				} else {
					break;
				}
			}
		}
	}

	private static int countZero() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
