package ws._240229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야구 {

	static int N, answer;
	static int[][] result;
	static boolean[] v;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		result = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print();
		// 선수들 순열을 먼저 만들어주고 각 순열에 대해서
		v = new boolean[9];
		v[0] = true;
		sel = new int[9];
		permu(0);
		// simul(new int[]{4,5,6,0,1,2,3,7,8});

		System.out.println(answer);
	}

	private static void permu(int depth) {
		if (depth == 9) {
			simul(sel);
			return;
		}
		if (depth == 3) {
			permu(depth + 1);
		} else {
			for (int i = 0; i < 9; i++) {
				if (v[i])
					continue;
				v[i] = true;
				sel[depth] = i;
				permu(depth + 1);
				v[i] = false;
			}
		}
	}

	private static void simul(int[] order) {
		int score = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			
			// 매회마다 베이스, 아웃카운트 초기화, 타자의 순서는 그대로 유지한다.
			int out = 0;
			boolean[] base = new boolean[3];
			
			while (out < 3) {
				// System.out.println(Arrays.toString(base) + " " + out + " " + result[i][order[idx]]);
				if (result[i][order[idx]] == 0) { // 아웃일때
					out++;
				} else {
					if(result[i][order[idx]] == 1){ // 1루타
						for (int k = 2; k >= 0; k--) {
                            if (base[k]) {
                                if (k == 2) { // 3루에 있는 선수는 홈으로 들어옴.
                                    score++; // 동시에 점수 획득.
                                    base[k] = false; // 3루는 비어있게 됨.
                                    continue;
                                }
 
                                // 1, 2루에 경우 1루씩 진루하고 원래 있던 자리는 비어있게 됨.
                                base[k] = false;
                                base[k + 1] = true;
                            }
                        }
                        base[0] = true; // 홈에서 1루로 진루.
					} else if(result[i][order[idx]] == 2){
						for (int k = 2; k >= 0; k--) {
                            if (base[k]) {
                                if (k == 2 || k == 1) { // 3루 혹은 2루에 있는 선수는 홈으로 들어옴.
                                    score++; // 동시에 점수 획득.
                                    base[k] = false; // 2루 또는 3루는 비어있게 됨.
                                } else {
									// 1루에 경우 2루씩 진루하고 원래 있던 자리는 비어있게 됨.
									base[k] = false;
									base[k + 2] = true;
								}
                            }
                        }
                        base[1] = true; // 홈에서 2루로 진루.
                        
					} else if (result[i][order[idx]] == 3){
						for (int k = 2; k >= 0; k--) {
                            if (base[k]) { // 홈 제외 모든 선수는 홈으로 들어옴.
                                score++; // 동시에 점수 획득.
                                base[k] = false;
                            }
                        }
                        base[2] = true; // 홈에서 3루로 진루.
                        
					} else if (result[i][order[idx]] == 4) {
						for (int k = 2; k >= 0; k--) {
                            if (base[k]) { // 홈 제외 모든 선수는 홈으로 들어옴.
                                score++; // 동시에 점수 획득.
                                base[k] = false;
                            }
                        }
						score++;	
					}
				}
				idx++;
				idx = idx % 9;
			}
		}
		answer = Math.max(answer, score);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
