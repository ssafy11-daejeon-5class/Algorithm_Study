/*
 * 서로소 집합 - 트리로 구현 
최적화 방법 )
	Rank(union) : 트리의 깊이를 관리해서 작은 트리를 큰 트리 밑으로 넣기
	경로 압축(find) : 대표자를 찾아가는 과정에서 만나는 모든 정점들의 부모를 최종 대표자로 초기화
	
1. make : 모든 정점이 스스로가 대표자인 형태로 집합 초기화
2. union(A,B) : 두 집합을 병합하기
	1) 두 집합의 대표자를 find로 구하기
	2) 두 집합의 대표자가 다르다면, 높이 비교해서 병합
	  - 대표자가 같으면 같은 집합에 속해있는 것 

*
*
*/
package hw._240221.hyeona;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_서로소집합 {

	static int N,M;
	static int[] arr;
	static int[] height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append("#").append(i).append(" ");
			
			arr = new int[N+1];
			height = new int[N+1];
			
			for(int x=1; x<=N; x++)
			{
				// make - 스스로를 대표자로 지정
				arr[x] = x;
			}
			
			for(int j=0; j<M; j++)
			{
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if(cal==0)
				{
					union(A,B);
				}else
				{
					if(find(A) == find(B))
					{
						sb.append(1);
					}
					else sb.append(0);
				}

			}
			
			sb.append("\n");
			
		}
		System.out.print(sb);

	}

	private static int find(int org) {
		
		// org의 대표자 찾기
		// 경로 압축
		if(arr[org] == org) return org;
		else {
			return arr[org] = find(arr[org]);
		}
			
	}

	private static void union(int a, int b) {
		
		// a 집합과 b 집합 대표자 찾기
		int x = find(a);
		int y  = find(b);
		
		// 대표자가 다르면 
		if(x!=y)
		{
			if(height[x] < height[y])
			{
				// 높이가 작은걸 큰쪽으로 넣어라
				arr[x] = y;
			}else { 
				arr[y] = x;
				// 같으면? 
				if(height[y] == height[x])
				{
					height[x]++; // 한쪽의 높이를 1 증가
				}
				
			}

		}

	}

}
