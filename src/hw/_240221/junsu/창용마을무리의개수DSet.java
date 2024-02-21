package hw._240221.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 창용마을무리의개수DSet {
	
	static int T, N, M, answer;
	static StringTokenizer st;
	static List<Integer> list;
	static int[] set;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());		// 마을사람수
			M = Integer.parseInt(st.nextToken());		// 관계수
			answer = 0;
			
			set = new int[N];
			for (int i = 0; i < set.length; i++) {
				set[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				unionSet(s-1, e-1);
			}
			
			for (int i = 0; i < N; i++) {
				if(set[i] == i) {
					answer++;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void unionSet(int i, int j) {
		// TODO Auto-generated method stub
		int a = find(i);
		int b = find(j);
		if(a != b) {
			set[a] = b;
		}
	}

	private static int find(int i) {
		if(set[i] == i) return i;
		else return set[i] = find(set[i]);
	}

}
