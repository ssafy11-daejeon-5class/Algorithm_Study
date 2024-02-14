package hw._240213.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int gyuWin;
	static int gyuLose;
	static List<Integer> gyu;
	static List<Integer> iny;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			gyu = new ArrayList<>();
			iny = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				gyu.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i <= 18; i++) {
				if (!gyu.contains(i)) {
					iny.add(i);
				}
			}

			visited = new boolean[19];
			gyuWin = 0;
			gyuLose = 0;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 9; i++)
				list.add(0);
			recursive(list, 0);

			System.out.println("#" + t + " " + gyuWin + " " + gyuLose);
		}
	}

	private static void recursive(List<Integer> inyPermutation, int cnt) {
		if (cnt == 9) {
			fight(inyPermutation);
			return;
		}

		for (Integer i : iny) {
			if (!visited[i]) {
				visited[i] = true;
				inyPermutation.set(cnt, i);
				recursive(inyPermutation, cnt + 1);
				visited[i] = false;
			}
		}

	}

	private static void fight(List<Integer> inyPermutation) {

		// System.out.println(inyPermutation);

		int gyuCnt = 0;
		int inyCnt = 0;
		for (int i = 0; i < 9; i++) {
			if (gyu.get(i) > inyPermutation.get(i)) {
				gyuCnt += gyu.get(i) + inyPermutation.get(i);
			} else {
				inyCnt += gyu.get(i) + inyPermutation.get(i);
			}
		}

		// System.out.println("gyu : " + gyuCnt + ", iny : " + inyCnt);

		if (gyuCnt > inyCnt) {
			gyuWin++;
		} else {
			gyuLose++;
		}

	}

}
