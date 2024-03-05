package study._240227.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄기세포배양 {

	static class Cell{
		int life, makeTime, i, j;
		boolean isActive = true;
		public Cell(int life, int makeTime, int i , int j) {
			this.life = life;
			this.makeTime = makeTime;
			this.i = i;
			this.j = j;
		}
	}
	static int T, N, M, K, answer;
	static Cell[][] maps;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			maps = new Cell[N][M];
//			Queue<Cell> 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					maps[i][j] = new Cell(Integer.parseInt(st.nextToken()), 0, i, j);
				}
			}
//			bfs();
			System.out.println("#" + t + " " + answer);
		}
	}

}
