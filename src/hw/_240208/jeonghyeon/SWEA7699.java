package hw._240208.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7699 {
	static int R;
	static int C;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			String[] map = new String[R];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine();
			}
			boolean[] visited = new boolean[26];

			answer = 1;
			recursive(map, visited, 0, 0, 1);
			
			

			System.out.println("#" + t + " " + answer);
		}
	}
	
	static void recursive(String[] map, boolean[] visited, int r, int c, int cnt){
		Character newChar = map[r].charAt(c);
		if(visited[(int)newChar - 65]) {
//			System.out.println("answer : " + answer);
			answer = Math.max(answer, cnt - 1);
			return;
		}
		
		
//		System.out.println("visited : " + newChar);
		int[] nextR = { r, r + 1, r, r - 1 };
		int[] nextC = { c + 1, c, c - 1, c };
		for (int i = 0; i < 4; i++) {
			if (isInArea(nextR[i], nextC[i])) {
				visited[(int)newChar - 65] = true;
				recursive(map, visited, nextR[i], nextC[i], cnt+1);
				visited[(int)newChar - 65] = false;
			}
		}
	}
	
	static boolean isInArea(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return false;
		return true;
	}
}
