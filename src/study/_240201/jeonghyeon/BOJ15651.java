package study._240201.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		visited = new boolean[N];
		
		recursive(0);
		System.out.println(sb);
		}
		
		private static void recursive(int k) {
			// basis part
			// 다 골랐어요
			if (k == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}
			// inductive part
			for(int i = 0; i<visited.length; i++){
				sel[k] = i+1;
				recursive(k + 1);
			}
		}
}