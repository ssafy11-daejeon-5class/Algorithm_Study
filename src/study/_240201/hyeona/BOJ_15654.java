package algorithm.Algorithm_Study.src.study._240201.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열
public class BOJ_15654 {

    static int N;
    static int M;
    static int[] sel;
    static int[] visited;
    static int[] arr;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new int[N];
        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
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

        for(int i=0; i<N; i++)
        {
            if(visited[i]==0)
            {
                visited[i]=1;
                sel[cnt]=arr[i];
                dfs(cnt+1);
                visited[i]=0;
            }
        }

    }

}
