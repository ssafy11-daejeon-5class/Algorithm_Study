package algorithm.Algorithm_Study.src.hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달

// 여러 치킨 집 중에 M개 고르기 -> 조합?
// 각 집에서 치킨집 사이의 거리를 모두 구하긔 (완탐?)
class Areas{
    int x;
    int y;

    public Areas(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_15686 {

    static int min, M, N, mmin;
    static List<Areas> list = new ArrayList<>();
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        M = Integer.parseInt(st.nextToken());

        mmin = Integer.MAX_VALUE;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2)
                {
                    list.add(new Areas(i,j));
                }
            }
        }
        visited = new boolean[list.size()];
        combinations(0, 0);
        System.out.println(mmin);


    }

    private static void combinations(int idx, int k) {

        if(idx==M)
        {
            List<Integer> number = new ArrayList<>();
            for(int i=0; i<visited.length; i++)
            {
                //System.out.println(Arrays.toString(visited));
                if(visited[i]) {
                    //System.out.println(i);
                    number.add(i);
                }
            }
            //System.out.println(number);
            calculate_chicken(number);
            return;
        }


        for(int i=k; i< list.size(); i++)
        {
            visited[i] = true;
            combinations(idx+1, i+1);
            visited[i] = false;
        }

    }

    private static void calculate_chicken(List<Integer> number) {

        int Ans=0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(arr[i][j]==1)
                {
                    min = Integer.MAX_VALUE;
                    // 어떤 집을 치킨 거리로 할 것인가
                    for(int k=0; k<number.size(); k++)
                    {
                        int result = Math.abs(list.get(number.get(k)).x-i) + Math.abs(list.get(number.get(k)).y-j);
                        min = Math.min(result, min);
                        //System.out.println(min);
                    }
                    Ans += min;
                    // System.out.println(min);

                }
            }
        }
        //System.out.println(Ans);
        mmin = Math.min(Ans, mmin);

    }
}
