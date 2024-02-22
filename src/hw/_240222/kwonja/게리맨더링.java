package hw._240222.kwonja;


import java.io.*;
import java.util.*;

public class 게리맨더링 {
	
	static int n;
	static int m;
	static int ans=Integer.MAX_VALUE;
	static boolean[] v;
	static List<Integer>[] graph;
	static int [] weight;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		n = Integer.parseInt(br.readLine());
		
		weight=new int[n+1];
		graph = new LinkedList[n+1];
		v=new boolean[n+1];
		for(int i=0;i<n+1;i++)
		{
			graph[i]=new LinkedList<>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++)
		{
			weight[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++)
			{
				int to = Integer.parseInt(st.nextToken());
				if(graph[i+1].contains(to))continue; //중복제거
				graph[i+1].add(to); //연결된 간선 넣기
				graph[to].add(i+1); //연결된 간선 넣기
			}
		}
//		System.out.println(Arrays.toString(graph));
		
		for(int i=1;i<=n/2;i++)
		{
			combination(1, 0,new int[i]);			
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}
	public static void dfs(int cur, int [] a)
	{
			v[cur]=true;
			
			for(int i=0;i<graph[cur].size();i++)
			{
				if(!v[graph[cur].get(i)] && a[graph[cur].get(i)]==1)
				{
					dfs(graph[cur].get(i), a);
				}
			}
	}
	public static void combination(int idx, int k, int[] sel)
	{
		if(k==sel.length)
		{
//			System.out.println(Arrays.toString(sel));
			//dfs로 뽑은 노드를 전부 방문할 수 있는가를 판단해야한다
			int a[] =new int[n+1];
			int nota[] = new int[n+1];
			for(int i=0;i<sel.length;i++)
			{
				a[sel[i]]=1;
			}
//			System.out.println("sel  : " + Arrays.toString(a));
			int flag=0;
			for(int i=1;i<=n;i++)
			{
				if(a[i]!=1)
				{
					flag=i;
					nota[i]=1;
				}
			}
//			System.out.println("nota : " + Arrays.toString(nota));
			//선택된 조합 집단 확인
			v=new boolean[n+1];
			dfs(sel[0],a);
			int suma=0;
			int sumb=0;
			if(equal(a))
			{
				for(int i=1;i<=n;i++)
				{
					if(a[i]==1)suma+=weight[i];
				}
			}
			//나머지 집단
			v=new boolean[n+1];
//			System.out.println("flag : "  + flag);
			dfs(flag,nota);
			if(equal(nota))
			{
				for(int i=1;i<=n;i++)
				{
					if(nota[i]==1)sumb+=weight[i];
				}
			}
			if(suma!=0 && sumb!=0)
			{
//				System.out.println(suma + " " + sumb);
				ans=Math.min(ans, Math.abs(suma-sumb));
			}
			return;
		}
		if(idx==n+1)return;
		
		sel[k]=idx;
		combination(idx+1, k+1,sel);
		combination(idx+1, k,sel);
		
	}
	public static boolean equal(int[] a)
	{
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(v));
		for(int i=1;i<=n;i++)
		{
			if(v[i] != (a[i]==1))return false;
		}
		return true;
	}

}
