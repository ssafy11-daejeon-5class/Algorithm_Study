package hw._240202.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> cards = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			cards.add(i);
		}
		int idx;
		for(idx = 0; ; idx++) {
			if(idx % 2 == 1) {
				cards.add(cards.get(idx));
			}
			if(cards.size() == idx + 1) {
				System.out.println(cards.get(idx) + 1);
				return;
			}
		}
	}
}
