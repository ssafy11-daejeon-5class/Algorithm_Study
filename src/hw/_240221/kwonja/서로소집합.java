package hw._240221.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합 {
	/*
	 * SWEA_3289
	 * 0 : 두 집합을 합친다
	 * 1 : 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산
	 */
	static int n,m;
	static int[] sel;
	static int[] height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		for(int test_case=1;test_case<=T;test_case++)
		{
			System.out.print("#" + test_case +" ");
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			//인덱스 번호가 집합
			sel= new int[n+1];
			height= new int[n+1];
			make_set();
			m=Integer.parseInt(st.nextToken());
			for(int i=0;i<m;i++)
			{
				st=new StringTokenizer(br.readLine());
				//유니온 연산
				int num = Integer.parseInt(st.nextToken());
				int org = Integer.parseInt(st.nextToken());
				int change = Integer.parseInt(st.nextToken());
				union_set(org, change, num);
				
			}
			System.out.println();
		}

	}
	public static void make_set()
	{
		//make_set
		//각 집합의 대표자가 자기 자신이 되도록 설정한다.
		for(int i=0;i<n+1;i++)
		{
			sel[i]=i;
		}
		
	}
	public static void union_set(int org,int change,int num)
	{
		if(num==0)
		{
			int a =find_set(org);
			int b =find_set(change);
			
		if(a!=b)
		{
				if(height[a]<height[b])
				{
					sel[a]=b;
				}
				else
				{
					sel[b]=a;
					if(height[a]==height[b])
					{
						height[a]++;
					}
				}
		}
		}
		else
		{
			int a =find_set(org);
			int b =find_set(change);
			if(a!=b)
			{
				System.out.print(0);
			}
			else
			{
				System.out.print(1);
			}
		}
	}
	public static int find_set(int org)
	{
		//선택한 원소가 우두머리인지 확인
		if(sel[org]==org)return sel[org];
		else return sel[org] = find_set(sel[org]);
	}

}
