package study._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 월드컵 {

	static class Result {
		int win;
		int lose;
		int draw;

		public Result(int win, int draw, int lose) {
			this.win = win;
			this.lose = lose;
			this.draw = draw;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return win + " " + draw + " " + lose;
		}
	}

	static List<int[]> combi;
	static int[] sel;
	static Result[] results;
	static StringTokenizer st;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for (int j = 0; j < 4; j++) {
			st = new StringTokenizer(br.readLine());
			combi = new ArrayList<>();
			flag = false;
			results = new Result[6];
			for (int i = 0; i < 6; i++) {
				results[i] = new Result(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			sel = new int[2];
			combi(0, 0);
			valid(0);
			System.out.print((flag ? 1 : 0) + " ");
		}
	}

	private static void combi(int depth, int idx) {
		if (idx == 2) {
			int[] temp = sel.clone();
			combi.add(temp);
			return;
		}
		if (depth == 6) {
			return;
		}
		sel[idx] = depth;
		combi(depth + 1, idx + 1);
		combi(depth + 1, idx);
	}

	static boolean[] v = new boolean[15];

	private static void valid(int depth) {
		if (depth == 15) {
			boolean check = true;
			for (int i = 0; i < 6; i++) {
				if(results[i].win !=0 || results[i].lose !=0 || results[i].draw !=0) {
					check = false;
					break;
				}
			}
			if(check) {
				flag = true;
			}
			return;
		}
		int team1 = combi.get(depth)[0];
		int team2 = combi.get(depth)[1];
		if (results[team1].win - 1 >= 0 && results[team2].lose - 1 >= 0) {
			results[team1].win--;
			results[team2].lose--;
			valid(depth + 1);
			results[team1].win++;
			results[team2].lose++;
			
		}
		if (results[team1].lose - 1 >= 0 && results[team2].win - 1 >= 0) {
			results[team1].lose--;
			results[team2].win--;
			valid(depth + 1);
			results[team1].lose++;
			results[team2].win++;
		}
		if(results[team1].draw - 1 >=0 && results[team2].draw - 1 >= 0) {
			results[team1].draw--;
			results[team2].draw--;
			valid(depth + 1);
			results[team1].draw++;
			results[team2].draw++;
		}
	}

}
