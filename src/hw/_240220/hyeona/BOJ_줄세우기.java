package hw._240220.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬 (선수 과목)
/*
 * 진입차수를 가지는 inDegree 배열 (각 정점의 진입 차수를 관리)
 * ex) A->B 순서로 있어야하면 B의 진입차수를 더해주기
 * 
 * 1. 진입 차수가 0인 정점들을 큐에 추가
 * 1-1. poll 
 * 2. 진입 차수가 0인 정점들과 연결된 모든 정점들의 진입 차수를 1씩 빼주기
 * 3. 진입 차수가 0인 정점을 발견하면 즉시 큐에 추가
 * 4. 큐가 빌 때 까지 계속
 * 
 * 이걸 하면 규칙에 맞게 순서대로 정렬할 수 있음
 * 진입 차수가 0이 되는 순서대로 줄 세우기
 * 
 * 내 앞에 아무도 올 수 없어야 내가 설 수 있음 (내 앞에 아무도 올 수 없다 ? 진입 차수가 0이다)
 * 
 * 
 * 
 * */



public class BOJ_줄세우기 {

	static int N, M;
	static List<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	static int[] inDegree;
	
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		inDegree = new int[N+1];
		
		for(int i=0; i<N+1; i++)
		{
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++)
		{
			// A가 앞에 선다
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			
			// 진입 차수 추가
			inDegree[B]++;
		}
		
		// 진입 차수가 0인 학생들을 큐에 추가
		for(int i=1; i<N+1; i++)
		{
			if(inDegree[i]==0)
			{
				queue.offer(i);
			}
		}
		
		bfs();
		
		System.out.print(sb);
		

	}
	
	private static void bfs() {
		
		
		while(!queue.isEmpty())
		{
			// 진입 차수가 0인걸 꺼내서 얘랑 연결된 애들의 차수를 빼주기
			int x = queue.poll();
			
			sb.append(x).append(" ");
			
			for(int i=0; i<list[x].size(); i++)
			{
				
				inDegree[list[x].get(i)]--;
				
				if(inDegree[list[x].get(i)]==0)
				{
					queue.offer(list[x].get(i));
				}

			}
			
		}
		
	}

}
