package study._240125.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {
	public static void main(String[] args) throws IOException {

		int w, h, p, q, T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

//		for (int t = 0; t < T; t++) {
//			System.out.print(Math.abs((w - 1 + p + t) % (w * 2) - (w - 1)) + " ");
//			System.out.println(Math.abs((h - 1 + q + t) % (h * 2) - (h - 1)));
//		}

		System.out.print(Math.abs((w - 1 + p + T) % (w * 2) - (w - 1)) + " ");
		System.out.println(Math.abs((h - 1 + q + T) % (h * 2) - (h - 1)));

	}

}

