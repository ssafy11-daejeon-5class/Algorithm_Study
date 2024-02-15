package hw._240214.hyeona;

// 할 수 있는 선택 3개 : 앞으로, 오위, 오아래
// 출발할 수 있는 위치 : 각 행

// 건물 만나면 돌아오기
// 동시에 돌리는건가 ? 출발점이 각 행임. 하나 연결 하나 출발?
// 파이프가 지나온길은 지나면 안됨 -> 방문 배열 필요
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

    // 오위, 오, 오아래
    static int[] dx={-1,0,1};
    static int[] dy={1,1,1};

    static char[][] arr;
    static boolean[][] visited;
    static int R, C, Ans, flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++)
        {
            String str = br.readLine();
            for(int j=0; j<C; j++)
            {
                arr[i][j] = str.charAt(j);
            }
        }
        // System.out.println(Arrays.deepToString(arr));

        for(int i=0; i<R; i++)
        {
            //System.out.println("start");
            dfs(i,0);
            flag=0;
        }

        System.out.println(Ans);

    }

    private static void dfs(int x, int y) {


        if(y == C-1)
        {
            Ans++;
            // 다음 행 재귀?
            // 파이프 하나 추가
            flag=1;
            return;
        }


        for(int i=0; i<3; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<R && ny<C)
            {
                if(arr[nx][ny] !='x' && !visited[nx][ny])
                {
                    // 한판에 동시에 파이프를 놓아야하기 때문에 false로 X
                    visited[nx][ny]=true;
                    //System.out.println("nx "+nx+" ny "+ny);
                    // 돌아와서 바로 리턴시켜서 다음 재귀로 못 들어가게 하기
                    dfs(nx, ny);
                    if(flag==1) return;
            
                        
                }
            }
        }
    }
}
