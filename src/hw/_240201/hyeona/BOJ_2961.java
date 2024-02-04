package algorithm.Algorithm_Study.src.hw._240201.hyeona;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도영이가 만든 음식
// 재료 N개 (신맛 S, 쓴맛 B)
// 신맛은 곱, 쓴맛은 합
// 신맛과 쓴맛의 차이를 가장 작게 만들자

class Food{
    int s; // 신맛
    int b; // 쓴맛

    public Food(int s, int b) {
        super();
        this.s = s;
        this.b = b;
    }


}

public class BOJ_2961 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Food[] foods;
    static boolean[] isSelected;
    static int N;
    static int max = Integer.MAX_VALUE;
    static int x,y;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        foods = new Food[N];

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foods[i] = new Food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }


        for(int i=1; i<=N; i++)
        {
            isSelected = new boolean[N];
            powerSet(0, i, 0);
        }
        System.out.println(max);


    }

    // 파워셋
    public static void powerSet(int idx, int cnt, int k)
    {
        if(idx == N)
        {
            if(k==cnt)
            {
                x=0;
                y=1;
                for(int i=0; i<isSelected.length; i++)
                {
                    if(isSelected[i])
                    {
                        x+= foods[i].b;
                        y*= foods[i].s;
                    }
                }
                max = Math.min(Math.abs(x-y), max);
            }
            return;
        }

        isSelected[idx]=true;
        powerSet(idx+1, cnt, k+1);
        isSelected[idx]=false;
        powerSet(idx+1, cnt, k);


    }

}
