package study._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 { // 다리 만들기
    static int N, count, answer;
    static int[][] maps;
    static StringTokenizer st;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] v;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        
        maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(maps[i][j] == 1){
                    bfs(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(maps[i][j] != 0){
                    bfs2(i,j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs2(int i, int j) {
        v = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[]{i, j, 0});
        int num = maps[i][j];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + di[k];
                int nj = cur[1] + dj[k];
                if(ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]){
                    if(maps[ni][nj] == 0) {
                        q.offer(new int[]{ni, nj, cur[2] + 1});
                        v[ni][nj] = true;
                    }
                    else if(maps[ni][nj] == num) continue;
                    else if(maps[ni][nj] != num) answer = Math.min(answer, cur[2]);
                }
            }
        }

    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        maps[i][j] = count;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + di[k];
                int nj = cur[1] + dj[k];
                if(ni >= 0 && ni < N && nj >= 0 && nj < N && maps[ni][nj] == 1){
                    q.offer(new int[]{ni, nj});
                    maps[ni][nj] = count;
                }
            }
        }
    }
}
