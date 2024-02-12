package hw._240208.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974 {
	static int R;
	static int C;
	static int answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		L: for (int t = 1; t <= T; t++) {
			
			answer = 1;
			int[][] map = new int[9][9];
			for(int i = 0; i < 9; i++) {
				if(answer == 0) {
					br.readLine();
					if(i == 8) {
						System.out.println("#" + t + " 0");
						continue L;
					}
					else 
						continue; // 입력은 받도록 수정
				}
				
				st = new StringTokenizer(br.readLine());
				visited = new boolean[9];
				for(int k = 0; k < 9; k++) {
					int num = Integer.parseInt(st.nextToken()) - 1;
					if(visited[num]) {
						answer = 0;	
						break;
					}
					map[i][k] = num;
					visited[num] = true;
				}	
			}

			for(int i = 0; i < 9; i++) {
				visited = new boolean[9];
				for(int k = 0; k < 9; k++) {
					int num = map[k][i];
					if(visited[num]) {
						System.out.println("#" + t + " 0");
						continue L;
					}
					visited[num] = true;
				}
			
			}
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					visited = new boolean[9];
					for(int k = 0; k < 3; k++) {
						for(int l = 0; l < 3; l++) {
							int num = map[i*3+k][j*3+l];
							if(visited[num]) {
								System.out.println("#" + t + " 0");
								continue L;
							}
							visited[num] = true;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
