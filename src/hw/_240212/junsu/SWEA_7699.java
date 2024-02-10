package hw._240212.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7699 {    // 수지의 수지 맞는 여행

    static class Node{
        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static int R, C, T, answer;
    static StringTokenizer st;
    static String[] randmark;
    static boolean[][] v;
    static String v_Randmark;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1 ; t <= T ; t++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            randmark = new String[R];
            answer = 0;
            v_Randmark = "";
            v = new boolean[R][C];

            // 명물 리스트 입력
            for(int i = 0 ; i < R ; i++){
                randmark[i] = br.readLine();
            }
            v[0][0] = true;
            dfs(0, 0, 1, randmark[0].charAt(0)+"");
            System.out.println("#" + t + " "  + answer);
        }
    }
    private static void dfs(int i, int j, int cnt, String visited) {
        for(int k = 0 ; k < 4; k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if(ni >= 0 && ni < R && nj >= 0 && nj < C && !v[ni][nj]){
                if(visited.contains(randmark[ni].charAt(nj)+"")){
                    // System.out.println(i + " " + j + " " + visited+randmark[ni].charAt(nj));
                    answer = Math.max(answer, cnt);
                } else {
                    v[ni][nj] = true;
                    dfs(ni, nj, cnt + 1, visited + randmark[ni].charAt(nj));
                    v[ni][nj] = false;
                }
            }
        }
    }
    
}
