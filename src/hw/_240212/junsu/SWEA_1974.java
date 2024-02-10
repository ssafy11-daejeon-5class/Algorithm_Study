package hw._240212.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {    // 스도쿠 검증
    static int T, answer;
    static int[][] puzzle;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T ; t++){
            puzzle = new int[9][9];
            for(int i = 0 ; i < 9 ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 9 ; j++){
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(checkRow()&&checkCol()&&checkBox()){
                answer = 1;
            } else {
                answer = 0;
            }
            System.out.println("#" + t + " " +answer);
        }
    }
    private static boolean checkBox() {
        for(int i = 0 ; i < 3 ; i ++){
            for(int j = 0 ;  j < 3 ; j++){
                int sum = 0;
                for(int k = 0 ; k < 3 ; k++){
                    for(int l = 0 ; l <3 ; l++){
                        sum += puzzle[i*3+k][j*3+l];
                    }
                }
                if(sum != 45){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkCol() {
        for(int i = 0 ; i < 9 ; i ++){
            int sum = 0;
            for(int j = 0 ;  j < 9 ; j++){
                sum += puzzle[i][j];
            }
            if(sum != 45){
                return false;
            }
        }
        return true;
    }
    private static boolean checkRow() {
        for(int i = 0 ; i < 9 ; i ++){
            int sum = 0;
            for(int j = 0 ;  j < 9 ; j++){
                sum += puzzle[j][i];
            }
            if(sum != 45){
                return false;
            }
        }
        return true;
    }
    private static void print() {
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    } 
}
