package study._240130.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 친분관계 있는 사람들보다 무거운거 들면 자기가 짱이라 생각함
// 친분 없으면 내가 짱
public class Softeer_frog {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weight = new int[N];

        // 2차원 배열
        List<List<Integer>> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int answer=0;


        for(int i=0; i<N; i++)
        {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        //System.out.println(arr);
        // 행 만들어주기
        for(int i=0; i<N; i++)
        {
            arr.add(new ArrayList<>());
        }

        //System.out.println(arr);
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr.get(A-1).add(B-1);
            arr.get(B-1).add(A-1);

        }

        for(int i=0; i<N; i++)
        {
            int flag=0;
            for(int j=0; j<arr.get(i).size(); j++)
            {
                // 나보다 무거운거 드는 사람 있으면 안됨
                if(weight[i] <= weight[arr.get(i).get(j)])
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                answer +=1;
            }
        }
        System.out.println(answer);

    }
}
