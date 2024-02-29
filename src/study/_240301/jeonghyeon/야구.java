package study._240301.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 야구 {
	static int N;
	static int[] players;
	static int[] nowInning;
	static int nowBatter = -1;
	static int inningAnswer = 0;
	static int totalAnswer = 0;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			getInput();
			combination(0);
			totalAnswer += inningAnswer;
		}
		System.out.println(totalAnswer);
		
	}

	private static void combination(int idx) {
		if(idx == 9) {
			simul();
			return;
		}
		if(idx == 3) {
			combination(4);
			return;
		}
		
		
		for(int i = 0; i < 5; i++) {
			if(players[i] <= 0) 
				continue;
			players[i]--;
			nowInning[idx] = i;
			combination(idx+1);
			players[i]++;
			nowInning[idx] = -1;
			
		}
	}

	private static void simul() {
//		System.out.println();
//		for(int i = 0; i < 9; i++)
//			System.out.print(nowInning[i] + " ");
//		System.out.println();
		
		int outCnt = 0;
		int[] ru = new int[5]; // 타석, 1~3루, 도착홈
		Arrays.fill(ru, 0);
		ru[0] = 1;
		
		while(outCnt < 3) {
			nowBatter = (nowBatter+1) % 9;
			int nowBatting = nowInning[nowBatter];
			for(int i = 3; i >= 0; i--) {
				int nextRu = Math.min(i + nowBatting, 4);
				if(nextRu == 4)
					ru[4] += ru[i];
				else
					ru[nextRu] = ru[i];
			}
			if(nowBatting == 0) outCnt++;
		}
		
		inningAnswer = Math.max(inningAnswer, ru[4]);
	}

	private static void getInput() throws Exception {		
		players = new int[5];		
		nowInning = new int[9];
		Arrays.fill(nowInning, -1);
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 9; j++) {
			int batterType = Integer.parseInt(st.nextToken());
			if(j == 0)
				nowInning[3] = batterType;
			else {
				players[batterType]++; 
			}
		}
		
		inningAnswer = 0;
		

//		System.out.println();
//		for(int i = 0; i < 5; i++)
//			System.out.print(players[i] + " ");
//		System.out.println();
//		
//		simul();
		
	}
}
