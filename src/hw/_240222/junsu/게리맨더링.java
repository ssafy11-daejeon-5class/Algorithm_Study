package hw._240222.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {
	/*
	 * 우선 조합을 먼저 만든다.
	 * 
	 */
	
	static int N, answer;
	static int[] pops;
	static List<int []> maps;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pops = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pops[i] = Integer.parseInt(st.nextToken());
		}
		
		maps = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int[] arr = new int[temp];
			for (int j = 0; j < temp; j++) {
				arr[j] = Integer.parseInt(st.nextToken())-1;
			}
			maps.add(arr);
		}
		answer = Integer.MAX_VALUE;
		for (int i = N-1; i >= (N+1)/2; i--) {
			sel = new int[i];
			makeCombi(0, 0, i);
		}
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);	
	}

	static int[] sel;
	private static void makeCombi(int depth, int idx, int target) {
		if(idx == target) { // 조합 발견
			checkUnion(sel);
			return;
		} if (depth == N) {
			return;
		}
		sel[idx] = depth;
		makeCombi(depth+1, idx + 1, target);
		makeCombi(depth+1, idx, target);
	}
	
	private static void checkUnion(int[] sel2) { //
		int[] another  = new int[N-sel.length];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < sel2.length; j++) {
				if(i == sel2[j]) {
					flag = true;
					break;
				}
			}
			if(flag) continue;
			else another[idx++] = i;
		}
		if(check(sel2) && check(another)) {
			int diff = count(sel2) - count(another);
//			System.out.println(Arrays.toString(sel2) + " " + Arrays.toString(another) + " " + diff);
			answer = Math.min(answer, Math.abs(diff));
		}
	}

	private static int count(int[] arr) {
		int res = 0;
		for (int i : arr) {
			res += pops[i];
		}
		return res;
	}

	private static boolean check(int[] arr) { // 해당 어레이를 기준으로 하나의 트리를 만들어낼 수 있는지
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N];

		q.offer(arr[0]);
		v[arr[0]] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < maps.get(cur).length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[j] == maps.get(cur)[i] && !v[maps.get(cur)[i]]) {
						q.offer(maps.get(cur)[i]);
						v[maps.get(cur)[i]] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!v[arr[i]]) return false;
		}
		return true;
	}
	
}
