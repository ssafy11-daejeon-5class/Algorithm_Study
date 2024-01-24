import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class swea_1860 {

    public static int N;
    public static int M;
    public static int K;
    public static String answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test = 1 ; test < T +1 ; test++){
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            answer = "Possible";

            int[] customers = new int[N];
            for(int i = 0 ; i < N ; i++){
                customers[i] = sc.nextInt();
            }

            Arrays.sort(customers);
            for(int i = 0 ; i < N ; i++){
                if((customers[i] / M) * K < i + 1){
                    answer = "Impossible";
                }
            }
            System.out.println("#" + test +" " + answer);
        }
    }
}