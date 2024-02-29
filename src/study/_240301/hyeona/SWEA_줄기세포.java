package study._240301.hyeona;

/*
x시간 비활성 상태 -> x시간 후 활성 상태 -> x시간이 지나고 die (그대로 셀을 차지)
활성화된 줄기세포는 상,하,좌,우로 번식 (이미 줄기세포가 있으면 그 자리로는 번식 안됨)
한 칸에 두개 이상의 줄기세포가 동시에 번식하려고 하는 경우, 더 높은 세포가 그 자리를 차지함

각 세포 객체는 위치, 시간을 가지고 있어야함 -> (시간이 다 흐르면) 0이 되면 번식

배양 용기의 크기는 무한하다.........

생명력은 10이하, 초기 영역의 넓이는 최대 50*50, 배양시간은 300 이하
->


*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_줄기세포 {

    static class Cell{

        int x;
        int y;
        int time;

        public Cell(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int N, M, K;

    static int[][] arr;
    static boolean[][] v;
    
    static List<Cell> list;

    static Queue<Cell> pq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=T; i++)
        {
            st = new StringTokenizer(br.readLine());
            N  = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            sb.append("#").append(i).append(" ");
            arr = new int[N+K+2][M+K+2];
            v = new boolean[N+K+2][M+K+2];

            for(int x=K/2+1; x<N+ K/2 +1; x++)
            {
                st = new StringTokenizer(br.readLine());
                for(int y=K/2+1; y<M+ K/2 +1; y++)
                {
                    int S = Integer.parseInt(st.nextToken());
                    if(S !=0)
                    {
                        arr[x][y] = S;
                        pq.offer(new Cell(x, y, S));
                        v[x][y] = true;
                    }
                }
            }

            while(true)
            {
            	
            	System.out.println(K +"**********");
                
                breeding();
                
                K--;
                
                // 번식
                // list에 담긴 애들은 동시 번식임 (생명력 수치가 높은 순부터 번식 진행)
                
                // 생명력 높은 애들부터 번식
                list.sort(new Comparator<Cell>() {
                    @Override
                    public int compare(Cell o1, Cell o2) {
                        return Integer.compare(o2.time, o1.time);
                    }
                });
                
                
                for(int z=0; z<list.size(); z++)
                {
                    spread(list.get(z).x, list.get(z).y);
                }
                
                
                if(K==0) break;
                
            }

            int Ans = pq.size();
            sb.append(Ans).append("\n");

        }
        System.out.print(sb);
    }

    private static void breeding() {

        // 1초 마다 번식 가능한 세포가 있는지 모두 확인 (다 돌면서)
    	
    	list = new ArrayList<>();
    	Queue<Cell> Q = new ArrayDeque<>();
    	
    	while(!pq.isEmpty())
    	{
    		Cell c = pq.poll();
    		
    		// 활성 상태
    		if(c.time == 0)
    		{
    			list.add(c);
    		}else {
    			Q.offer(new Cell(c.x,  c.y, c.time -1));
    		}
    		
    	}
    	
    	pq = Q;
    	

//        for(int i=0; i<list.size(); i++)
//        {
//            System.out.print(list.get(i).time +" ");
//        }
//        System.out.println();



    }

    private static void spread(int x, int y) {

        int[] dx ={0,0,-1,1};
        int[] dy ={-1,1,0,0};

        for(int i=0; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            
            if(!v[nx][ny])
            {
                System.out.println(nx + " "+ ny);
                
                // 퍼뜨려 (근데 5초뒤에 x,y가 죽음)
                // 죽음이 빠졌네
                pq.offer(new Cell(nx, ny, arr[x][y]));
                arr[nx][ny] = arr[x][y];
                v[nx][ny] = true;
            }

        }


    }
}

