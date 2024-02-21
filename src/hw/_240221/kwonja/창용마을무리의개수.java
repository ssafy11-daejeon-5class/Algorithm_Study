package hw._240221.kwonja;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 창용마을무리의개수 {
	
	static int n;
	static int m;
	static int ans;
	static boolean[] v;
	static List<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case =1;test_case<=T;test_case++)
		{
			st= new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			ans=0;
			//그래프 초기화
			graph = new LinkedList[n+1];
			v=new boolean[n+1];
			for(int i=0;i<n+1;i++)
			{
				graph[i]=new LinkedList<>();
			}
			for(int i=0;i<m;i++)
			{
				st=new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				graph[end].add(start);
			}
			for(int i=1;i<=n;i++)
			{
				if(!v[i])
				{
					ans++;
					v[i]=true;
					dfs(i);
				}
			}
			System.out.println("#" + test_case +" "+ ans);
		}

	}
	public static void dfs(int cur)
	{
		v[cur]=true;
		
		for(int i=0;i<graph[cur].size();i++)
		{
			if(!v[graph[cur].get(i)])
			{
				dfs(graph[cur].get(i));
			}
		}
	}

}
