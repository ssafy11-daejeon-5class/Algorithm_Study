package hw._240229.codingFestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 로봇시뮬레이션 {
	static int A, B, N, M;
	static int[][] map;
	static Robot[] robots;
	static List<String> NWES = new ArrayList<>(Arrays.asList("N", "W", "S", "E"));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		robots = new Robot[N+1];
		map = new int[A][B];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			String d = st.nextToken();
			robots[i] = new Robot(x, y, NWES.indexOf(d));
			map[x][y] = i;
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			int t = Integer.parseInt(st.nextToken());
			
			int result = order(r, c, t);

			if(result == -1) {
				System.out.println("Robot "  + r + " crashes into the wall");
				return;
			}
			else if(result > 0) {
				System.out.println("Robot "  + r + " crashes into robot " + result);
				return;
			}
		}
		System.out.println("OK");
	}
	
	private static int order(int r, String c, int t) {
		
		if(c.equals("L")) robots[r].setDir((robots[r].dir + t)%4);
		else if(c.equals("R")) robots[r].setDir((robots[r].dir + 100 - t)%4);
		else { // F
			int dir = robots[r].dir;
			int res = frontNwall(r, dir, t);
			
			if(res == -2) return -1;
			else if(res > 0) return res;
		}
		
		
		return 0;
	}
	
	public static int frontNwall(int idx, int dir, int turn) {
		int nr = robots[idx].r;
		int nc = robots[idx].c;
		
		if(dir == 0) {	// 북
			for(int i=nr-1 ; i>nr-1-turn ; i--) {
				if(i<0) return -2;	// 벽에
				if(map[i][nc] > 0) return map[i][nc];	// 로봇에
				
				map[i+1][nc] = 0;
				map[i][nc] = idx;
			}
		} else if(dir ==1) { // 서
			for(int i=nc-1 ; i>nc-1-turn ; i--) {
				if(i<0) return -2;
				if(map[nr][i] > 0 ) return map[nr][i];
				
				map[nr][i+1] = 0;
				map[nr][i] = idx;
			}
			
		}else if(dir ==2) { // 남
			
			for(int i=nr+1 ; i< nr+1+turn ; i++) {
				if(i>=A) return -2;
				if(map[i][nc]> 0) return map[i][nc];
				
				map[i-1][nc] = 0;
				map[i][nc] = idx;
			}
		} else if(dir ==3) { // 동
			
			for(int i=nc+1 ; i<nc+1+turn ; i++) {
				if(i>=B) return -2;
				if(map[nr][i]> 0) return map[nr][i];
				
				map[nr][i-1] = 0;
				map[nr][i] = idx;
			}
		}
		
		return 0;
	}

	static class Robot{
		int r, c;
		int dir;
		
		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		public void setDir(int dir) {
			this.dir = dir;
		}
		
		
	}
}
