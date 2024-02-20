package hw._240219.hyeona;


import java.util.Scanner;

public class BOJ_전자레인지 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {300, 60, 10};
        int[] ans = {0,0,0};

        int T = sc.nextInt();

        for(int i=0; i<3; i++)
        {
            if(T < arr[i]) continue;

            ans[i] = T/arr[i];
            T -= arr[i] * (ans[i]);
        }

        if(T>0) System.out.println(-1);
        else{
            for(int i=0; i<3; i++)
            {
                System.out.print(ans[i]+" ");
            }
        }


    }
}
