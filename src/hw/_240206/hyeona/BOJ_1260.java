package hw._240206.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static List<List<Integer>> arr = new ArrayList<>();
	static boolean[] visited;
	static int N, M, V;
	static StringBuilder sb;
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+1; i++)
		{
			arr.add(new ArrayList<>());
		}
		
		sb = new StringBuilder();
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr.get(A).add(B);
			arr.get(B).add(A);
		}
		
		for(int i=1; i<arr.size(); i++)
		{
			Collections.sort(arr.get(i));
		}
		
		
		visited = new boolean[N+1];
		sb.append(V).append(" ");
		visited[V]=true;
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.print(sb);
		
		

	}
	
	public static void dfs(int V)
	{
		// inductive part
		for(int i=0; i<arr.get(V).size(); i++)
		{
			if(!visited[arr.get(V).get(i)])
			{
				visited[arr.get(V).get(i)] = true;
				sb.append(arr.get(V).get(i)).append(" ");
				dfs(arr.get(V).get(i));
			}
		}

	}
	
	
	
	public static void bfs(int V)
	{	
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(V);
		visited[V]=true;
		
		
		
		while(!queue.isEmpty())
		{
			int v = queue.poll();
			sb.append(v).append(" ");
			
			for(int i=0; i<arr.get(v).size(); i++)
			{
				if(!visited[arr.get(v).get(i)])
				{
					queue.offer(arr.get(v).get(i));
					visited[arr.get(v).get(i)]=true;
				}
			}
		}
		sb.append("\n");
		
	}

}
