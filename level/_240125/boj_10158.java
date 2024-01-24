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
        
        if((p+t) / W % 2 == 0){
            p = (p + t) % W;
        } else if(((p+t) / W) % 2 == 1){
            p = W - (p + t) % W;
        }

        if(((q+t) / H) % 2 == 0){
            q = (q + t) % H; 
        } else if(((q+t)/ H) % 2 == 1){
            q = H - (q+t) % H;
        }

        System.out.print(p + " " + q);
    }
}