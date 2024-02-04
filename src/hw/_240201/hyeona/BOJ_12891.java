package algorithm.Algorithm_Study.src.hw._240201.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {

    static int[] count, result;
    static int ans;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        // ‘A’, ‘C’, ‘G’, ‘T’
        count = new int[4];
        result = new int[4];
        ans=0;

        // 0 1 2 3 4 5
        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
        {
            // 불변
            count[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<P; i++)
        {
            if(str.charAt(i)=='A') result[0]++;
            if(str.charAt(i)=='C') result[1]++;
            if(str.charAt(i)=='G') result[2]++;
            if(str.charAt(i)=='T') result[3]++;
        }

        check();

        for(int i=0; i<S-P; i++)
        {
            if(str.charAt(i)=='A') result[0]--;
            if(str.charAt(i)=='C') result[1]--;
            if(str.charAt(i)=='G') result[2]--;
            if(str.charAt(i)=='T') result[3]--;

            if(str.charAt(i+P)=='A') result[0]++;
            if(str.charAt(i+P)=='C') result[1]++;
            if(str.charAt(i+P)=='G') result[2]++;
            if(str.charAt(i+P)=='T') result[3]++;
            check();

        }

        System.out.println(ans);
    }

    public static void check()
    {
        int flag=0;
        for(int i=0; i<4; i++)
        {
            if(result[i]<count[i])
            {
                flag=1;
                break;
            }
        }
        if(flag==0) ans+=1;
    }

}
