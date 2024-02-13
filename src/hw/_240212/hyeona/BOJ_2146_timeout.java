package hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 대륙이 몇개인가 ?
// 대륙의 가장자리를 어딘가에 저장 - 0 이랑 맞닿아있는 부분들
// -> 대륙 별로 가장자리 좌표들이 나오겠지
// 내가 필요한건 대륙의 개수와 가장자리 좌표임

// 대륙 별로 모든 조합을 비교 ?

class Points{
    int x;
    int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_2146_timeout {

    static int N, cnt, min;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static List<List<Points>> lines;

    static boolean[] v;

    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        visited = new boolean[N][N];
        lines = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println(lines);

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==1 && !visited[i][j])
                {
                    lines.add(new ArrayList<>());
                    bfs(i,j);
                    cnt++;
                }
            }
        }

        //System.out.println(lines.get(0));

//        for(int i=0; i< lines.size(); i++)
//        {
//            for(int j=0; j< lines.get(i).size(); j++)
//            {
//                System.out.print(lines.get(i).get(j).x + " " + lines.get(i).get(j).y);
//                System.out.println();
//            }
//            System.out.println();
//
//        }

        v = new boolean[lines.size()];
        // 대륙 별로 2개 뽑는 조합 코드 필요
        combination(0,0);

        // 각 대륙의 가장자리 좌표들을 다 계산해보자?
        System.out.println(min);




    }

    private static void combination(int index, int k) {

//        if(index == lines.size())
//        {
//            List<Integer> comb = new ArrayList<>();
//            if(k==cnt)
//            {
//                for(int i=0; i< lines.size(); i++)
//                {
//                    if(v[i])
//                    {
//                        comb.add(i);
//                    }
//                }
//
//                caculate_coordinate(comb.get(0), comb.get(1));
//            }
//            return;
//        }
//
//        v[index] = true;
//        combination(index+1, k+1, cnt);
//        v[index] = false;
//        combination(index+1, k, cnt);

        if(k==2)
        {
            List<Integer> comb = new ArrayList<>();
            for(int i=0; i< lines.size(); i++)
            {
                if(v[i])
                {
                    comb.add(i);
                }
            }

            caculate_coordinate(comb.get(0), comb.get(1));
            return;
        }

        for(int i=index; i< lines.size(); i++)
        {
            v[i] = true;
            combination(i+1, k+1);
            v[i] = false;
        }


    }







    private static void caculate_coordinate(int a, int b) {

        for(int j=0; j< lines.get(a).size(); j++)
        {
            for(int k=0; k<lines.get(b).size(); k++)
            {
                int result = Math.abs(lines.get(a).get(j).x - lines.get(b).get(k).x) + Math.abs(lines.get(a).get(j).y - lines.get(b).get(k).y);
                min = Math.min(min, result-1);
            }
        }

    }

    private static void checked_line(int x, int y) {

        for(int i=0; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N && arr[nx][ny]==0)
            {
                lines.get(cnt).add(new Points(x,y));
                break;
            }

        }
    }

    private static void bfs(int x, int y) {

        Queue<Points> queue = new LinkedList<>();
        queue.offer(new Points(x,y));
        visited[x][y] = true;

        checked_line(x,y);

        while(!queue.isEmpty())
        {
            x = queue.peek().x;
            y = queue.peek().y;

            queue.poll();

            for(int i=0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && arr[nx][ny]==1)
                {
                    // 상하좌우 주변에 0이 하나라도 있으면
                    visited[nx][ny]=true;
                    checked_line(nx,ny);
                    queue.offer(new Points(nx,ny));
                }
            }
        }

    }
}
