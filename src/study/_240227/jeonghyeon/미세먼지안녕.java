package study._240227.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
	static int R, C, T;
	static int[][] map, newMap;
	static int airCleaner1Y, airCleaner2Y;

	public static void main(String[] args) throws Exception {
		
		getInput();
		
		for(int t = 0; t < T; t++) {
			spread();
			cleaning();
		}
		
		printAnswer();
	}

	private static void getInput() throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		newMap = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			if(map[i][0] == -1) {
				airCleaner2Y = i;
				airCleaner1Y = i-1;
			}
		}
		
	}

	private static void spread() {
		for(int i = 0; i < R; i++) {
			newMap[i] = map[i].clone();
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				int[] nr = new int[] {r, r+1, r, r-1};
				int[] nc = new int[] {c+1, c, c-1, c};
				int dustUnit = map[r][c]/5;
				for(int i = 0; i < 4; i++) {
					if(notInArea(nr[i], nc[i])) continue;
					if(map[nr[i]][nc[i]] == -1) continue;
					newMap[nr[i]][nc[i]] += dustUnit;
					newMap[r][c] -= dustUnit;
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			map[i] = newMap[i].clone();
		}
	}

	private static void cleaning() {
		int r, c;
		
		// 위쪽 한바퀴
		for(r = airCleaner1Y-2; r >= 0; r--){
			map[r+1][0] = map[r][0];
		}
		for(c = 0; c < C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		for(r = 0; r < airCleaner1Y; r++) {
			map[r][C-1] = map[r+1][C-1];			
		}
		for(c = C-2; c > 0; c--) {
			map[airCleaner1Y][c+1] = map[airCleaner1Y][c];
		}
		map[airCleaner1Y][1] = 0;
		
		// 아래쪽 한바퀴		
		for(r = airCleaner2Y + 1; r < R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		
		for(c = 0; c < C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		for(r = R-2; r >= airCleaner2Y; r--) {
			map[r+1][C-1] = map[r][C-1];
		}
		for(c = C-2; c > 0; c--) {
			map[airCleaner2Y][c+1] = map[airCleaner2Y][c];
		}
		map[airCleaner2Y][1] = 0;
		
	}
	
	private static boolean notInArea(int r, int c) {
		if(r < 0 || r >= R || c < 0 || c >= C)
			return true;
		return false;
	}
	
	private static void printAnswer() {
		int answer = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) answer += map[r][c];
			}
		}
		
		System.out.println(answer);
	}
	
	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] >= 0 && map[r][c] < 10)
					sb.append(" ");
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb + "\n");
	}
	
}
