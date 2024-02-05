package hw._240205.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
	
	static int N, K, cnt, idx;
	static Queue<Integer> q;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<Integer>();
		answer = new int[N];
		for(int i = 1 ; i <= N ; i++) {
			q.offer(i);
		}
		josepus();
		System.out.print("<");
		for(int i = 0 ; i < N - 1 ; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.print(answer[N-1]);
		System.out.print(">");
	}

	private static void josepus() {
		// TODO Auto-generated method stub
		cnt = 1;
		idx = 0;
				
		while(!q.isEmpty()) {
			if(cnt % K == 0) {
				answer[idx] = q.poll();
				cnt += 1;
				idx += 1;
			} else {
				q.offer(q.poll());
				cnt += 1;
			}
		}
	}
}
