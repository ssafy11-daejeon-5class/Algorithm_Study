package hw._240221.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* CCTV의 회전.
* 회전을 어떻게 구현하지 ?
*  동        남       서        북
*  [0]      [1]      [2]      [3]
* (0,1) -> (1,0) -> (0,-1) -> (-1,0)
*
*
* 1번 (0) (1) (2) (3)
* 2번 (0,2) (1,3)
* 3번 (0,3) (0,1) (1,2) (2,3)
* 4번 (0,2,3) (0,1,3) (0,1,2) (1,2,3)
* 5번 (0,1,2,3)
*
* 재귀를 몇번 타야하나 ?
* ex) 2번 => 2번 => 5번
* 상태 공간 트리
*
*
*
*
*
* */

class CCTV{
    int num;
    int x;
    int y;

    public CCTV(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class BOJ_감시 {
    // 몇번째 카메라, 2차원 배열 안에서 순서, 1차원 배열 안에서 인덱스
    static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{0,2}, {1,3}},
            {{0, 3}, {0,1}, {1, 2}, {2,3}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}};

    // 동, 남, 서, 북
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int N,M, max = Integer.MIN_VALUE;
    // static int[][] arr;
    static int[][] n_arr;

    static List<CCTV> camera = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        int count=0;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] !=0 && arr[i][j] != 6)
                {
                    count++;
                    camera.add(new CCTV(arr[i][j], i, j));
                }

                if(arr[i][j] == 6)
                {
                    count++;
                }
            }
        }

        // 카메라 고르기 - 모드 고르기 - 카메라 고르기 - 모드 고르기
        if(camera.size() !=0)
        {
            select_camera(0, arr);
        }


        // System.out.println(count);
        // System.out.println(max);
        if(max == Integer.MIN_VALUE) max =0;
        System.out.println(N*M - (count+max));


    }

    private static void select_camera(int index, int[][] arr) {

        if(index == camera.size())
        {
        	
        	int result = check_area(arr);
        	// System.out.println("result :"+ result);
        	
        	
            max = Math.max(result, max);
            // System.out.println("1");
            
            //print(arr);
            
            
            return;
        }

        CCTV c = camera.get(index);

        // 고른 카메라의 모드 고르기
        // 1이라면 0,1,2,3 총 4가지 모드
        
        // 2라면 {{0,2}, {1,3}}
        for(int i=0; i<mode[c.num].length; i++)
        {
            // System.out.println("2");
            watch_area(c.x, c.y, c.num, i, arr, -1);
            
            // 다음 카메라
            select_camera(index+1, arr);
            
            watch_area(c.x, c.y, c.num, i, arr, +1);
            //print(arr);
            
            // Scanner sc = new Scanner(System.in);
            // int n = sc.nextInt();
            
        }
        
  
        

    }

    private static void print(int[][] arr) {
		
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++)
    	{
    		for(int j=0; j<M; j++)
    		{
    			sb.append(arr[i][j]).append(" ");
    		}
    		sb.append("\n");
    	}
    	
    	// System.out.print(sb);
    	// System.out.println("======================");
	}

	private static int check_area(int[][] arr) {
    	
    	int result=0;
		
    	for(int i=0; i<N; i++)
    	{
    		for(int j=0; j<M; j++)
    		{
    			if(arr[i][j] <0) result++;
    		}
    	}
    	
    	return result;
		
	}

	private static void watch_area(int x, int y, int num, int index, int[][] arr, int args) {

        
        // {} 방향 쌍 고르기
        // {} 한 쌍이 몇개로 이루어져있나 ?

        // System.out.println("3");
        int Ans=0;
        // 현 위치 x,y
        // ex) {0,1} 동쪽, 남쪽
        for(int i=0; i<mode[num][index].length; i++)
        {
            // 동, 서, 남, 북 (방향)
            // 이 방향으로 계속 가면 됨. 언제까지? 벽이거나 인덱스 끝까지
            int seq = mode[num][index][i];
            // System.out.println("**"+seq);
            
            int cx = x;
            int cy = y;

            while(true)
            {
                // System.out.println("4");
                // int n = sc.nextInt();
                // System.out.println(seq);

                int nx = cx+ dx[seq];
                int ny = cy+ dy[seq];

                // System.out.println(nx + " " + ny);
                if(nx>=0 && ny>=0 && nx<N && ny<M)
                {
                    // System.out.println("5");
                    if(arr[nx][ny]<=0)
                    {
                        arr[nx][ny] += args;
                        // Ans++;
                    }else if(arr[nx][ny] == 6) break;

                    cx = nx;
                    cy = ny;
                    // System.out.println("x "+ x);
                    // System.out.println("y "+ y);
                }else break;
                
                // System.out.println("------------");
                // print(arr);
            }

        }
        // return Ans;
    }

//    private static void copy_arr() {
//
//        n_arr = new int[N][M];
//
//        for(int i=0; i<N; i++)
//        {
//            for(int j=0; j<M; j++)
//            {
//                n_arr[i][j] = arr[i][j];
//            }
//        }
//    }
}
