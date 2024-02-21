/* 서로소 집합으로 해보고싶은데 잘 안됨
 * 
 * 서로 다른 사람 5명으로 구성된 친구 짝 4개가 나와야함

한 정점에 딱 1번만 방문할 수 있음 (무조건 첫번째 요소?)

 * */
package hw._240221.hyeona;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_ABCDE {

	static int N, M, Ans, flag;
	static List<Integer>[] list;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		v = new boolean[N];
		flag=0;
		
		for(int i=0; i<N; i++)
		{
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		
		for(int i=0; i<N; i++)
		{
			v = new boolean[N];
			if(!v[i])
			{
				flag=0;
				Ans=1;
				v[i] = true;
				dfs(i);
				// System.out.println(Ans);
				
				if(Ans>=5)
				{
					break;
				}
			}
		}
		
		
		if(Ans>=5) System.out.println(1);
		else System.out.println(0);
		
		
	}

	private static boolean dfs(int x) {
		
		
		if(Ans>=5)
		{
			return true;
		}
		
		// 정점을 2번 이상 방문하면 안됨
		if(!v[list[x].get(0)])
		{
			Ans++;
			if(dfs(list[x].get(0))){
				return true;
			}
		}
		
		return false;

//		for(int i=0; i<list[x].size(); i++)
//		{
//			// 재귀로 한번에 들어가야함
//			if(!v[list[x].get(i)])
//			{
//				flag=1;
//				v[list[x].get(i)]= true;
//				Ans++;
//				if(dfs(list[x].get(i))) return true;
//				
////				if(Math.abs(x-list[x].get(i))==1)
////				{
////					if(dfs(list[x].get(i))) return true;
////				}
//			}
//		}
		
		
//		if(flag==0)
//		{
//			return true;
//		}
//		
//		return false;
		
	}

}
