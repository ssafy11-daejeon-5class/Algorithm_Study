package study._240305.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
	static int[][] maps = new int[10][10];
	static int[] papers = {0, 5, 5, 5, 5, 5 };
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(0, 0, 0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}

	private static void recursive(int r, int c, int count) {
		if (r >= 9 && c > 9) {
			answer = Math.min(answer, count);
			return;
        }
        if(answer <= count){
            return;
        }
        if(c > 9){
            recursive(r+1, 0, count);
            return;
        }

        if(maps[r][c] == 1){
            for (int i = 5; i >= 1; i--) {
                if(papers[i] > 0 && valid(r, c, i)){
                    check(r, c, i, 0);
                    papers[i]--;
                    recursive(r, c+i, count+1);
                    papers[i]++;
                    check(r, c, i, 1);
                }
            }
        } else {
            recursive(r, c+1, count);
        }

	}

	private static boolean valid(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
                if(i >= 0 && i < 10 && j >= 0 && j < 10 ){
                    if(maps[i][j] == 0){
                        return false;
                    }
                } else {
                    return false;
                }
			}
		}
		return true;
	}

	private static void check(int r, int c, int size, int tag) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
                if(i>=0 && i < 10 && j >= 0 && j < 10){
                    maps[i][j] = tag;
                }
			}
		}
		return;
	}
}
