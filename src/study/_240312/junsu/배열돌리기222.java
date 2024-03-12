package study._240312.junsu;

import java.util.*;

class Solution {
    
    int[] answer = {};
    int[][] maps = {};
    int idx = 0;
    
    public int[][] rotate(int r, int c, int[] query){
        int[][] res = new int[r][c];
        for(int i = 0; i < r; i++){
            res[i] = Arrays.copyOf(maps[i], c);
        }
        int min = Integer.MAX_VALUE;
        
        for(int i = query[1]-1; i < query[3]-1; i++){
            res[query[0]-1][i+1] = maps[query[0]-1][i];
            if(maps[query[0]-1][i] < min){
                min = maps[query[0]-1][i];
            }
        }
        
        for(int i = query[3]-1; i > query[1]-1; i--){
            res[query[2]-1][i-1] = maps[query[2]-1][i];
            if(maps[query[2]-1][i] < min){
                min = maps[query[2]-1][i];
            }
        }
        
        for(int i = query[0]-1; i < query[2]-1; i++){
            res[i+1][query[3]-1] = maps[i][query[3]-1];
            if(maps[i][query[3]-1] < min){
                min = maps[i][query[3]-1];
            }
        }
        
        for(int i = query[2]-1; i > query[0]-1; i--){
            res[i-1][query[1]-1] = maps[i][query[1]-1];
            if(maps[i][query[1]-1] < min){
                min = maps[i][query[1]-1];
            }
        }
        answer[idx++] = min;
        return res;
    }
    
    public void print(int[][] arr){
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        maps = new int[rows][columns];
        
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                maps[i][j] = num++;
            }
        }
        
        answer = new int[queries.length];
        for(int[] query : queries){
            maps = rotate(rows, columns, query);
        }
        
        return answer;
    }
}