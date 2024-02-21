package hw._240221.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합 {	//SWEA 3289

	static int T, N, M;
	static StringTokenizer st;
	static int[] set;
	static int[] ranks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.print("#" + t + " ");
			set = new int[N+1];
			ranks = new int[N+1];
			
			//makeSet
			for (int i = 0; i < N+1; i++) {
				set[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(cmd) {
				case "0":
					// 합집합
					unionSet(a,b);
					break;
				case "1":
					// 찾아서 부모가 같은지를 판단한다.
					isSameTree(a,b);
					break;
				}
			}
			System.out.println();
		}
		
	}

	private static void isSameTree(int a, int b) {
		if(find(a) == find(b)) System.out.print(1);
		else System.out.print(0);
	}

	private static void unionSet(int origin, int change) {
		int a = find(origin);
		int b = find(change);
		if(a != b) {
			if(ranks[b] > ranks[a]) {
				set[a] = b;
			} else {
				set[b] = a;
				if(ranks[a] == ranks[b]) {
					ranks[a]++;
				}
			}
		}
	}

	private static int find(int origin) {
		if(set[origin] == origin) return origin;
		else return set[origin] = find(set[origin]);
	}

}
