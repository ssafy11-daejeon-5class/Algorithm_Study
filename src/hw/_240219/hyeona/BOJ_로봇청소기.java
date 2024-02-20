package hw._240219.hyeona;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 북(0) - 동(1) - 남(2) - 서(3)
* 0 : 청소되지 않은 빈 칸
* 1 : 벽
*
* 반시계 방향 90도 회전 : -1
* 청소 여부를 표시하는 배열 필요 : clear
*
* 후진, 전진
*
* < 과정 >
1. 현재 칸의 주변 4칸의 청소 여부 확인
 - 빈칸이 있을 때
 * 한칸 후진, 벽이라 후진 할 수 없으면 종료

 - 빈칸이 없을 때
 1) 반시계 방향 회전
 2) 한칸 앞 청소 여부 확인 - 청소 안 됐으면 전진
 *
* */
public class BOJ_로봇청소기{

    // 북 동 남 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N, M, R, C, D, x, y;
    static int[][] arr;
    static boolean[][] clear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        clear = new boolean[N][M];

        int Ans =0;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 현재 칸
        x = R;
        y = C;

        while(true)
        {
            // 현재 칸 청소
            if(arr[x][y] == 0 && !clear[x][y])
            {
                clear[x][y] = true;
                Ans++;
            }

            // 주변 4칸 청소 여부 확인
            // 청소 안된 빈칸이 없을 때
            if(check_clear(x,y))
            {
                // br.readLine();
                // 후진 여부 확인
                if(!check_backward(x,y)) break;

            }else { // 있을 때

                // br.readLine();
                // 1. 회전
                D = (D-1)%4;
                if(D == -1) D = 3;
                // 앞쪽 칸 확인 하고 전진
                forward(x, y);
            }
        }

        System.out.println(Ans);

    }

    private static void forward(int a, int b) {

        // System.out.println("forward");
        // 청소되지 않은 빈칸일 경우 한칸 전진
        int nx = a + dx[D];
        int ny = b + dy[D];

        if(nx>=0 && ny>=0 && nx<N && ny<M)
        {
            if(arr[nx][ny] == 0 && !clear[nx][ny])
            {
                x = nx;
                y = ny;
            }
        }

    }

    private static boolean check_backward(int a, int b) {

        // System.out.println("backward");
        // 후진
        int nx = a - dx[D];
        int ny = b - dy[D];

        if(nx>=0 && ny>=0 && nx<N && ny<M)
        {
            // 벽이면 후진 불가
            if(arr[nx][ny] == 1) return false;
        }
        else return false; // 인덱스 밖이어도 후진 불가능

        // 후진 가능하니까 후진
        x = nx;
        y = ny;
        return true;


    }

    private static boolean check_clear(int x, int y) {

        // System.out.println("clear");
        for(int i=0; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<M)
            {
                // 청소 되지 않은 칸이 있으면
                if(!clear[nx][ny] && arr[nx][ny] == 0) return false;
            }
        }
        return true;


    }
}

