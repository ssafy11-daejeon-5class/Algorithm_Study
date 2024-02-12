package algorithm.Algorithm_Study.src.hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈 도둑

// 1. 치즈 먹기
// 2. 덩어리 수 구하기

class Cor{
    int x;
    int y;

    public Cor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class SWEA_7733 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, result, max;
    static int[][] arr;
    static int[][] v;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=T; i++)
        {
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int x=0; x<N; x++)
            {
                st = new StringTokenizer(br.readLine());
                for(int y=0; y<N; y++)
                {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            int time=1;

            while(time<=100) {
                int flag=0;
                result = 0;
                v = new int[N][N];

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (arr[x][y] <= time && v[x][y] == 0) v[x][y] = 1;
                    }
                }

                // 덩어리 수 구하기
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (v[x][y] == 0) {
                            flag=1;
                            bfs(x, y);
                            result++;
                        }
                    }
                }
                max = Math.max(result, max);
                time++;
                if(max==0) max=1;
                if(flag==0)
                {
                    break;
                }


                //if(result==1) break;
            }
            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
}

    private static void bfs(int x, int y) {

        Queue<Cor> queue = new LinkedList<>();
        queue.offer(new Cor(x,y));
        v[x][y] = -1;

        while(!queue.isEmpty())
        {
            x = queue.peek().x;
            y = queue.peek().y;

            queue.poll();

            for(int i=0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && v[nx][ny]==0)
                {
                    queue.offer(new Cor(nx, ny));
                    v[nx][ny]=-1;
                }
            }
        }




    }
}
