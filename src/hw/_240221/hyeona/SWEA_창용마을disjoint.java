package hw._240221.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 136ms
public class SWEA_창용마을disjoint {
	
	static int N,M;
	static int[] arr;
	static int[] height;
	

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

			arr = new int[N+1];
			height = new int[N+1];
			
			for(int x=1; x<=N; x++)
			{
				arr[x] = x;
			}
			
			for(int j=0; j<M; j++)
			{
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				union(A,B);
			}
			
			for(int x=1; x<=N; x++)
			{
				if(arr[x] == x)
				{
					Ans++;
				}
			}
			sb.append(Ans).append("\n");
			
		}
		System.out.print(sb);

	}


	private static void union(int a, int b) {
		
		// 대표자 뽑기
		a = find(a);
		b = find(b);
		
		// 대표자가 다르면
		if(a!=b)
		{
			// 키가 작은 애를 큰애 밑에 넣기
			if(height[a] < height[b])
			{
				arr[a] = b;
			}else
			{
				arr[b] = a;
				if(height[a] == height[b])
				{
					height[a]++;
				}
			}
			
		}
	
	}


	private static int find(int b) {
		
		if(arr[b] == b) return b;
		else {
			return arr[b] = find(arr[b]);
		}
	}


}
