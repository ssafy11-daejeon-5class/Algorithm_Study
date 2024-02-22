package hw._240221.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 창용마을_서로소집합 {
	/*
	 * 서로소집합 이용
	 */
	static int n;
	static int m;
	static int ans;
	static int[] set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case =1;test_case<=T;test_case++)
		{
			st= new StringTokenizer(br.readLine());
			n= Integer.parseInt(st.nextToken());
			m= Integer.parseInt(st.nextToken());
			ans=0;
			//그래프 초기화
			set =new int[n+1];
			make_set();
			for(int i=0;i<m;i++)
			{
				st=new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				union_set(start, end);
				
			}
//			print();
			
			
			System.out.println("#" + test_case +" "+ check());
		}

	}
	public static void make_set()
	{
		for(int i=1;i<=n;i++)
		{
			set[i]=i;
		}
	}
	public static void union_set(int org,int change)
	{
		int a =find_set(org);
		int b =find_set(change);
		
		if(a!=b)
		{
			set[a]=b;
		}
	}
	public static int find_set(int org)
	{
		if(org==set[org])return org;
		else return set[org]=find_set(set[org]);
	}
	public static void print()
	{
		System.out.println(Arrays.toString(set));
	}
	public static int check()
	{
		int count=0;
		for(int i=1;i<=n;i++)
		{
			if(set[i]==i)count++;
		}
		return count;
	}
	

}
