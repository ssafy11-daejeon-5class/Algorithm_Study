// 같은 종교를 가진 사람들끼리 그룹 만들기
package hw._240221.hyeona;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_종교 {

	
	static int N,M;
	static int[] arr;
	static int[] height;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int Ans=0;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		height = new int[N+1];
		
		for(int i=1; i<=N; i++)
		{
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			union(A,B);
		}
		
		for(int i=1; i<=N; i++)
		{
			if(arr[i] == i) Ans++;
		}
		System.out.println(Ans);

	}

	private static void union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a !=b)
		{
			// 높이가 작은 트리를 큰 트리로 넣기
			if(height[a] < height[b])
			{
				// 작은 트리의 부모를 큰 트리로 설정
				arr[a] = b;
			}else
			{
				// b의 부모를 a로 
				arr[b] = a;
				if(height[a] == height[b])
				{
					// 트리를 받는 쪽의 높이를 증가
					height[a]++;
				}

			}
		}
		
	}

	private static int find(int b) {
		
		if(arr[b] == b) return b;
		else return arr[b] = find(arr[b]);

	}

}
