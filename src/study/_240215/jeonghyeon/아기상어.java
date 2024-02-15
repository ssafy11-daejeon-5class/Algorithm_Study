package study._240215.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// BOJ 16236
public class 아기상어 {
	
	/*
	 * 자기보다 작은 물고기만 먹을 수 있음
	 * 자기보다 작거나 같은 물고기만 지나가기 가능
	 * 먹을 수 있는 물고기 한마리면 거기로
	 * 두마리 이상이면 맨 위, 그 중에서 맨 왼쪽 물고기 냠
	 * 
	 * 
	 */
	
	
	
	
	
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int sharkSize = 2;
	static int eatCnt = 0;

	static int[] dr = new int[] {-1, 0, 0, 1};
	static int[] dc = new int[] {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int startR = -1;
		int startC = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					startR = i;
					startC = j;
				}
			}
			
		}
		
		int time = bfs(startR, startC);
		System.out.println(time);
		
		
	}
	
	
	static int bfs(int R, int C) {
		visited = new boolean[N][N];
		visited[R][C] = true;
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(R, C, 0));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				int nCnt = point.cnt + 1;
				
				if(notInArea(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] > sharkSize) continue;
//				if(i == 3) {
//					if(!notInArea(nr, nc+1) && visited[nr][nc+1] == true) continue;
//					else if(!notInArea(nr, nc-1) && visited[nr][nc-1] == true) continue;
//				}


				System.out.println("npoint : " + nr + " " + nc + " " + nCnt + " sharkSize:" + sharkSize+ " dist:" + nCnt);
				
				if(map[nr][nc] == 0 || map[nr][nc] == sharkSize) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc, nCnt));
				}
				else if(map[nr][nc] < sharkSize) {
					eatCnt++;
					map[nr][nc] = 0;
//
//					System.out.println("npoint : " + nr + " " + nc + " " + nCnt + " sharkSize:" + sharkSize+ " dist:" + nCnt);
					
					if(eatCnt == sharkSize) {
						sharkSize++;
						eatCnt = 0;
					}

					return nCnt + bfs(nr, nc);
				}
				
				
			}
		}
		
		return 0;
		
	}
	
	static boolean notInArea(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= N) {
			return true;
		}
		return false;
	}
}

class Point{
	public int r, c, cnt;
	
	public Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}


/*
*
* 00 01 02 03
* 10 11 12 13
* 20 21 22 23
* 30 31 32 33
*
*/

//5
//0 0 0 0 0
//0 0 0 0 0
//0 0 9 0 1 
//0 1 0 0 0 
//0 0 0 0 0