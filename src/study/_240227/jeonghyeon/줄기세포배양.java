package study._240227.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static int T, R, C, K;
	static int mapR, mapC;
	static int[][] cellMap, statusMap; // input에 설명 있음
	static boolean[][] isExist;
	static List<NewCell> newCellList;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			getInput();
			for (int k = 1; k <= K; k++) {
				spread(k);
			}
			putAnswer(t);
		}
		System.out.println(sb);
	}

	private static void getInput() throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		mapR = R + K; // 맵의 크기
		mapC = C + K;
		cellMap = new int[mapR][mapC]; // 세포의 분포와 생명력을 저장
		statusMap = new int[mapR][mapC]; // 세포의 활성화 상태를 저장
		isExist = new boolean[mapR][mapC]; // 세포의 존재 여부를 저장

		for (int i = (mapR - R) / 2; i < (mapR + R) / 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = (mapC - C) / 2; j < (mapC + C) / 2; j++) {
				cellMap[i][j] = statusMap[i][j] = Integer.parseInt(st.nextToken());
				if (cellMap[i][j] != 0)
					isExist[i][j] = true;
			}
		}
	}

	private static void spread(int time) {
		newCellList = new ArrayList<>();
		for (int r = (mapR - R - time) / 2; r < (mapR + R + time) / 2; r++) {
			for (int c = (mapC - C - time) / 2; c < (mapC + C + time) / 2; c++) {
				if (isTurnToBeActivated(r, c)) { // 셀이 살아있고 활성화될 차례면
					addNewCellCandidates(r, c); // 사방칸들중 빈 곳의 좌표와 생명력을 리스트에 담아둠
				}
			}
		}

		for (NewCell newCell : newCellList) { // 기존 맵 업데이트, 같은 좌표 여러개면 생명력 큰 걸로 담도록 함
			isExist[newCell.r][newCell.c] = true;
			cellMap[newCell.r][newCell.c] = Math.max(cellMap[newCell.r][newCell.c], newCell.power);
			statusMap[newCell.r][newCell.c] = Math.max(statusMap[newCell.r][newCell.c], newCell.power);
		}

	}

	private static boolean isTurnToBeActivated(int r, int c) {
		if (statusMap[r][c] == -cellMap[r][c])
			return false;
		if (isExist[r][c] && --statusMap[r][c] == -1) {
			return true;
		}
		return false;
	}

	private static void addNewCellCandidates(int r, int c) {
		int[] nr = new int[] { r, r + 1, r, r - 1 };
		int[] nc = new int[] { c + 1, c, c - 1, c };

		for (int i = 0; i < 4; i++) {
			if (!isExist[nr[i]][nc[i]]) {
				newCellList.add(new NewCell(nr[i], nc[i], cellMap[r][c]));
			}
		}
	}

	private static void putAnswer(int i) {
		int answer = 0;
		for (int r = 0; r < mapR; r++) {
			for (int c = 0; c < mapC; c++) {
				if (isExist[r][c] && statusMap[r][c] > -cellMap[r][c]) {
					answer++;
				}
			}
		}
		sb.append("#" + i + " " + answer + "\n");
	}

	static class NewCell {
		int r, c, power;

		public NewCell(int r, int c, int power) {
			super();
			this.r = r;
			this.c = c;
			this.power = power;
		}

	}
}