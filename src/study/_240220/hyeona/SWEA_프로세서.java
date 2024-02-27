package study._240220.hyeona;



/*
* 전선 길이의 합이 최소
* 내가 할 수 있는 선택 : (상,하,좌,우) / 0 이면 전선 연결 가능 (벽을 만날 때 까지)
* 한 맥시노스당 한 방향으로만 전선을 연결할 수 있음
* 백트래킹 시 연결 했던 전선은 원복  필수
*
* 깊이가 맥시노스 개수만큼 되면 리턴
*
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Mexinose{
    int x;
    int y;

    public Mexinose(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class SWEA_프로세서 {

    static int T, N, min, maxCore;
    static int[][] arr;

    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};


    static List<Mexinose> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=T; i++)
        {
            min = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            sb.append("#").append(i).append(" ");
            list = new ArrayList<>();

            for(int x=0; x<N; x++)
            {
                st = new StringTokenizer(br.readLine());

                for(int y=0; y<N; y++)
                {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                    if(x != 0 && y != N-1 && x != N-1 && y!=0 && arr[x][y] ==1)
                    {
                        list.add(new Mexinose(x, y));
                    }
                }
            }

            // print();

            dfs(0, 0, 0);
            sb.append(min).append("\n");
        }

        System.out.print(sb);

    }

    private static void dfs(int index, int Ans, int core) {

        // basis part
        if(index == list.size())
        {
            if(core > maxCore)
            {
                maxCore = core;
                min = Ans;
            }else if(maxCore == core)
            {
                min = Math.min(Ans, min);
            }
            return;
        }

        // inductive part
        for(int i=0; i<4; i++)
        {
            if(connect(list.get(index).x,  list.get(index).y, i))
            {
                // 해당 방향으로 연결 가능
                dfs(index+1, Ans+cell(list.get(index).x,  list.get(index).y, i, -1), core+1);
                cell(list.get(index).x,  list.get(index).y, i, 0);
            }else{
                dfs(index+1, Ans, core);
            }

            // 한 줄이 싹 다 0이어야 연결할 수 있음
        }

        // 아예 안고르기

    }

    private static int cell(int x, int y, int i, int r) {

        int cnt=0;
        while(true)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N)
            {
                arr[nx][ny] = r;
                cnt++;
            }
            if(nx == N-1 || ny == N-1 || nx == 0 || ny ==0 || arr[nx][ny]==1)
            {
                break;
            }
            x = nx;
            y = ny;
        }
        return cnt;


    }

    private static boolean connect(int x, int y, int i) {

        while(true)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N)
            {
                if(arr[nx][ny] != 0) return false;

                if(nx == N-1 || ny == N-1 || nx == 0 || ny==0)
                {
                    return true;
                }


            }else return false;

            x = nx;
            y = ny;
        }

    }

    private static void print() {

//        for(int i=0; i<list.size(); i++)
//        {
//            System.out.println(list.get(i).x + " " + list.get(i).y);
//        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
