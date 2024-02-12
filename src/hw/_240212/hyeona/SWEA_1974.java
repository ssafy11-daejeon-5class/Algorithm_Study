package algorithm.Algorithm_Study.src.hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


// 가로, 세로, 사각형 확인
public class SWEA_1974 {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++)
        {
            arr = new int[9][9];
            for(int x=0; x<9; x++)
            {
                st = new StringTokenizer(br.readLine());
                for(int y=0; y<9; y++)
                {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            if(check_garo() && check_sero() && check_square())
                sb.append("#").append(i).append(" ").append(1).append("\n");
            else sb.append("#").append(i).append(" ").append(0).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean check_square() {

        // 0,0 -> 0,3 -> 0,6
        // 3,0 -> 3,3 -> 3,6
        // 6,0 -> 6,3 -> 6,6
        for(int i=0; i<9; i+=3)
        {
            for(int j=0; j<9; j+=3)
            {
                Set<Integer> set = new HashSet<>();
                for(int x=0; x<3; x++)
                {
                    for(int y=0; y<3; y++)
                    {
                        //System.out.print(arr[i+x][j+y]+" ");
                        set.add(arr[i+x][j+y]);
                    }
                }
                //System.out.println();
                if(set.size()!=9) return false;
            }
        }
        return true;
    }

    private static boolean check_sero() {

        for(int x=0; x<9; x++)
        {
            Set<Integer> set = new HashSet<>();
            for(int y=0; y<9; y++)
            {
                set.add(arr[y][x]);
                //System.out.print(arr[y][x]+" ");
            }
            //System.out.println();
            if(set.size()!=9) return false;
        }
        return true;

    }

    private static boolean check_garo() {


        for(int x=0; x<9; x++)
        {
            Set<Integer> set = new HashSet<>();
            for(int y=0; y<9; y++)
            {
                set.add(arr[x][y]);
            }
            if(set.size()!=9) return false;
        }
        return true;

    }
}
