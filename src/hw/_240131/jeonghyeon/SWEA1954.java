package hw._240131.jeonghyeon;

import java.util.Scanner;

public class SWEA1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					snail[i][j] = -1;

			int[] stepY = new int[] {0, 1, 0, -1};
			int[] stepX = new int[] {1, 0, -1, 0};
			int direction = 0;
			int nowX = -1, nowY = 0;
			
			for(int n = 1; n <= N*N; n++) {
				int nextY = nowY + stepY[direction];
				int nextX = nowX + stepX[direction];
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || snail[nextY][nextX] != -1) {
					direction = (direction +1) % 4;
					nextY = nowY + stepY[direction];
					nextX = nowX + stepX[direction];
				}
				snail[nextY][nextX] = n;
				nowY = nextY;
				nowX = nextX; 
			}
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < N; j++) {
					sb.append(snail[i][j]);
					sb.append(" ");
				}
				System.out.println(sb.toString());
			}
		}
	}

}
