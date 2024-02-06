package hw._240205.jeonghyeon;

import java.util.Scanner;

public class AppleEating {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int[][] map = new int[N][N];

			// 지도 정보 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 총 회전 횟수 저장
			int totalTurn = 0;
			int myRow = 0, myCol = 0;
			int direction = 0;

			// 다음 목적지를 찾아 작업을 수행
			for (int n = 1; n <= N * N; n++) {
				int nextRow = -1, nextCol = -1;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == n) {
							nextRow = i;
							nextCol = j;
							// System.out.println("" + n + "번째 : " + i + " " + j);
							break;
						}
					}
					if (nextRow != -1)
						break;
				}
				if (nextRow == -1)
					break;

				int routeRow = nextRow - myRow;
				int routeCol = nextCol - myCol;
				int route = -1;

				if (routeRow > 0 && routeCol > 0)
					route = 1;
				else if (routeRow > 0 && routeCol < 0)
					route = 2;
				else if (routeRow < 0 && routeCol < 0)
					route = 3;
				else if (routeRow < 0 && routeCol > 0)
					route = 4;

				int nowTurn = (route - direction + 3) % 4 + 1;
				if (nowTurn == 4)
					nowTurn--;
				totalTurn += nowTurn;

				direction = (direction + nowTurn) % 4;
				// System.out.println("" + n + "번째 회전수 합 : " + totalTurn + " route방향은 " + route
				// + " direction방향은 " + direction);
				myRow = nextRow;
				myCol = nextCol;

				/*
				 * 방향 오른쪽, 넥스트 오른쪽 아래면 direction 0 route 1 => 회전 1 방향 오른쪽, 넥스트 왼쪽 아래면 direction
				 * 0, route 2 => 회전 2 방향 오른쪽, 넥스트 왼쪽 위면 direction 0, route 3 => 회전 3 방향 오른쪽, 넥스트
				 * 오른쪽 위면 direction 0, route 4 => 회전 4
				 * 
				 * 방향 아래, 넥스트 왼쪽 아래면 direction 1, route 2 => 회전 1 방향 아래, 넥스트 오른쪽 아래면 direction
				 * 1, route 1 => 회전 4
				 */

			}

			System.out.println("#" + t + " " + totalTurn);

		}
	}
}
