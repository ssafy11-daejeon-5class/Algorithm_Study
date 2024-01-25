package algorithm.Algorithm_Study.hyeona._240123;

import java.util.Scanner;

public class SWEA_7964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++)
        {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int answer =0;
            int[] arr = new int[N];
            for(int j=0; j<N; j++)
            {
                arr[j] = sc.nextInt();
            }

            int index=0;
            // D 칸을 왔으면 1로 만들어줘야하고, 1을 만나면 칸 수를 초기화한다

            for(int k=0; k<N; k++)
            {
                index +=1;
                if(index>=D && arr[k]==0)
                {
                    answer +=1;
                    index=0;
                }
                if(arr[k]==1)
                {
                    index=0;
                }
            }
            System.out.printf("#%d %d", i+1, answer);
            System.out.println();

        }

    }
}
