package hw._240213.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int Ans;
	static int[] sel,kku;
	static boolean[] visited;
	static List<Integer> inn;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=T; i++)
		{
			Ans=0;
			st = new StringTokenizer(br.readLine());
			kku = new int[9];
			sel = new int[9];
			visited = new boolean[9];
			
			inn = new ArrayList<>();
			
			for(int k=0; k<9; k++)
			{
				kku[k] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int k=1; k<=18; k++)
			{
				int flag=0;
				for(int x=0; x<9; x++)
				{
					if(kku[x] ==k) 
					{
						flag=1;
						break;
					}
				}
				if(flag==0) inn.add(k);
			}
			
			// System.out.println(inn);
			
			// 인영이가 낼 수 있는 모든 경우의 수 구하기
			permutation(0);
			sb.append("#").append(i).append(" ").append(Ans).append(" ").append(362880-Ans).append("\n");
			
		}
		System.out.print(sb);
		

	}

	private static void permutation(int index) throws IOException {
		
		
		if(index==9)
		{
			//System.out.println(Arrays.toString(sel));
			//br.readLine();
			judge_winner();
			return;
		}
		
		
		for(int i=0; i<9; i++)
		{
			if(!visited[i])
			{
				sel[index] = inn.get(i);
				visited[i]=true;
				permutation(index+1);
				visited[i]=false;
			}
		}
		

		
	}

	private static void judge_winner() {
		
		
		int K =0;
		int I =0;
		for(int i=0; i<9; i++)
		{
			if(sel[i]>kku[i])
			{
				I += (sel[i]+kku[i]);
			}
			else
			{
				K +=(sel[i]+kku[i]);
			}
			
		}
		
		if(K>I) Ans+=1;
		
	}

}
