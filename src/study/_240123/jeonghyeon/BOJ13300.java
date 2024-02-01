package study._240123.jeonghyeon;

import java.util.Scanner;

public class BOJ13300 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] students = new int[2][6];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				students[i][j] = 0;
			}
		}
		
		for(int n = 0; n < N; n++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			students[gender][grade-1] += 1;
		}
		
		int answer = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				answer += (students[i][j] + K-1)/K;
			}
		}
		System.out.println(answer);
		
	}

}
