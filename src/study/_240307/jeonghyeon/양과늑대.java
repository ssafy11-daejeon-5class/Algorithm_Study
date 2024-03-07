package study._240307.jeonghyeon;

import java.util.*;
import java.io.*;

public class 양과늑대 {
	import java.util.*;

class Solution {
    Animal[] animals;
    boolean[] visited;
    int totalSheepCnt, totalWolfCnt;
    int nowMaxBenefitCnt;
    int nowMaxBenefitIdx;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        animals = new Animal[info.length];
        visited = new boolean[info.length];
        for(int i = 0; i < animals.length; i++){
            animals[i] = new Animal(info[i], i);
        }
        for(int i = 0; i < edges.length; i++){
            animals[edges[i][0]].children.add(animals[edges[i][1]]);
            animals[edges[i][1]].parent = animals[edges[i][0]];
        }
        
        
        totalSheepCnt += getRootSheeps(0);
        totalWolfCnt = 0;
        while(true){
            nowMaxBenefitCnt = Integer.MIN_VALUE;
            nowMaxBenefitIdx = -1;
            countAnimals(0);
            if(nowMaxBenefitIdx == -1){
                break;
            }
            getAnimals(nowMaxBenefitIdx);
            
            System.out.println(nowMaxBenefitIdx + " " + nowMaxBenefitCnt + " " + totalSheepCnt + " " + totalWolfCnt);
        }
        
            
        answer = totalSheepCnt;
        return answer;
    }
    
    public void getAnimals(int idx){
        if(visited[idx]) 
            return;
        
        visited[idx] = true;
        if(animals[idx].type == 0) {
            totalSheepCnt++;
        }
        else if(animals[idx].type == 1) {
            totalWolfCnt++;
        }
        
        getAnimals(animals[idx].parent.idx);
    }
    
    public void countAnimals(int idx){
        if(idx == 0){
            animals[idx].sheepCnt = 0;
            animals[idx].wolfCnt = 0;
        }
        else{
            animals[idx].sheepCnt = animals[idx].parent.sheepCnt;
            animals[idx].wolfCnt = animals[idx].parent.wolfCnt;
            if(!visited[idx]){
                if(animals[idx].type == 0) {
                    animals[idx].sheepCnt++;
                }
                else if(animals[idx].type == 1) {
                    animals[idx].wolfCnt++;
                }
                if(totalSheepCnt - totalWolfCnt <= animals[idx].wolfCnt - animals[idx].sheepCnt){
                // animals[idx].sheepCnt = -1;
                return;
            }
            
            if(animals[idx].sheepCnt - animals[idx].wolfCnt > nowMaxBenefitCnt 
               || (animals[idx].sheepCnt - animals[idx].wolfCnt == nowMaxBenefitCnt && animals[idx].sheepCnt > animals[nowMaxBenefitIdx].sheepCnt)){
                nowMaxBenefitCnt = animals[idx].sheepCnt - animals[idx].wolfCnt;
                nowMaxBenefitIdx = idx;
            }
            }
            
            
        }
        
        for(int i = 0; i < animals[idx].children.size(); i++){
            countAnimals(animals[idx].children.get(i).idx);
        }
        
        
        
        
        
    }

    // 새로운 방법
    // 먹을 수 있는 양을 다 먹음
    // 늑대를 먹고 먹어도 이득인 양들까지 다 먹음
    // 이제 안가본 모든 노드들을 이득/손해 계산
    // 
    
    public int getRootSheeps(int idx){
        int cnt = 0;
        if(animals[idx].type == 0 && !visited[idx]) {
            cnt++;
            visited[idx] = true;
            for(int i = 0; i < animals[idx].children.size(); i++){
                if(animals[idx].children.get(i).type == 0)
                    cnt += getRootSheeps(animals[idx].children.get(i).idx);
            }
        }
        return cnt;
    }
    
    static class Animal{
        public int type, idx;
        public int sheepCnt, wolfCnt;
        Animal parent;
        List<Animal> children;
        
        public Animal(int type, int idx){
            this.type = type;
            this.idx = idx;
            children = new ArrayList<>();
        }
    }
}
}
