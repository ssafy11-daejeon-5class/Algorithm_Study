package study._240312.junsu;

import java.util.*;

class Solution {
    
    boolean[][] maps;
    
    public boolean canChange(String word1, String word2){
        int n = word1.length();
        int cnt = 0;
        for(int i = 0 ; i < n; i++){
            if(word1.charAt(i) == word2.charAt(i)) continue;
            else cnt++;
        }
        if(cnt == 1) return true;
        else return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean canFlag = false;
        
        for(String word : words){
            if(target.equals(word)){
                canFlag = true; 
            }
        }
        
        if(canFlag){    // 바뀌는 단어가 단어 리스트에 있다. 즉 변환할 수 있다
            maps = new boolean[words.length][words.length];
            for(int i = 0; i < words.length ; i++){
                for(int j = 0; j < words.length; j++){
                    if(canChange(words[i], words[j])){
                        maps[i][j] = true;
                    }
                }
            }
            Queue<int []> q = new ArrayDeque<>();
            boolean[] v = new boolean[words.length];
            for(int i = 0; i < words.length; i++){
                if(canChange(begin, words[i])){
                    q.offer(new int[]{i, 1});
                    v[i] = true;
                }
            }
            
            while(!q.isEmpty()){
                int[] cur = q.poll();
                if(words[cur[0]].equals(target)){
                    return cur[1];
                }
                
                for(int i = 0; i < words.length; i++){
                    if(maps[cur[0]][i]){
                        q.offer(new int[]{i, cur[1] + 1});
                    }
                }
            }
            return answer;
        } else {
            return 0;    
        }
    }
}