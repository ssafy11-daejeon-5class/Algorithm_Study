/*
사용자는 2명으로 고정
1. 충전판 만들기 (bfs)


* 선택을 해야하는 상황
* 1) 여러개의 BC를 선택할 수 있을 때 (BC의 영역이 겹칠 때)
* - 어떤걸 고르게 할 것인가 (제일 많이 충전할 수 있는 BC를 골라야함)
* 1. 해당 초에 겹치는 BC를 사용하는 사용자가 있는지 확인
*
*
*
* 겹치는 영역을 어떻게 표시할 것인가? -1로 해두고, 정보들을 따로 리스트에 모아두기
* 좌표, 어떤 BC인지, 충전값 ?
*
*
*
* */
package study;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class BC{
    int x;
    int y;
    int range;
    int power;

    public BC(int x, int y, int range, int power) {
        this.x = x;
        this.y = y;
        this.range = range;
        this.power = power;
    }
}
public class SWEA_무선충전 {


    static int M,A,ans1, ans2;
    static int[] user1, user2;
    static int[][] arr;
    static boolean[][] v;

    // 상,우,하,좌
    static int[] dx= {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};

    static List<BC> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++)
        {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            user1 = new int[M];
            user2 = new int[M];
            ans1 = 0;
            ans2 = 0;

            arr = new int[10][10];
            v = new boolean[10][10];
            sb.append("#").append(i).append(" ");

            A = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                user1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                user2[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=0; j<A; j++)
            {
                st = new StringTokenizer(br.readLine());
                list.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // System.out.println(list.get(0).x + " " + list.get(0).power);
            go_user();
            
            //System.out.println(ans1);
            //System.out.println(ans2);
            sb.append(ans1+ ans2).append("\n");

        }

        System.out.print(sb);

    }

    private static void go_user() {

        // 1번 (0,0)
    	// 출발지도 확인해야함
        int x1=0;
        int y1=0;

        int x2=9;
        int y2=9;

        List<int[]> user1_list = null;
        List<int[]> user2_list = null;
        
        for(int i=0; i<M; i++)
        {
            user1_list = new ArrayList<>();
            user2_list = new ArrayList<>();
            
            
            int nx1 = x1 + dx[user1[i]];
            int ny1 = y1 + dy[user1[i]];

            int nx2 = x2 + dx[user2[i]];
            int ny2 = y2 + dy[user2[i]];

     
            user1_list = check_dist(x1, y1);
 

            x1 = nx1;
            y1 = ny1;

 
           user2_list = check_dist(x2, y2);

            
            x2 = nx2;
            y2 = ny2;
            
            
            charge_user(user1_list, user2_list);
        }
        
        user1_list = check_dist(x1, y1);
        user2_list = check_dist(x2, y2);
        charge_user(user1_list, user2_list);
        
    }



	private static void charge_user(List<int[]> user1_list, List<int[]> user2_list) {
        // user1_list, user2_list 여기에는 각 좌표에서 충전가능한 bc리스트가 담겨있음
        
        // 1. 둘 중 하나는 사이즈가 0 (사용자끼리 충전할 수 있는 BC가 겹치지 않음)
        // 1-1. 나머지 하나의 사이즈가 1일 때 -> 그냥 충전
        // 1-2. 나머지 하나의 사이즈가 2이상이면? -> 더 큰거 고르기
        if(user1_list.size() == 0 || user2_list.size() == 0)
        {
        	if(user1_list.size() == 1)
        	{
        		ans1 += user1_list.get(0)[1];
        	}else if(user2_list.size() == 1)
        	{
        		ans2 += user2_list.get(0)[1];
        	}else if(user1_list.size() >=2)
        	{
        		Collections.sort(user1_list, (a,b) -> {	
        			return b[1]-a[1];
        		});
        		
        		ans1 += user1_list.get(0)[1];
        		
        	}else if(user2_list.size() >=2)
        	{
        		Collections.sort(user2_list, (a,b) -> {	
        			return b[1]-a[1];
        		});
        		
        		ans2 += user2_list.get(0)[1];
        		
        	}
        }else // 2. 둘 다 사이즈가 1이상일 때 (사용자끼리 BC가 겹칠 수도 있음)
        {
    		Collections.sort(user1_list, (a,b) -> {	
    			return b[1]-a[1];
    		});
    		
    		Collections.sort(user2_list, (a,b) -> {	
    			return b[1]-a[1];
    		});
    		
    		int min = Integer.MIN_VALUE;
    		int S =0;

    		for(int k=0; k<user1_list.size(); k++)
    		{
    			int index = user1_list.get(k)[0];
        		for(int z=0; z<user2_list.size(); z++)
        		{
        			S = user1_list.get(k)[1];
        			if(index == user2_list.get(z)[0])
        			{
        				min = Math.max(min, user2_list.get(z)[1]);
        				// ans1 += user2_list.get(z)[1];
        			}else {
        				S += user2_list.get(z)[1];
        				min = Math.max(S, min);
        			}
        		}
    		}
    		ans1 += min;
        }
		
	}

	private static List<int[]> check_dist(int x, int y) {

        List<int[]> bcList = new ArrayList<>();
        // i는 BC의 번호, 파워
        for(int i=0; i<list.size(); i++)
        {
            int bcy = list.get(i).x-1;
            int bcx = list.get(i).y-1;
            int range = list.get(i).range;
            int power = list.get(i).power;

            if(Math.abs(bcx - x) + Math.abs(bcy - y) <=range)
            {
                bcList.add(new int[]{i, power});
            }
        }

        return bcList;

    }

    private static boolean check_range(int x, int y) {

        if(x>=0 && y>=0 && x<10 && y<10) return true;
        else return false;

    }


}
