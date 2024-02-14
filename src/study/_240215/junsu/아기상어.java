package study._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
    static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static int N;
    static StringTokenizer st;
    static int[][] maps;
    static int size = 2;
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};
    static Point start;
    static boolean[][] v;
    private static Point cur;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j] == 9){
                    start = new Point(i, j);
                }
            }
        }

        while(true){
            bfs(start);
        }

    }
    private static void bfs(Point s ) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(s);
        v = new boolean[N][N];
        v[s.i][s.j] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = cur.i + di[k];
                int nj = cur.j + dj[k];
                if(ni >= 0 && ni < N && nj >= 0 && nj < N){
                    q.offer(new Point(ni, nj));
                }
            }
        }
    }
}
