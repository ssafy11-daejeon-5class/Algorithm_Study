package study._240307.junsu;

public class 양과늑대 {
    class Solution {
        boolean[] v;
        int Ans;
        
        public void dfs(int sheep, int wolf, int[] info, int[][] edges){
            if(sheep <= wolf){
                return;
            }
            else{
                Ans = Math.max(Ans, sheep);
                for(int[] edge : edges){
                    if(v[edge[0]] && ! v[edge[1]]){
                        if(info[edge[1]] == 1){
                            v[edge[1]] = true;
                            dfs(sheep, wolf + 1, info, edges);
                            v[edge[1]] = false;
                        } else {
                            v[edge[1]] = true;
                            dfs(sheep + 1, wolf, info, edges);
                            v[edge[1]] = false;
                        }
                    }
                }
            }
        }
        
        public int solution(int[] info, int[][] edges) {
            v = new boolean[info.length];
            v[0] = true;
            dfs(1,0, info, edges);
            return Ans;
        }
    } 
}
