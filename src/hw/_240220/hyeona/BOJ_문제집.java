/*
 * 
 * 4-2
 * 3-1
 * 
 * 
 * 
 * 
 * */
package hw._240220.hyeona;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_문제집 {

	
	static int N, M;
	static int[] inDegree;
	static boolean[] visited;
	static List<Integer>[] list;
	static Queue<Integer> queue = new LinkedList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		inDegree = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++)
		{
			list[i]= new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			inDegree[B]++;
			
		}
		
		for(int i=1; i<=N; i++)
		{
			Collections.sort(list[i]);
		}
	

		for(int i=1; i<=N; i++)
		{
			if(inDegree[i]==0)
			{
				queue.offer(i);
				visited[i] = true;
				break;
			}
		}
		
		bfs();
		System.out.print(sb);

	}

	private static void bfs() {
				
		while(!queue.isEmpty())
		{
			
			int current = queue.poll();
			sb.append(current).append(" ");
			
			for(int k=1; k<=N; k++)
			{
				if(inDegree[k]==0 && !visited[k])
				{
					queue.offer(k);
					visited[k] = true;
					break;
				}
			}
			
			// sb.append(current);
			
			for(int i=0; i<list[current].size(); i++)
			{
				inDegree[list[current].get(i)]--;
				
				
				if(inDegree[list[current].get(i)]==0)
				{
					visited[list[current].get(i)] = true;
					queue.offer(list[current].get(i));
					
				}
			}
			
			
			
		}

	}

}
