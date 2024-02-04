package algorithm.Algorithm_Study.src.hw._240201.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SWEA_2001 {
    static int N,M, ans;
    static int[][] arr;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=1; i<=T; i++)
        {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            M = Integer.parseInt(st.nextToken());
            ans = Integer.MIN_VALUE;
            for(int x=0; x<N; x++)
            {
                st = new StringTokenizer(br.readLine());
                for(int y=0; y<N; y++)
                {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            for(int a=0; a<=N-M; a++)
            {
                for(int b=0; b<=N-M; b++)
                {
                    square(a,b);
                }
            }
            sb.append("#").append(i).append(" ");
            sb.append(ans).append("\n");
            System.out.print(sb);
        }

    }

    public static void square(int a, int b)
    {
        int result=0;
        for(int i = a; i<a+M; i++)
        {
            for(int j=b; j<b+M; j++)
            {
                result += arr[i][j];
            }
        }
        ans = Math.max(result, ans);
    }

}
