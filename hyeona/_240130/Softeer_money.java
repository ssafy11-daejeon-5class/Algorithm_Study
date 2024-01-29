package algorithm.Algorithm_Study.hyeona._240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 무게, 무게 당 가격 -> 가격이 비싸야함
// 자를 수 있음

// 140 + 30 = 170
// 비싼 애들을 최대한 많이 넣자
// 10000 가치 까지 가능
public class Softeer_money {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[10001];
        int answer=0;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            // 가치를 인덱스로
            arr[P] += M;
        }

        for(int i=10000; i>=1; i--)
        {
            if(arr[i]<=W && arr[i]!=0)
            {
                answer += (arr[i]*i);
                W-=(arr[i]);
            }else if(arr[i]>=W){
                answer+=W*i;
                break;
            }
        }
        System.out.println(answer);

    }
}
