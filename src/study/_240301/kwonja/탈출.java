package study._240301.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {

	static int R, C;
	static char[][] maps;
	static StringTokenizer st;
	static int[] gs;
	static int[] bb;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<int[]> waters;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R][C];
		

		waters = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				maps[i][j] = temp.charAt(j);
				if (maps[i][j] == 'S') {
					gs = new int[2];
					gs[0] = i;
					gs[1] = j;
				} else if (maps[i][j] == 'D') {
					bb = new int[2];
					bb[0] = i;
					bb[1] = j;
				} else if (maps[i][j] == '*') {
					waters.add(new int[] { i, j });
				}
			}
		}
		bfs();

	}
	
	private static void bfs() {
		
		int flag = 0;
		// 고슴도치가 한칸 이동할때마다 물이 한칸씩 퍼지는 것.
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] vWater = new boolean[R][C];
		boolean[][] vGosum = new boolean[R][C];
		
		q.offer(new int[] {gs[0], gs[1], 0});
		vGosum[gs[0]][gs[1]] = true;
		L:
		while(!q.isEmpty()) {
			
			int size = q.size();
			int w_size = waters.size();
			
			// 1초에 퍼져나갈 물일 어떻게 될지에 대해 선처리
			for (int i=0; i<w_size; i++) {
				for (int j = 0; j < 4; j++) {
					int nr = waters.get(i)[0] + dr[j];
					int nc = waters.get(i)[1] + dc[j];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && maps[nr][nc] != 'X' && !vWater[nr][nc] && maps[nr][nc] != 'D') {
						vWater[nr][nc] = true;
						maps[nr][nc] = '*';
						waters.add(new int[] {nr, nc});
					}
				}
				waters.remove(i);
				i--;
				w_size--;
			}
			
			print();
			// 1초에 일어날 일들 일시불로 처리
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				if(maps[cur[0]][cur[1]] == 'D')
				{
					System.out.println(cur[2]);
					flag = 1;
					break L;
				}
				
				for (int j = 0; j < 4; j++) {
					int nr = cur[0] + dr[j];
					int nc = cur[1] + dc[j];
					if(nr >= 0  && nr < R && nc >= 0 && nc < C && !vGosum[nr][nc]) {
						if(maps[nr][nc] == '*' || maps[nr][nc] == 'X') continue;
						q.offer(new int[] {nr, nc, cur[2] + 1});
						vGosum[nr][nc] = true;
					}
				}
			}
		}
		
		
		if(flag == 0) System.out.println("KAKTUS");
	}
	
	private static void print() {
		
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				System.out.print(maps[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	}

}
