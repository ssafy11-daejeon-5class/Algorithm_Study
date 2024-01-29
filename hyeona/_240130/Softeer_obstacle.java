package algorithm.Algorithm_Study.hyeona._240130;

// 연결 요소의 개수 세기
// bfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Softeer_obstacle {

    static int N;
    static int[][] arr;
    static int[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int bfs(int x, int y)
    {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {x,y});
        int count=1;

        while(!queue.isEmpty())
        {
            x = queue.peek()[0];
            y = queue.peek()[1];

            visited[x][y]=1;

            queue.poll();

            for(int i=0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N)
                {
                    if(visited[nx][ny]==0 && arr[nx][ny]==1)
                    {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny]=1;
                        count+=1;
                    }
                }
            }
        }
        return count;
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        arr = new int[N][N];
        visited = new int[N][N];

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<N; j++)
            {
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(arr[i][j]==1 && visited[i][j]==0)
                {
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i< result.size(); i++)
        {
            System.out.println(result.get(i));
        }

    }
}
