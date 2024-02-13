package study._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 { // 치킨 배달

	/*
	 * 실제 지도를 저장하지 않고 좌표를 활용하여 계산.
	 * 치킨집 좌표를 저장한 리스트를 활용하여 조합을 통하여 그리디하게 처리
	 * 그리디하게 처리해도 괜찮은 이유는 만약 M개보다 작은 치킨집을 선택하였을때 치킨 거리가 최솟값이 된다면 M개를 골랐을때도 동일한 치킨 거리를 얻을 수 있음
	 * Grid 알고리즘을 활용하여 치킨집 좌표를 조합으로 추출 후 치킨 거리 계산. 끗.
	 */
	static class Node {
		int i;
		int j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static List<Node> chickens;
	static List<Node> homes;
	static int N, M, temp, answer;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		homes = new ArrayList<>();
		chickens = new ArrayList<>();

		// 지도를 입력받으며 집과 치킨집의 좌표를 리스트에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					homes.add(new Node(i, j));
				} else if (temp == 2) {
					chickens.add(new Node(i, j));
				}
			}
		}
		sel = new int[M];
		chickenDist(0, 0);
		System.out.println(answer);
	}

	private static void chickenDist(int depth, int k) {
		if (k == M) {
			// 치킨집 조합 찾음. 비즈니스 로직 작성
			int sum = 0;
			for (Node node : homes) {
				int distance = Integer.MAX_VALUE;
				for (int i : sel) {
					Node chicken = chickens.get(i);
					distance = Math.min(distance, Math.abs(node.i-chicken.i) + Math.abs(node.j-chicken.j));
				}
				sum += distance;
			}
			answer = Math.min(answer, sum);
			return;
		}
		if (depth == chickens.size()) {
			return;
		}
		sel[k] = depth;
		chickenDist(depth + 1, k + 1);
		chickenDist(depth + 1, k);
	}

}
