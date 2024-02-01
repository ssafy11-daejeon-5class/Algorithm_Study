package hw._240201.jeonghyeon;

import java.util.Scanner;
 
public class SWEA5215_PowerSet {

    static int[] tastes;
    static int[] calories;
    static int N;
    static int L;
    static int maxTaste = 0;
     
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
             
            N = sc.nextInt();
            L = sc.nextInt();   
            maxTaste = 0;
 
            tastes = new int[N]; // tastes
            calories = new int[N]; // calories
            for(int n = 0; n < N; n++) {
                tastes[n] = sc.nextInt();
                calories[n] = sc.nextInt();
            }
 
            powerSet(0, 0, new boolean[tastes.length]);
            System.out.println("#" + t + " " + maxTaste);   
        }
         
         
    }
 
     
    private static void powerSet(int idx, int k, boolean[] sel) {
        // basis part
        // 선택했으면
        if(idx == tastes.length) {
            int taste = 0;
            int cal = 0;
            for(int i = 0; i < tastes.length; i++) {
                if(sel[i]) {
                    taste += tastes[i];
                    cal += calories[i];
                    if (cal > L) return;
                }
            }
            maxTaste = Math.max(maxTaste, taste);
            return;
        }
         
        // inductive part
        sel[idx] = true;
        powerSet(idx+1, k+1, sel);
        sel[idx] = false;
        powerSet(idx+1, k, sel);
    }
}
