package hw._240205.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SWEA1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> codes = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt)
					.collect(Collectors.toList());
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				String operator = st.nextToken();
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				List<Integer> insertedCodes = new ArrayList<>();
				for (int y = 0; y < Y; y++) {
					insertedCodes.add(Integer.parseInt(st.nextToken()));
				}
				codes.addAll(X, insertedCodes);
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				sb.append(codes.get(i) + " ");
			}
			System.out.println("#" + t + " " + sb.toString());
		}
	}

}
