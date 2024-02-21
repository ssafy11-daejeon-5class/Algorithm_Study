package hw._240221.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 142 ms
public class SWEA_창용마을bfs {
	
	static int N,M;
	static List<Integer>[] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i=1; i<=T; i++)
		{
			int Ans=0;
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[N+1];
			v = new boolean[N+1];
			
			for(int x=0; x<N+1; x++)
			{
				arr[x] = new ArrayList<>();
			}
			
			for(int j=0; j<M; j++)
			{
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				arr[A].add(B);
				arr[B].add(A);
			}
			
			for(int x=1; x<=N; x++)
			{
				if(!v[x])
				{
					bfs(x);
					Ans++;	
				}
			}
			sb.append(Ans).append("\n");
			
		}
		System.out.print(sb);
	}
	private static void bfs(int x) {
		
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		v[x] = true;
		
		
		while(!queue.isEmpty())
		{
			x = queue.poll();
			for(int i=0; i<arr[x].size(); i++)
			{
				if(!v[arr[x].get(i)])
				{
					v[arr[x].get(i)] = true;
					queue.offer(arr[x].get(i));
				}
			}
		}

		
	}


}
