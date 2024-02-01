package study._240125.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10158 {
    public static int W, H, p, q, t;
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        t = Integer.parseInt(bufferedReader.readLine());
        
        // if((p+t) / W % 2 == 0){
        //     p = (p + t) % W;
        // } else if(((p+t) / W) % 2 == 1){
        //     p = W - (p + t) % W;
        // }

        // if(((q+t) / H) % 2 == 0){
        //     q = (q + t) % H; 
        // } else if(((q+t)/ H) % 2 == 1){
        //     q = H - (q+t) % H;
        // }

        /*
         * t초 후의 p, q 좌표를 전체 그래프의 너비와 높이의 2배를 한 것으로 나머지 연산을 실시한다.
         * 2배를 한 이유는 실제 지도의 너비 혹은 높이를 기준으로 위쪽으로 넘어가면 양수, 아래로 내려가면 음수의 값을 가지도록 하기 위함이다.
         */
        p = W - Math.abs(W- (p+t) %(2*W));
        q = H - Math.abs(H - (q+t)%(2*H));
        System.out.print(p + " " + q);
    }
}