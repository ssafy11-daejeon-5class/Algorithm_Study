package study._240201.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
	
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
		
		recursive(0, 0);
		System.out.println(sb);
		}
		
		private static void recursive(int idx, int k) {
			// basis part
			// 다 골랐어요
			if (k == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}
			// inductive part
			for(int i = idx; i<visited.length; i++){
				if (visited[i] == false) {
					visited[i] = true;
					sel[k] = i+1;
					recursive(i+1, k + 1);
					visited[i] = false;
				}
			}
		}
}