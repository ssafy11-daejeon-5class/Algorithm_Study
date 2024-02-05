package algorithm.Algorithm_Study.src.study._240205.hyeona;

// 인구 이동이 며칠 동안 발생했는지 구하기
// 4방 탐색, bfs로 땅 확정 짓기 (좌표값들을 어딘가에 담아두기)
// 확정지은 땅이 아니고, 갈 수 있는 땅이면 추가 (개수세기, 좌표값 기억하기)

// 언제까지 ? 확정 지을 땅이 없을 때 까지 (bfs다 돌았는데 개수가 0이면 종료)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_16234 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, L, R, flags, result;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result=0;


        while(true)
        {
            flags=0;
            // 땅 넓힐때 마다 매번 새롭게
            visited = new boolean[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    if(!visited[i][j])
                    {
                        bfs(i,j);
                    }
                }
            }
            if(flags==0) break;
            result+=1;
        }
        System.out.println(result);
    }

    public static void bfs(int x, int y)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});

        visited[x][y]=true;
        int sum = arr[x][y];

        List<Point> list = new ArrayList<>();
        list.add(new Point(x,y));

        while(!queue.isEmpty())
        {
            x = queue.peek()[0];
            y = queue.peek()[1];

            queue.poll();
            for(int i=0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N)
                {
                    int people=Math.abs(arr[nx][ny] - arr[x][y]);
                    if(people>=L && people <=R)
                    {
                        if(!visited[nx][ny])
                        {
                            queue.offer(new int[] {nx,ny});
                            visited[nx][ny]=true;
                            sum += arr[nx][ny];
                            list.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }

        if(list.size()>1)
        {
            int answer = sum / list.size();

            for (Point point : list) {
                arr[point.x][point.y] = answer;
            }
            flags=1;
        }// else flags =1;
        // 이렇게 else로 걸면 한번만에 전체 반복문을 탈출하게됨
        // 한 그룹을 탐색할 때 이동 인원이 없으면 flags=1이 되어서 전체 반복문을 탈출
        // 다른 그룹도 검사 해야하는데 말야

    }
}
