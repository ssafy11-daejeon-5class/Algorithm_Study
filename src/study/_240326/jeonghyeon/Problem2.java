package study._240326.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2 {
	static int N, T;
	static int[][] map;
	static int[][] robotMap;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		// 2차원 배열 입력받기
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 칸별로 T번 이동으로 얻을 수 있는 이득의 최대치를 구하고 2차원 배열로 저장해둠
		robotMap = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				robotMap[r][c] = bestBenefitsByTimeSlip(r, c);
			}
		}

		// 각 칸 별 얻을 수 있는 최대 이득을 저장
		// 세번째 인덱스는 시간 역행 기능을 썼는지 표시. 0이면 안쓴거, 1이면 쓴거
		dp = new int[N][N][2];

		// 시작점 초기화
		dp[0][0][0] = map[0][0];
		dp[0][0][1] = map[0][0] + robotMap[0][0];

		// 맨 윗 줄, 맨 왼쪽 줄 계산
		for (int i = 1; i < N; i++) {
			dp[i][0][0] = dp[i - 1][0][0] + map[i][0];
			dp[i][0][1] = Math.max(dp[i - 1][0][1] + map[i][0], dp[i][0][0] + robotMap[i][0]);

			dp[0][i][0] = dp[0][i - 1][0] + map[0][i];
			dp[0][i][1] = Math.max(dp[0][i - 1][1] + map[0][i], dp[0][i][0] + robotMap[0][i]);
		}

		// 나머지 부분 계산
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < N; c++) {
				dp[r][c][0] = Math.max(dp[r-1][c][0], dp[r][c-1][0]) + map[r][c];

				if(robotMap[r][c] == Integer.MIN_VALUE)
					dp[r][c][1] = Math.max(dp[r-1][c][1], dp[r][c-1][1]) + map[r][c];
				else
					dp[r][c][1] = Math.max(dp[r][c][0] + robotMap[r][c], Math.max(dp[r-1][c][1], dp[r][c-1][1]) + map[r][c]);
			}
		}

		// 정답 출력, 종료
		int answer = Math.max(dp[N-1][N-1][0], dp[N-1][N-1][1]);
		System.out.println(answer);
		return;

	}

	// 특정 칸에서 T번 이동으로 얻을 수 있는 이득의 최대치를 구하는 함수
	private static int bestBenefitsByTimeSlip(int r, int c) {

		// T칸만큼 이동할 수 없는 경우 처리
		if (r + c + T > (N - 1) * 2)
			return Integer.MIN_VALUE;

		// bfs 돌림 T번만큼
		Queue<Kan> queue = new ArrayDeque<>();
		queue.offer(new Kan(r, c, map[r][c]));
		for (int t = 0; t < T; t++) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Kan kan = queue.poll();
				if (kan.r + 1 < N)
					queue.offer(new Kan(kan.r + 1, kan.c, kan.value + map[kan.r + 1][kan.c]));
				if (kan.c + 1 < N)
					queue.offer(new Kan(kan.r, kan.c + 1, kan.value + map[kan.r][kan.c + 1]));
			}
		}

		// T번 이동으로 얻을 수 있는 이득들 중 최대치를 구해서 리턴
		int bestBenefit = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			bestBenefit = Math.max(bestBenefit, queue.poll().value);
		}
		return bestBenefit;
	}

	// 칸
	static class Kan {
		int r, c, value;

		public Kan(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}

}
