package algorithm.Algorithm_Study.src.hw._240212.hyeona;

// 연구소

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs로 벽 세우기
// bfs로 바이러스 퍼트리기
class Area{
    int x;
    int y;

    public Area(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_14502 {

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] arr, new_arr;
    static int N, M, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);


    }

    private static void dfs(int cnt) {

        if(cnt==3)
        {
//            System.out.println(Arrays.deepToString(arr));
//            System.out.println();
            bfs();
            count_safe();
            return;
        }


        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(arr[i][j]==0)
                {
                    arr[i][j]=1;
                    dfs(cnt+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    private static void count_safe() {
        int count=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (new_arr[i][j] == 0) {
                    count++;
                }
            }
        }
        //System.out.println(count);

        max = Math.max(max, count);
    }

    private static void bfs() {

        Queue<Area> queue = new LinkedList<>();

        new_arr = new int[N][M];
        boolean[][] v = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            new_arr[i] = arr[i].clone();
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(new_arr[i][j]==2 && !v[i][j])
                {
                    v[i][j]=true;
                    queue.offer(new Area(i,j));
                    //System.out.println(i+" "+j);
                }
            }
        }

        while(!queue.isEmpty())
        {
            int x= queue.peek().x;
            int y= queue.peek().y;

            queue.poll();

            for(int i=0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && !v[nx][ny] && new_arr[nx][ny]==0)
                {
                    v[nx][ny]=true;
                    new_arr[nx][ny]=2;
                    queue.offer(new Area(nx, ny));
                }
            }

        }

        //System.out.println(Arrays.deepToString(new_arr));
        //System.out.println();


    }
}
