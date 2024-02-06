package hw._240206.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {

	static int N, idx;
	static String content;
	static boolean flag;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1 ; t <= 10 ; t++) {
			N = Integer.parseInt(br.readLine());
			flag = true;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				content = st.nextToken();
				if(content.equals("*") || content.equals("+") || content.equals("/") || content.equals("-")) {
					if(!st.hasMoreTokens()) {
						System.out.println();
						flag= false;
					}
				}
			}
			if(flag) {
				System.out.println("#" + t + " 1");
			} else {
				System.out.println("#" + t + " 0");
			}
		}
	}

}
