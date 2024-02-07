package algorithm.Algorithm_Study.src.hw._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[100][100];
        int result=0;

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int a=x; a<x+10; a++)
            {
                for(int b=y; b<y+10; b++)
                {
                    if(!check[a][b])
                    {
                        check[a][b]=true;
                        result+=1;
                    }
                }
            }
        }

        System.out.println(result);

    }
}
