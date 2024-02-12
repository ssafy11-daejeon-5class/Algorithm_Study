package hw._240208.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
	static int W, H;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0 && H==0) break;
			map = new char[H][W];
			visited = new boolean[H][W];
			for(int i = 0; i < H; i++) {
				map[i] = br.readLine().replaceAll(" ", "").toCharArray();
			}
			
			int answer = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(!visited[i][j] && map[i][j] == '1') {
						answer++;
						recursive(i, j);
					}
				}
			}
			System.out.println(answer);

			
		}
	}
	
	static void recursive(int r, int c) {
		if(visited[r][c]) {
			return;
		}
		
		visited[r][c] = true;
		for(int i = r-1; i <= r+1; i++) {
			for(int j = c-1; j <= c+1; j++) {
				if(i == r && j == c) 
					continue;
				if(isNotInArea(i, j)) 
					continue;
				if(map[i][j] == '1') {
					recursive(i, j);
				}
				
			}
		}
		
	}
	
	static boolean isNotInArea(int r, int c) {
		if(r >= 0 && r < H && c >= 0 && c < W) 
			return false;
		return true;
	}
}
