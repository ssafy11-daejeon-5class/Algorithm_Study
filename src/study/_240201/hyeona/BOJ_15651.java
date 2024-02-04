package algorithm.Algorithm_Study.src.study._240201.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복 순열
public class BOJ_15651 {

    static int N;
    static int M;
    static int[] sel;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[M];

        dfs(0);

        System.out.println(sb);

    }

    public static void dfs(int cnt)
    {
        if(cnt==M)
        {
            for(int i=0; i<M; i++)
            {
                sb.append(sel[i]+" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=1; i<=N; i++)
        {
            sel[cnt]=i;
            dfs(cnt+1);
        }
    }
}
