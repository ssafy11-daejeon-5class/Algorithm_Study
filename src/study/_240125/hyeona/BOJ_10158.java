package study._240125.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {
    private static final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bufferReader.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferReader.readLine());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(bufferReader.readLine());
        P = (P+T)%(2*W);
        Q = (Q+T)%(2*H);

        if(P>W) P=Math.abs(W*2-P);
        if(Q>H) Q=Math.abs(H*2-Q);


        System.out.print(P+" "+Q);


    }
}
