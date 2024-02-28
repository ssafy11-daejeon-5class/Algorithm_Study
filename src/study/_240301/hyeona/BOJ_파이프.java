package study._240301.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pipe{
    int x;
    int y;
    boolean check;

    public Pipe(int x, int y, boolean check) {
        this.x = x;
        this.y = y;
        this.check = check;
    }
}
public class BOJ_파이프 {
    static int N, Ans;
    static int[][] arr;


    // 가로, 세로, 대각선
    static int[] dx ={0,1,1};
    static int[] dy ={1,0,1};

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[N][N];
        list = new ArrayList[3];

        for(int i=0; i<3; i++)
        {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        decide_mode();

        dfs(0,1,0);
        System.out.println(Ans);


    }

    private static void dfs(int x, int y, int mode) {

        if(x == N-1 && y == N-1)
        {
            Ans++;
            return;
        }

        for(int i=0; i<list[mode].size(); i++)
        {
            // 가로, 세로, 대각선
            int index = list[mode].get(i);
            Pipe p = check_go(x,y,index);
            if(p.check)
            {
                dfs(p.x, p.y, index);
            }
        }


    }

    private static Pipe check_go(int x, int y, int mode) {

        int nx = x + dx[mode];
        int ny = y + dy[mode];

        if(nx>=0 && ny>=0 && nx<N && ny<N)
        {
            if(mode == 0 || mode==1)
            {
                if(arr[nx][ny] == 0) return new Pipe(nx, ny, true);
            }
            else if(mode == 2)
            {
                if(arr[nx][ny] == 0 && arr[nx-1][ny] == 0 && arr[nx][ny-1] == 0) return new Pipe(nx, ny, true);

            }
        }
        return new Pipe(nx, ny, false);
    }

    private static void decide_mode() {

        list[0].add(0);
        list[0].add(2);

        list[1].add(1);
        list[1].add(2);

        list[2].add(0);
        list[2].add(1);
        list[2].add(2);

        // System.out.println(list[1].toString());
    }
}

