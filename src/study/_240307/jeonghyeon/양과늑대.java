package study._240307.jeonghyeon;

import java.util.*;
import java.io.*;

public class 양과늑대 {
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length;
        
        List<Integer>[][] arrStart = new List[R][C];
        List<Integer>[][] arrEnd = new List[R][C];
        int[][] arrAnswer = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                arrStart[i][j] = new ArrayList<Integer>();
                arrEnd[i][j] = new ArrayList<Integer>();
                arrAnswer[i][j] = 0;
            }
        }
        
        for(int i = 0; i < skill.length; i++){
            if(skill[i][0] == 1) {
                arrStart[skill[i][1]][skill[i][2]].add(skill[i][5] * skill[i][0] * (-1));
                arrEnd[skill[i][3]][skill[i][4]].add(skill[i][5] * skill[i][0] * (-1));
            }
            else if(skill[i][0] == 2){
                arrStart[skill[i][1]][skill[i][2]].add(skill[i][5] * skill[i][0]);
                arrEnd[skill[i][3]][skill[i][4]].add(skill[i][5] * skill[i][0]);
            }
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print("[");
                for(int k = 0; k < arrStart[i][j].size(); k++){
                    System.out.print(arrStart[i][j].get(k)+ " ");
                }
                System.out.print("] ");
            }
            System.out.println();
        }
        System.out.println("여기까지 plus");
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print("[");
                for(int k = 0; k < arrEnd[i][j].size(); k++){
                    System.out.print(arrEnd[i][j].get(k)+ " ");
                }
                System.out.print("] ");
            }
            System.out.println();
        }
        System.out.println("여기까지 minus");
        
        
        for(int i = 0; i < arrStart[0][0].size(); i++){
            arrAnswer[0][0] = arrStart[0][0].get(i);
        }
        for(int i = 1; i < R; i++){
            arrAnswer[i][0] = arrAnswer[i-1][0];
            for(int j = 0; j < arrStart[i][0].size(); j++){
                arrAnswer[i][0] += arrStart[i][0].get(j);
            }
            for(int j = 0; j < arrEnd[i-1][0].size(); j++){
                arrAnswer[i][0] -= arrEnd[i-1][0].get(j);
            }
        }
        for(int i = 1; i < C; i++){
            arrAnswer[0][i] = arrAnswer[0][i-1];
            for(int j = 0; j < arrStart[0][i].size(); j++){
                arrAnswer[0][i] += arrStart[0][i].get(j);
            }
            for(int j = 0; j < arrEnd[0][i-1].size(); j++){
                arrAnswer[0][i] -= arrEnd[0][i-1].get(j);
            }
        }
        
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(arrAnswer[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        
        for(int i = 1; i < R; i++){
            for(int j = 1; j < C; j++){
                arrAnswer[i][j] = arrAnswer[i-1][0] + arrAnswer[i][j-1] - arrAnswer[i-1][j-1];
                for(int k = 0; k < arrStart[i][j].size(); k++){
                    arrAnswer[i][j] += arrStart[i][j].get(k);
                }
                for(int k = 0; k < arrEnd[i-1][j].size(); k++){
                    arrAnswer[i][j] -= arrEnd[i-1][j].get(k);
                }
                for(int k = 0; k < arrEnd[i][j-1].size(); k++){
                    arrAnswer[i][j] -= arrEnd[i][j-1].get(k);
                }
            }
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(arrAnswer[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return answer;
        
    }
}
