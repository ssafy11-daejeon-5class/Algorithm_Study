package study._240201.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] sel;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		
		recursive(1, 0);
		System.out.println(sb);
		}
		
		private static void recursive(int nowNum, int nowIdx) {
			// basis part
			if (nowIdx == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}
			// inductive part
			for(int i = nowNum; i<= N ; i++){
				sel[nowIdx] = i;
				recursive(i, nowIdx + 1);
			}
		}
}