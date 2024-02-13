package study._240213.kwonja;

import java.io.*;
import java.util.*;

public class BOJ_15686 {
	
	/*
	 * 치킨배달
	 * 치킨을 배달하자
	 */
	static int n,m;
	static List<Pair> chicken = new ArrayList<>();
	static Pair[] checked; //체크한 치킨수
	static List<Pair> home = new ArrayList<>();
	static int res=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		checked=new Pair[m];
		for(int i=0;i<n;i++)
		{	st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				int c=Integer.parseInt(st.nextToken());
				if(c==1)home.add(new Pair(i,j));
				if(c==2)chicken.add(new Pair(i,j));
			}
		}
		recursive(0, 0);
		System.out.println(res);
		
	}
	
	public static void recursive(int idx, int k)
	{
		
		if(k==m) //선택한 치킨집에 대해서
		{
			//집과 탐색
			res= Math.min(res,search());
			return; 
		}
		if(idx==chicken.size()) //개수미달
		{
			return;
		}
		//해당 치킨집을 선택했을때
		checked[k]=chicken.get(idx);
		recursive(idx+1, k+1);		
		//해당 치킨집을 선택하지 않았을대
		recursive(idx+1, k);
	}
	public static int search()
	{
			int sum=0;
			for(Pair p : home)
			{
				int dist=Integer.MAX_VALUE;
				for(int i=0;i<m;i++)
				{
					dist=Math.min(dist, Math.abs(p.getX()-checked[i].getX()) +Math.abs(p.getY()-checked[i].getY()));
				}
				//각 집에서 치킨집까지 거리중 가장 작은것들을 더해 모든 집의 치킨 거리를 구한다.
				sum+=dist;
			}
		return sum;
	}

}
