package study._240307.kwonja;

import java.util.*;
public class 양과늑대 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    static int Maxsheet = Integer.MIN_VALUE;
	    static List<Integer>[] adjList;
	    static int[] visited;
	    public int solution(int[] info, int[][] edges) {
	        adjList = new ArrayList[info.length];
	        visited = new int[info.length];
	        //그래프 초기화
	        for(int i=0;i<info.length;i++)
	        {
	            adjList[i]= new ArrayList<>();
	        }
	        
	        for(int i=0;i<edges.length;i++)
	        {
	            int start = edges[i][0];
	            int end = edges[i][1];
	            adjList[start].add(end);
	            adjList[end].add(start);
	        }
	        
	        //초기 설정
	        visited[0]=1;
	        List<Integer> core = new ArrayList<>(); 
	        core.add(0);
	        recursive(1,0,core,info);
	        return Maxsheet;
	    }
	    
	    
	    public static void recursive(int sheet, int wolf,List<Integer> core,int[] info)
	    {
	        //basis part
	        if(sheet>Maxsheet)
	        {
	            Maxsheet = sheet; 
	        }
	        //inductive part
	        int size = core.size();
	        //갈수 있는곳 탐색!
	        for(int i=0; i<size;i++)
	        {
	            int node = core.get(i);
	            
	            for(int j=0;j<adjList[node].size();j++)
	            {
	                int next = adjList[node].get(j);
	                if(info[next]==1) //늑대일때
	                {
	                    if(sheet <= info[next]+wolf)continue; //양이 먹히면 가지 못함!
	                    if(visited[next]!=1) //방문하지 않았다면!
	                    {
	                        visited[next]=1;
	                        core.add(next);
	                        recursive(sheet,wolf+1,core,info);
	                        visited[next]=0;
	                        core.remove(core.indexOf(next));
	                        
	                    }
	                }
	                else //양일때
	                {
	                    if(visited[next]!=1) //방문하지 않았다면!
	                    {
	                        visited[next]=1;
	                        core.add(next);
	                        recursive(sheet+1,wolf,core,info);
	                        visited[next]=0;
	                        core.remove(core.indexOf(next));
	                    }
	                }
	            }
	            
	        }
	        
	    
	    }
	}
}
