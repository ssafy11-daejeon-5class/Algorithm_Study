package study._240312.kwonja;
import java.util.*;
public class 단어변환 {
	class Solution {
	    
	    static class Point{
	        String word;
	        int cnt;
	        public Point(String word,int cnt)
	        {
	            this.word=word;
	            this.cnt=cnt;
	        }
	    }
	    static int Ans=0;
	    public int solution(String begin, String target, String[] words) {
	        bfs(begin,target,words);
	        return Ans;
	    }
	    
	    public static void bfs(String begin,String target,String[] words)
	    {
	        Queue<Point> q = new ArrayDeque<>();
	        int[] visited = new int[words.length];
	        q.offer(new Point(begin,0));
	        
	        while(!q.isEmpty())
	        {
	            Point p =q.poll();
	            String cur = p.word;
	            if(cur.equals(target))
	            {
	                Ans=p.cnt;
	                return;
	            }
	           
	            
	            for(int i=0;i<visited.length;i++)
	            {
	                if(visited[i]==1)continue;
	                int cnt=0;
	                for(int j=0;j<words[i].length();j++)
	                {
	                    if(cur.charAt(j) != words[i].charAt(j))cnt++;
	                }
	                if(cnt!=1)continue;
	                q.offer(new Point(words[i],p.cnt+1));
	                //방문했던 단어는 다신 방문하지않음 -> 최단거리이기 때문에
	                visited[i]=1;
	            }
	        }
	    }
	}

}
