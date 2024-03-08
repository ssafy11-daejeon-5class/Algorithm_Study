package study._240305.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 혁진이의프로그래밍검증 {

	static int T, R, C;
	static String answer;
	static char[][] maps;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			maps = new char[R][C];

			for (int i = 0; i < R; i++) {
				String temp = br.readLine();
				for (int j = 0; j < C; j++) {
					maps[i][j] = temp.charAt(j);
				}
			}

			print();
			answer = "NO";
//			recur();
			System.out.printf("#%d %s\n", t, answer);
		}
	}

	static int[] di = {0, 1, 0, -1}; 
	static int[] dj = {1, 0, -1, 0};
	static 

//	private static void recur() {
//		Queue<int[]> q = new ArrayDeque<>();
//		boolean[][][][] v = new boolean[R][C][4][16];
//		q.offer(new int[]{0, 0, 0, 0});
//
//		while(!q.isEmpty()){
//			int[] cur = q.poll();
//
//			if(v[cur[0]][cur[1]][cur[2]][cur[3]]){
//				continue;
//			}
//			v[cur[0]][cur[1]][cur[2]][cur[3]] = true;
//			int[] next = new int[4];
//			next[2] = cur[2]; 
//
//			if(maps[cur[0]][cur[1]] == '<'){
//				next[3] = 2;				
//			} else if(maps[cur[0]][cur[1]] == '>'){
//				next[3] = 0;
//			} else if(maps[cur[0]][cur[1]] == '^'){
//				next[3] = 3;
//			} else if(maps[cur[0]][cur[1]] == 'v'){
//				next[3] = 1;
//			} else if(maps[cur[0]][cur[1]] == '_'){
//				next[3] = cur[2]==0?0:2;
//			} else if(maps[cur[0]][cur[1]] == '|'){
//				next[3] = cur[2]==0?1:3;
//			} else if(maps[cur[0]][cur[1]] == '?'){
//				
//			} else if(maps[cur[0]][cur[1]] == '@'){
//				answer = "YES";
//				break;
//			} else if(maps[cur[0]][cur[1]] == '+'){
//				next[2] = cur[2]==15?0:cur[2]+1;
//			} else if(maps[cur[0]][cur[1]] == '-'){
//				next[2] = cur[2]==0?15:cur[2]-1;
//			} else {
//				next[2] = Integer.parseInt(maps[cur[0]][cur[1]] +"");
//			}
//
//			next[0] = cur[0] + di[next[3]];
//			next[1] = cur[1] + dj[next[3]];
//			if(next[0] == -1){
//				next[0] = R - 1;
//			}
//			if(next[0] == R){
//				next[0] = 0;
//			}
//			if(next[1] == -1){
//				next[1] = C - 1;
//			}
//			if(next[1] == C){
//				next[1] = 0;
//			}
//			q.offer(next);
//		}
//		return;
//	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
