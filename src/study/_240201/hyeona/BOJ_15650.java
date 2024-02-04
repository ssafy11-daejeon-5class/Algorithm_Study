package algorithm.Algorithm_Study.src.study._240201.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {

    static int N;
    static int M;
    static int[] visited;
    static int[] sel;

    // 조합
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N개 중에 M개 뽑기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];

        dfs(0, 1);
    }

    public static void dfs(int cnt, int index)
    {
        if(cnt == M)
        {
            for(int i=0; i<M; i++)
            {
                System.out.print(sel[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=index; i<=N; i++)
        {
            sel[cnt] = i;
            dfs(cnt+1, i+1);
        }


    }
}
