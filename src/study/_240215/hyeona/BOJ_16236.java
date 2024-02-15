package algorithm.Algorithm_Study.src.study._240215.hyeona;

/* 아기상어
* 아기상어가 먹을 수 있는 물고기 : 자기보다 작음
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cordinate
{
    int x;
    int y;

    int dist;

    public Cordinate(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class BOJ_16236 {

    // 위 왼 아래 오
    static int[] dx ={-1,0,0,1};
    static int[] dy={0,-1,1,0};
    static int[][] arr;
    static boolean[][] visited;
    static int N, Ans, number, shark;
    static Queue<Cordinate> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        shark=2;
        number=0;
        Ans=0;


        StringTokenizer st;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==9)
                {
                    queue.offer(new Cordinate(i, j, 0));
                    arr[i][j]=0;
                }
            }
        }

        while(true)
        {
            List<Cordinate> eatList = new ArrayList<>();
            int[][] dist = new int[N][N];

            while(!queue.isEmpty())
            {
                Cordinate cor = queue.poll();
                int x = cor.x;
                int y = cor.y;

                for(int i=0; i<4; i++)
                {
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nx>=0 && ny>=0 && nx<N && ny<N)
                    {
                        if(arr[nx][ny]<=shark && dist[nx][ny]==0)
                        {
                            // 탐색
                            dist[nx][ny] = dist[x][y]+1;
                            queue.offer(new Cordinate(nx, ny, dist[nx][ny]));
                            if(arr[nx][ny]<shark && arr[nx][ny]!=0)
                            {
                                eatList.add(new Cordinate(nx, ny, dist[nx][ny]));
                            }
                        }
                    }
                }
            }

            if(eatList.size()==0)
            {
                System.out.println(Ans);
                return;
            }

            eatList.sort(new Comparator<Cordinate>() {
                @Override
                public int compare(Cordinate o1, Cordinate o2) {

                    if (o1.dist != o2.dist) return o1.dist - o2.dist;

                    if (o1.x != o2.x) return o1.x - o2.x;

                    return o1.y - o2.y;
                }
            });

            arr[eatList.get(0).x][eatList.get(0).y]=0;
            Ans += eatList.get(0).dist;
            number++;

            if(number == shark)
            {
                shark++;
                number=0;
            }
            queue.offer(eatList.get(0));
        }

    }

    private static void print() {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

}
