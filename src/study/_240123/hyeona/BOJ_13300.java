package study._240123.hyeona;

import java.util.Scanner;

public class BOJ_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int answer = 0;

        int[] woman = new int[7];
        int[] man = new int[7];


        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int Y = sc.nextInt();

            if (S == 0) {
                woman[Y] += 1;
            } else {
                man[Y] += 1;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (woman[i] % K == 0) {
                answer += (woman[i] / K);
            } else {
                answer += (woman[i] / K + 1);
            }

            if (man[i] % K == 0) {
                answer += (man[i] / K);
            } else {
                answer += (man[i] / K + 1);
            }


        }
        System.out.println(answer);
    }
}
