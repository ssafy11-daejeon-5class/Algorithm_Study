package hw._240212.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733 {    // 치즈 도둑
    static int T, N, answer, count, M;
    static int[][] maps;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] v;
    static class Node{
        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T ; t++){
            N = Integer.parseInt(br.readLine());
            maps = new int[N][N];

            for(int i = 0 ; i < N ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    M = Math.max(M, maps[i][j]);
                }
            }            
            answer = Integer.MIN_VALUE;
            for(int d = 1 ; d <= M ; d++){
                v = new boolean[N][N];
                count = 0;
                for(int i = 0 ; i < N ; i++){
                    for(int j = 0 ; j < N ; j++){
                        if(maps[i][j] > d && !v[i][j]){
                            bfs(i, j, d);
                            count++;
                        }
                    }
                }
                answer = Math.max(answer, count);
            }
            System.out.println("#" + t + " " + answer);
        }
    }
    private static void bfs(int i, int j, int day) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(i, j));
        v[i][j] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int k = 0 ; k < 4 ; k++){
                int ni = cur.i + di[k];
                int nj = cur.j + dj[k];
                if(ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj] && maps[ni][nj] > day){
                    q.offer(new Node(ni, nj));
                    v[ni][nj] = true;
                }
            }
        }
    }
}