package study._240312.kwonja;
import java.util.*;

public class 최고의집합_시간초과 {
	class Solution {
	    
	    static int[] answer;
	    static int Ans=Integer.MIN_VALUE;
	    static int[] err = {-1};
	    public int[] solution(int n, int s) {
	        
	        combi(1,0,s,n,new int[n],0,1);
	        if(Ans == Integer.MIN_VALUE) return err;
	        else return answer;
	    }
	    
	    
	    public static void combi(int idx, int k ,int s, int n, int[] sel, int sum ,int multi)
	    {
	        //basis part
	        //합이 s가 넘어가면
	        if(sum>s)
	        {  
	            return;
	        }
	        if(k==n)
	        {
	            if(sum==s)
	            {
	                if(Ans < multi)
	                {
	                    answer = Arrays.copyOf(sel,n);
	                    Ans=multi;
	                    return ;
	                }
	            }
	            return ;
	        }
	        
	        //inductive part
	        
	        //최대 s까지
	        for(int i=idx;i<=s;i++)
	        {
	              sel[k]=i;
	              combi(i,k+1,s,n,sel,sum+i,multi*i);       
	        }
	    }
	    
	}
}
