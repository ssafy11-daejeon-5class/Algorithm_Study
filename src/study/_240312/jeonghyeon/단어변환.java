package study._240312.jeonghyeon;

import java.util.*;

class 단어변환 {
    
    public String target;
    public String[] words;
    public boolean[] visited;
    public List<String> nowWords;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        nowWords = new ArrayList<String>();
        nowWords.add(begin);
        
        while(true){
            answer++;
            if(bfs(words)) break;
            if(nowWords.size() == 0){
                answer = 0;
                break;
            }
        }    
        
        return answer;
    }
    
    public boolean bfs(String[] words){
        
        List<String> nextList = new ArrayList<String>();
        for( int k = 0; k < nowWords.size(); k++){
            for(int i = 0; i < words.length; i++){
                if(visited[i]) 
                    continue;

                int diffCnt = 0;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[i].charAt(j) != nowWords.get(k).charAt(j)){
                        diffCnt++;
                    }
                    if(diffCnt >= 2) break;
                }
                
                if(diffCnt == 1){
                    if(words[i].equals(target)) return true;
                    visited[i] = true;
                    nextList.add(words[i]);
                }
            }
        }
        
        nowWords = nextList;
        return false;
        
    }
}