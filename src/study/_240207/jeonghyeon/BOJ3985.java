package study._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean[] cakes = new boolean[L];
		int greedyPerson = -1;
		int greedyAmount = -1;
		int maxPerson = -1;
		int maxAmount = -1;

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
		}
	}
}
