package algorithm.Algorithm_Study.src.hw._240201.hyeona;

// 부분합으로 풀기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Hamburger{
    int score;
    int cal;

    public Hamburger(int score, int cal) {
        this.score = score;
        this.cal = cal;
    }

    public Hamburger(){};
}
public class SWEA_5215 {
    static int N, L, max,count;
    static Hamburger[] hamburgers;
    static boolean[] visited;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        max = Integer.MIN_VALUE;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        count=1;
        for(int k=1; k<=T; k++)
        {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            hamburgers = new Hamburger[N];

            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                hamburgers[i] = new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 1개 ~ N개 까지 고르기 가능
            //for(int i=1; i<=N; i++)
            //{
            visited = new boolean[N];
            recursive(3, 0, 0, 0);
            //}
            sb.append("#").append(k).append(" ").append(max).append("\n");
            System.out.println(count);
        }
        System.out.print(sb);

    }

    private static void recursive(int cnt, int index, int k, int a) {

        if(index == N)
        {
            if(k == 3)
            {
                int n_cal=0;
                int n_score=0;
                for(int i=0; i<N; i++)
                {
                    if(visited[i])
                    {
                        System.out.print(i+" ");
                        n_cal += hamburgers[i].cal;
                        n_score += hamburgers[i].score;
                    }
                }
                System.out.println();
                count++;

                if(n_cal <=L)
                {
                    max = Math.max(max, n_score);
                }
            }
            return;
        }
        for(int i=a; i<N; i++)
        {
            recursive(cnt, index+1, k+1, a+1);
        }

//        visited[index] = true;
//        recursive(cnt, index+1, k+1);
//        visited[index] = false;
//        recursive(cnt, index+1, k);


    }
}
