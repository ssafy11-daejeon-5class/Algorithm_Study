package study._240215.hyeona;

/* 아기상어
* 아기상어가 먹을 수 있는 물고기 : 자기보다 작음
* 크기가 같으면 먹을수는 없고 지나가기는 가능
*
* 먹을 수 있는 물고기가 많다면 가장 가까운거 먹기
* 여러마리라면 가장 위, 가장 왼쪽
*
* 자신의 "크기와 같은 수의 물고기"를 먹을 때 마다 크기가 1 증가
* 크기가 2일 때 2마리를 먹으면 크기가 1 증가해서 3이됨
*
* 몇초동안 물고기를 먹을 수 있을까?
*
*
*
* 1. 먹을 수 있는 물고기가 있는지 탐색
* - 먹을 수 있는 (상어보다 크기가 작은) "가장 가까이 있는" 물고기 찾기 - bfs
* -> 상어는 자기보다 큰 물고기가 아니면 자유롭게 지나다닐 수 있음
* -> 한칸 이동할 때 마다 1초 소요
* - 가까이 있는 물고기가 여러개인지 어떻게 판단할 것인가 ?????
*
*
*
*
* (먹으면 상어 위치 이동 / 물고기 빈칸 처리 / 몇마리 먹었는지 카운트 -> 몸집 키우기 / 이동할 때마다 시간 기록)
* 상어 위치에서 계속 bfs 돌리기
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Cordinate
{
    int x;
    int y;
    
    int local_x; 
    int local_y;

    int time;

    public Cordinate(int x, int y, int time, int local_x, int local_y) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.local_x = local_x;
        this.local_y = local_y;
    }
}

public class BOJ_16236 {

    // 위 왼 아래 오
    static int[] dx ={-1,0,0,1};
    static int[] dy={0,-1,1,0};
    static int[][] arr;
    static boolean[][] visited;
    static int N, Ans, number, shark;
    static Queue<Cordinate> queue;
    static List<Cordinate> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        int x=0;
        int y=0;
        shark=2;
        list = new ArrayList<>();

        StringTokenizer st;

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==9)
                {
                    x=i;
                    y=j;
                }
            }
        }


        bfs(x,y);
        print();
        //System.out.println(Ans);
//        if(flag==1) System.out.println(time);
//        else System.out.println(0);


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

	private static void bfs(int x, int y) throws IOException {

        int time=0;
        int flag=0;
        queue = new LinkedList<>();
        queue.offer(new Cordinate(x, y, time, x, y));
        visited[x][y]=true;


        while(!queue.isEmpty())
        {

            x = queue.peek().x;
            y = queue.peek().y;
            int local_x = queue.peek().local_x;
            int local_y = queue.peek().local_y;
            
            time = queue.peek().time;

            queue.poll();
            //System.out.print("poll"+" "+x+" "+y);
            //System.out.println();
            
            
            for(int i=0; i<4; i++)
            {

                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny])
                {
                    // 이동 (0이거나 같으면 계속 탐색)
                    if(arr[nx][ny]==0 || arr[nx][ny] == shark)
                    {
                        //System.out.print(nx+" "+ny+" "+arr[nx][ny]);
                        //System.out.println();
                        queue.offer(new Cordinate(nx, ny, time+1, local_x, local_y));
                        visited[nx][ny] = true;
                        //System.out.println("time"+ time);
                        //System.out.println("들어가 들어가");
                        //System.out.println(nx+" "+ny+" ");
                    } // 0이 아니고, 크기가 작은 물고기를 만나면 먹기

                    // 바로 먹는게 아니라 거리 따져서 걔를 먹어야함!
                    if(arr[nx][ny]!=0 && arr[nx][ny]<shark)
                    {
                    	flag=1;
                    	list.add(new Cordinate(nx, ny, time, local_x, local_y));
                    }

                }
            }
            
            if(flag==1)
            {
                // nx, ny를 기준에 맞게 정렬
                // 가장 위에 있는 물고기, 가장 왼쪽에 있는 물고기
                // nx 기준 오름차순, ny기준 오름차순 정렬
            	
            	print2();
                Collections.sort(list, new Comparator<Cordinate>()
                {
                	@Override
    				public int compare(Cordinate o1, Cordinate o2) 
                	{
    					
                		return o1.x != o2.x ? o1.x-o2.x : o1.y -o2.y;
                	}
                	
                });
                
                
                eat_fish(list.get(0));
                flag=0;
                list = new ArrayList<>();
                
            }

            
            
        }
    }

	private static void print2() {
		System.out.println("list 시작");
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).x + " "+list.get(i).y); 
		}
		System.out.println("list 끝");
		
	}

	private static void eat_fish(Cordinate cor) {
		
		
		int nx = cor.x;
		int ny = cor.y;
		
		int local_x = cor.local_x;
		int local_y = cor.local_y;
		
		int time = cor.time;
		
        arr[nx][ny]=9;

        // 여기서 쓸데없는 값이 바뀐다
        arr[local_x][local_y]=0;
        number++;

        System.out.println("number "+ number);


        Ans += (time+1);
        time = time+1;


        queue.clear();
        queue.offer(new Cordinate(nx, ny, 0, nx,ny));
        
        
        //System.out.println("--");
        //System.out.print(nx+" "+ny);
        //System.out.println();
        //System.out.println("--");
        
        visited = new boolean[N][N];
        visited[nx][ny]=true;
        
        System.out.println("shark size " + shark);
        System.out.println("time "+ Ans);
        print();
        
        //System.out.println();
        //System.out.print(nx+" "+ny);
        System.out.println("=========");
        
        if(number==shark)
        {
            number=0;
            shark++;
            //System.out.println(shark);
        }
        
		
		
	}
}
