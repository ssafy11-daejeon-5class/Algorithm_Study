package study._240319.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기 {
	static int N;
	static int[] weight;
	static int[] defense;
	static int maxCnt = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		defense = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			defense[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0);
		System.out.println(maxCnt);
		
		
	}
	
	public static void combination(int now, int cnt) {
		if(now == N) {
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}

		if(defense[now] <= 0) {
			combination(now + 1, cnt);
			return;
		}
		
		boolean noAbleEgg = true;
		for(int next = 0; next < N; next++) {

			if(now == next || defense[next] <= 0) 
				continue;
			
			noAbleEgg = false;
			int nextCnt = cnt;
			
			defense[now] -= weight[next];
			if(defense[now] <= 0) nextCnt++;
			defense[next] -= weight[now];
			if(defense[next] <= 0) nextCnt++;
			
			combination(now + 1, nextCnt);
			defense[now] += weight[next];
			defense[next] += weight[now];
		}
		
		if(noAbleEgg)
			combination(now + 1, cnt);
	}
	
}
