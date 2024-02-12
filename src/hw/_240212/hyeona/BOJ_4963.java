package algorithm.Algorithm_Study.src.hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1 : 땅
// dfs, bfs 둘 다 해보기

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_4963 {

    // 8방 탐색 우상 우하 좌상 좌하
    static int[] dx ={0,0,-1,1,-1,1,-1,1};
    static int[] dy ={-1,1,0,0,1,1,-1,-1};
    static int W,H, result;
    static int[][] arr;
    static boolean[][] visited;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while(true)
        {
            result = 0;
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W==0 && H==0) break;

            arr = new int[H][W];
            visited = new boolean[H][W];

            for(int i=0; i<H; i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++)
                {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<H; i++)
            {
                for(int j=0; j<W; j++)
                {
                    if(arr[i][j]==1 && !visited[i][j])
                    {
                        dfs(i,j);
                        //bfs(i,j);
                        result +=1;
                    }
                }
            }

            System.out.println(result);
            //System.out.println(Arrays.deepToString(arr));
        }

    }

    private static void dfs(int x, int y) {



        for(int i=0; i<8; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<H && ny<W && !visited[nx][ny] && arr[nx][ny]==1) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }

        }


    }

    private static void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;


        while(!queue.isEmpty())
        {
            x = queue.peek().x;
            y = queue.peek().y;

            queue.poll();

            for(int i=0; i<8; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<H && ny<W && !visited[nx][ny] && arr[nx][ny]==1)
                {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }

        }




    }
}
