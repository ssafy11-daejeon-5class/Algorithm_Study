package study._240125.hyeona;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++)
        {
            String answer ="Possible";
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int [] arr=new int[N];

            for(int j=0; j<N; j++)
            {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);

            int fish = 0;
            int count=0;

            // 1초 ~ max초
            for(int x=1; x<=arr[N-1]; x++)
            {
                if(x%M==0)
                {
                    fish+=K;
                }
                if(x == arr[count])
                {
                    count+=1;
                    if(fish>0)
                    {
                        fish-=1;
                    }
                    else{
                        answer="Impossible";
                        break;
                    }
                }
            }

            if(arr[0]==0)
            {
                answer = "Impossible";
            }
            System.out.printf("#%d %s", i+1, answer);
            System.out.println();

        }
    }
}
