package study._240314.jeonghyeooooooooooon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {
	
	static int N, M;
	static int[][] mapOrigin;
	static int[][] mapNext;
	static boolean[][] isThereAVirus;
	static int[][][] mapList;
	static List<Virus> virusList;
	static int virusNum;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		input();
		createMapsForEachVirus();
		combinationVirus(0, 0);
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}
	
	
	private static void combinationVirus(int idx, int k) {
		if(idx >=  virusNum)
			return;
		
		
		if(k == M) {
			int maxTime = Integer.MIN_VALUE;
			int emptyKanCnt = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(maxTime == -1)
						continue;
					if(!isThereAVirus[r][c])
						maxTime = Math.max(mapNext[r][c], maxTime);
					if(maxTime == 0) {
						emptyKanCnt++;
						if (emptyKanCnt > virusNum)
							return;
					}
						
				}
			}
			
			if(maxTime != Integer.MIN_VALUE) {
				answer = Math.min(answer, maxTime);
			}
			
			
			for(int j = 0; j < N; j++) {
				for(int l = 0; l < N; l++) {

					if(isThereAVirus[j][l])
						System.out.print(" 0 ");
					else {
						if(mapNext[j][l] >= 0 && mapNext[j][l] <= 9)
							System.out.print(" ");
						System.out.print(mapNext[j][l] + " ");
					}
				}
				System.out.println();
			}
			System.out.println();
			
			return;
		}
		


		
		int[][] mapTemp = new int[N][N];
		for(int r = 0; r < N; r++) {
			mapTemp[r] = mapNext[r].clone();
		}
		
		for(int i = idx; i < virusNum; i++) {

			for(int r = 0; r < N; r++) {
				mapNext[r] = mapTemp[r].clone();
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					mapNext[r][c] = Math.min(mapNext[r][c], mapList[i][r][c]);
				}
			}

			System.out.println(k + "th idx : " + i);
			combinationVirus(i + 1, k + 1);
		}		
		
		for(int r = 0; r < N; r++) {
			mapNext[r] = mapTemp[r].clone();
		}
		combinationVirus(idx + 1, k);
	}


	private static void createMapsForEachVirus() {
		Kan kan;
		Queue<Kan> kans;
		Virus v;
		int[] dr = new int[] {0, 1, 0, -1};
		int[] dc = new int[] {1, 0, -1, 0};
		int nr, nc;
		
		mapList = new int[virusNum][N][N];
		for(int i = 0; i < virusNum; i++) {
			for(int j = 0; j < N; j++) {
				mapList[i][j] = mapOrigin[j].clone();
			}
		}

		for(int i = 0; i < virusNum; i++) {
			v = virusList.get(i);
			kans = new ArrayDeque<>();
			kans.offer(new Kan(v.r, v.c, 0));
			while(!kans.isEmpty()) {
				kan = kans.poll();
				for(int j = 0; j < 4; j++) {
					nr = kan.r + dr[j];
					nc = kan.c + dc[j];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) 
						continue;
					if(mapList[i][nr][nc] != 0)
						continue;
					if(nr == v.r && nc == v.c)
						continue;
					
					mapList[i][nr][nc] = kan.cnt+1;
					kans.offer(new Kan(nr, nc, kan.cnt+1));
				}
			}
			
//			System.out.println("\nv" + i);
//			for(int j = 0; j < N; j++) {
//				for(int k = 0; k < N; k++) {
//					if(mapList[i][j][k] >= 0 && mapList[i][j][k] <= 9)
//						System.out.print(" ");
//					System.out.print(mapList[i][j][k] + " ");
//				}
//				System.out.println();
//			}
		}
	}
	


	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mapOrigin = new int[N][N];
		mapNext = new int[N][N];
		isThereAVirus = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			Arrays.fill(mapNext[r], Integer.MAX_VALUE);
		}
		virusList = new ArrayList<>();
		int idx = 0;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				mapOrigin[r][c] = Integer.parseInt(st.nextToken());
				if(mapOrigin[r][c] == 2) {
					virusList.add(new Virus(r, c));
					mapOrigin[r][c] = 0;
					isThereAVirus[r][c] = true;
				}
				if(mapOrigin[r][c] == 1)
					mapOrigin[r][c] = -1;
			}
		}

		virusNum = virusList.size();
		visited = new boolean[virusNum];
//		System.out.println("vsize : " + virusList.size() + " " + virusList.get(1).r + " " + virusList.get(1).c);
		
	}

	static class Virus{
		int r, c;
		
		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Kan{
		int r, c, cnt;

		public Kan(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
