package hw._240221.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gamsi {
	static int R, C;
	static char[][] realOriginalMap;
	static char[][][] map;
	static boolean[][] visited;
	static List<Pair> cctvList;
	static int totalSpace;
	static int minSquareSpace = Integer.MAX_VALUE;
	static int tempCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[9][R][C];
		cctvList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[0][i][j] = s.charAt(j * 2);
				if (map[0][i][j] >= '1' && map[0][i][j] <= '5') {
					cctvList.add(new Pair(i, j, map[0][i][j] - 48));
				} else if (map[0][i][j] == '0') {
					totalSpace++;
				}

			}
		}

		recursive(0, 0);
		System.out.println(minSquareSpace);

	}

	private static void recursive(int idx, int totalCctvCnt) {

		if (idx == cctvList.size()) {
			minSquareSpace = Math.min(minSquareSpace, totalSpace - totalCctvCnt);
			return;
		}

		Pair cctv = cctvList.get(idx);
		for (int i = 0; i < 4; i++) {
			if ((cctv.cctvNum == 2 && i >= 2) || (cctv.cctvNum == 5 && i > 0)) // CCTV 중 2번과 5번은 각각 2번, 1번씩만 실행되도록
				continue;

			int cctvCnt = 0;
			copyMapToMap(idx, idx + 1);
			if (cctv.cctvNum == 1) {
				cctvCnt += gamsi(cctv.r, cctv.c, i, idx + 1);
			} else if (cctv.cctvNum == 2) {
				cctvCnt += gamsi(cctv.r, cctv.c, i, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, i + 2, idx + 1);
			} else if (cctv.cctvNum == 3) {
				cctvCnt += gamsi(cctv.r, cctv.c, i, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, (i + 1) % 4, idx + 1);
			} else if (cctv.cctvNum == 4) {
				cctvCnt += gamsi(cctv.r, cctv.c, i, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, (i + 1) % 4, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, (i + 2) % 4, idx + 1);
			} else if (cctv.cctvNum == 5) {
				cctvCnt += gamsi(cctv.r, cctv.c, i, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, (i + 1) % 4, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, (i + 2) % 4, idx + 1);
				cctvCnt += gamsi(cctv.r, cctv.c, (i + 3) % 4, idx + 1);
			}
			recursive(idx + 1, totalCctvCnt + cctvCnt);

			
		}

	}

	private static int gamsi(int r, int c, int direction, int idx) {
		int cctvCnt = 0;
		if (direction == 0) {
			for (int nc = c + 1; nc < C; nc++) {
				if (map[idx][r][nc] == '6')
					break;
				else if (map[idx][r][nc] == '0') {
					map[idx][r][nc] = '#';
					cctvCnt++;
				}
			}
		} else if (direction == 1) {
			for (int nr = r + 1; nr < R; nr++) {
				if (map[idx][nr][c] == '6')
					break;
				else if (map[idx][nr][c] == '0') {
					map[idx][nr][c] = '#';
					cctvCnt++;
				}
			}
		} else if (direction == 2) {
			for (int nc = c - 1; nc >= 0; nc--) {
				if (map[idx][r][nc] == '6')
					break;
				else if (map[idx][r][nc] == '0') {
					map[idx][r][nc] = '#';
					cctvCnt++;
				}
			}
		} else if (direction == 3) {
			for (int nr = r - 1; nr >= 0; nr--) {
				if (map[idx][nr][c] == '6')
					break;
				else if (map[idx][nr][c] == '0') {
					map[idx][nr][c] = '#';
					cctvCnt++;
				}
			}
		}
		return cctvCnt;
	}

	private static void copyMapToMap(int map1, int map2) { // 첫번째 인자를 두번째 인자로 복사
		for (int r = 0; r < R; r++) {
			map[map2][r] = map[map1][r].clone();
		}
	}

	static class Pair {
		int r, c, cctvNum;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
			this.cctvNum = 0;
		}

		public Pair(int r, int c, int cctvNum) {
			this.r = r;
			this.c = c;
			this.cctvNum = cctvNum;
		}

	}
}
