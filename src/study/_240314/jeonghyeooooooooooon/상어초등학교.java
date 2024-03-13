package study._240314.jeonghyeooooooooooon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 상어초등학교 {
	static int N;
	static int studentCnt;
	static int[][] map; // 학생들 입장시킬 맵
	static int[] order; // 학생들 입장 순서
	static Student[] students; // 학생들 목록 (번호순)
	static int[] dr = new int[] {0, 1, 0, -1};
	static int[] dc = new int[] {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		input();
		for(int i = 0; i < studentCnt; i++)
			placeStudent(order[i]);
		printAnswer();
		
	}
	
	private static void printAnswer() {
		int answer = 0;
		int nr, nc, nearStudentIdx, myIdx;

		
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				
				int happy = 0;
				
				for(int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) 
						continue;
					nearStudentIdx = map[nr][nc];
					myIdx = map[r][c];
					for(int j = 0; j < 4; j++) {
						if(students[myIdx].favorites[j] == nearStudentIdx) {
							happy++;
							break;
						}
					}
				}
				
				if(happy == 1) 
					answer += 1;
				else if(happy == 2) 
					answer += 10;
				else if(happy == 3)
					answer += 100;
				else if(happy == 4)
					answer += 1000;
				
			}
		}
		
		System.out.println(answer);
	}

	static void placeStudent(int idx) {
		int nr, nc;
		int favoriteCnt, emptyCnt, nearStudentIdx;
		int maxEmptyCnt = 0;
		int maxFavoriteCnt = 0;
		int maxCntR = -1;
		int maxCntC = -1;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] != -1) 
					continue;
				if(maxCntR == -1) {
					maxCntR = r;
					maxCntC = c;
				}
				
				favoriteCnt = 0;
				emptyCnt = 0;
				for(int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) 
						continue;
					if(map[nr][nc] == -1) {
						emptyCnt++;
						continue;
					}
					nearStudentIdx = map[nr][nc];
					for(int j = 0; j < 4; j++) {
						if(students[idx].favorites[j] == nearStudentIdx) {
							favoriteCnt++;
							break;
						}
					}
				}
				if(favoriteCnt > maxFavoriteCnt 
						|| (favoriteCnt == maxFavoriteCnt && emptyCnt > maxEmptyCnt)) {
					maxFavoriteCnt = favoriteCnt;
					maxEmptyCnt = emptyCnt;
					maxCntR = r;
					maxCntC = c;
				}			
			}
		}
		
		map[maxCntR][maxCntC] = idx;
		
//		System.out.println();
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
	
	}

	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int idx;
		
		N = Integer.parseInt(br.readLine());
		studentCnt = (int)Math.pow(N, 2);
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		students = new Student[studentCnt];
		order = new int[studentCnt];
		for(int i = 0; i < studentCnt; i++) {
			st = new StringTokenizer(br.readLine());
			idx = Integer.parseInt(st.nextToken()) - 1;
			order[i] = idx;
			students[idx] = new Student(idx, 
					Integer.parseInt(st.nextToken()) - 1, 
					Integer.parseInt(st.nextToken()) - 1, 
					Integer.parseInt(st.nextToken()) - 1, 
					Integer.parseInt(st.nextToken()) - 1);
		}
		
	}
	
	static class Student{
		int idx;
		int[] favorites = new int[4];
		
		public Student(int idx, int s1, int s2, int s3, int s4) {
			this.idx = idx;
			this.favorites[0] = s1;
			this.favorites[1] = s2;
			this.favorites[2] = s3;
			this.favorites[3] = s4;
		}
	}
}
