package hw._240220.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {

    static int[][] maps = new int[10][10];
    static StringTokenizer st;
    static int[] papers = {5, 5, 5, 5, 5};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
    }
    private static void dfs(int r, int c) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
            }
        }
    }
    private static void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
}
