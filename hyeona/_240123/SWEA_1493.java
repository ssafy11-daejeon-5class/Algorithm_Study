package algorithm.Algorithm_Study.hyeona._240123;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1493 {
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("/Users/hyeonacha/Desktop/ssafy_work/src/algorithm/Algorithm_Study/hyeona/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++)
        {
            int P = sc.nextInt();
            int result[] = cal_loaction(P);

            int x = result[0];
            int y = result[1];


            int Q = sc.nextInt();
            int result2[] = cal_loaction(Q);

            int z = result2[0];
            int w = result2[1];

            int nx = x+z;
            int ny = y+w;

            int answer =0;
            for(int k=1; k< nx+ny; k++)
            {
                answer += k;
            }
            System.out.printf("#%d %d", i+1, answer-=(ny-1));
            System.out.println();

        }
    }

    public static int[] cal_loaction(int X)
    {
        int number = 0;
        int i=1;
        while(number<X)
        {
            number += i;
            i+=1;
        }

        int index = number-X;

        int[] location = {i-1-(index), 1+index};
        return location;

    }

}
