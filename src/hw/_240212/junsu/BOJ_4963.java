package hw._240212.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 { // 섬의 개수
	
	static class Node{
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int w, h, answer;
	static StringTokenizer st;
	static int[][] maps;
	static int[][] v;	
	static int[] di = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dj = { -1, 1, 0, -1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			st = new StringTokenizer(br.readLine());
			answer = 0;

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}

			maps = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(maps[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void bfs(int i, int j) {
		Queue<Node> q = new ArrayDeque<>();
		maps[i][j] = 0;
		q.offer(new Node(i,j));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int k = 0 ; k < 8 ; k++) {
				int ni = cur.i + di[k];
				int nj = cur.j + dj[k];
				if(ni >= 0 && ni < h && nj >= 0 && nj < w && maps[ni][nj] == 1) {
					maps[ni][nj] = 0;
					q.offer(new Node(ni, nj));
				}
			}
		}
		answer++;
	}

}
