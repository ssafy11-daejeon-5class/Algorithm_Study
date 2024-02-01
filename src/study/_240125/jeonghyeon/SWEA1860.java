package study._240125.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
 
public class SWEA1860{
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        int T;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N, M, K;
            List<Integer> boongs = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
 
            int m = M;
            while (boongs.size() < N) {
                for (int k = 0; k < K; k++) {
                    boongs.add(m);
                }
                m += M;
            }
 
            List<Integer> customers = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                customers.add(Integer.parseInt(st.nextToken()));
            }
            customers.sort(null);
 
            String result = "Possible";
            for (int n = 0; n < N; n++) {
                if (boongs.get(n) > customers.get(n))
                    result = "Impossible";
            }
 
            System.out.println("#" + t + " " + result);
        }
    }
}