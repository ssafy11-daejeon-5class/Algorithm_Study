package algorithm.Algorithm_Study.src.study._240207.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 짝수초는 전부 폭탄
public class BOJ_16918 {


    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static List<Point> list;
    static int R, C, N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[R][C];


        for(int i=0; i<R; i++)
        {
            String str = br.readLine();
            for(int j=0; j<C; j++)
            {
                if(str.charAt(j)=='.') arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }

        int number = 1;
        // 짝수초는 볼 것도 없이 폭탄
        if(N%2==0)
        {
            for(int i=0; i<R; i++)
            {
                for(int j=0; j<C; j++)
                {
                    sb.append("O");
                }
                sb.append("\n");
            }

        }else{
            while(N!=1)
            {
                // number인 좌표들을 한번에 list에 담기
                check_one(number);

                // 터트려
                first_bomb();
                N-=2;
                //System.out.println(Arrays.deepToString(arr));

                // number 값 반전
                if(number==1) number=0;
                else number=1;
            }
            make_result(number);
        }
        //System.out.println(number);
        //System.out.println(Arrays.deepToString(arr));
        System.out.print(sb);

    }

    private static void make_result(int number) {

        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(number==0)
                {
                    if(arr[i][j]==0) sb.append("O");
                    else sb.append(".");
                }else {
                    if(arr[i][j]==0) sb.append(".");
                    else sb.append("O");
                }
            }
            sb.append("\n");
        }
    }

    // 폭발
    public static void first_bomb()
    {
        for(int i=0; i<list.size(); i++)
        {
            int r = list.get(i).x;
            int c = list.get(i).y;

            for(int k=0; k<4; k++)
            {
                int nx = r+ dx[k];
                int ny = c+ dy[k];

                if(nx>=0 && nx<R && ny>=0 && ny<C)
                {
                    // 1 전염
                    arr[nx][ny] = arr[r][c];
                }
            }
        }
    }

    public static void check_one(int num)
    {
        list = new ArrayList<>();

        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(arr[i][j]==num)
                {
                    list.add(new Point(i,j));
                }
            }
        }
    }
}
