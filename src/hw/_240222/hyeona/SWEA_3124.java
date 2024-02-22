/* 최소 신장 트리 - 크루스칼 (간선 중심)
 * 
 * 1. 간선 리스트 만들기 (가중치 순으로 오름차순 정렬)
 * - 
 * 
 * 
 * 
 * */
package hw._240222.hyeona;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Kruscal implements Comparable<Kruscal>{
	int from;
	int to;
	int weight;
	
	
	public Kruscal(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Kruscal o) {
		return this.weight-o.weight;
	}

}


public class SWEA_3124 {
	
	static int T, V, E;
	static int[] boss;
	static Kruscal[] list; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++)
		{
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			
			boss = new int[V+1];
			
			
			sb.append("#").append(i).append(" ");
			E = Integer.parseInt(st.nextToken());
			list = new Kruscal[E];
			
			
			for(int k=1; k<=V; k++)
			{
				boss[k] = k; // 초기에 최종 보스는 나다
			}
			
			
			for(int j=0; j<E; j++)
			{
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				list[j] = new Kruscal(from, to, weight);
			}
			
			Arrays.sort(list);
			
			// System.out.println(list.get(0).weight);
			long sum=0;
			int cnt=0;
			
			for(Kruscal k : list)
			{
				if(union(k.from, k.to))
				{
					sum += k.weight;
					cnt++;
				}
				
				if(cnt == V-1) break;
			}
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.print(sb);

	}

	private static boolean union(int from, int to) {
		
		from = find(from);
		to = find(to);
		
		if(from !=to)
		{
			boss[from]=to;
			return true;
		}
		
		return false;

	}

	private static int find(int a) {
		
		if(boss[a] == a) return a;
		else return boss[a] = find(boss[a]);

	}

}
