package algorithm.Algorithm_Study.src.hw._240201.hyeona;


import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2023 {

    static boolean[] visited;
    static int N;
    static int temp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        temp=0;
        N = sc.nextInt();

        // 4 -> 10000
        //System.out.println(visited[16]);


        for(int i=2; i<=9; i++)
        {
            // 소수일 때 true 리턴
            if(prime_number(i))
            {
                recursive(i, 0);
            }

        }

    }

    public static void recursive(int start, int cnt)
    {

        if(cnt==N-1)
        {
            System.out.println(start);
            return;
        }

        //System.out.print("1. "+temp+" "+cnt);
        //System.out.println();
        for(int i=1; i<=9; i++)
        {
            // 소수라면 재귀
            if(prime_number((int) (start*10)+i))
            {
                recursive((int) (start*10)+i, cnt+1);
                //System.out.println("2. "+temp+" "+cnt);
            }
        }
    }

    // 소수 판별 함수
    public static boolean prime_number(int num)
    {

        for(int i=2; i*i <= num; i++)
        {
            if(num%i==0) return false;
        }
        return true;
    }
}
