package algorithm.Algorithm_Study.src.hw._240212.hyeona;

// 같은 알파벳을 2번 이상 보면 안됨 -> 지나갔던 칸 검사가 아니라, A-Z까지 검사하는 무언가를 만들어야함
// A부터 Z까지 65~90
// 같은 명물 있을 수 있음
// dfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699 {

    static int R, C, max;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] arr;
    static boolean[] check;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=T; i++)
        {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            max = Integer.MIN_VALUE;
            arr = new char[R][C];
            check = new boolean[26];

            for(int j=0; j<R; j++)
            {
                String str = br.readLine();
                for(int k=0; k<C; k++)
                {
                    arr[j][k] = str.charAt(k);
                }
            }
            //check[arr[0][0]-65]=true;
            //System.out.println(check[arr[0][0]-65]);
            //System.out.println(Arrays.deepToString(arr));

            check[arr[0][0]-65]= true;
            dfs(0,0,1);

            sb.append("#").append(i).append(" ").append(max).append("\n");

        }
        System.out.print(sb);

    }

    private static void dfs(int x, int y, int cnt) {

        max = Math.max(cnt, max);

        // inductive part
        for(int i=0; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<R && ny<C && !check[arr[nx][ny]-65])
            {
                check[arr[nx][ny]-65]=true;
                dfs(nx, ny, cnt+1);
                check[arr[nx][ny]-65]=false;
            }
        }


    }
}
