package hw._240201.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	static int n;
	static Pair[] arr;
	static int res=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(br.readLine());
		arr= new Pair[n];
		for(int i=0;i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int bitter = Integer.parseInt(st.nextToken());
			int sour = Integer.parseInt(st.nextToken());
			arr[i]=new Pair(bitter,sour);
		}
		func1(0,0,1,0);
		System.out.print(res+"\n");
		
	}
	public static void func1(int idx,int k,int bitter,int sour)
	{
		if(k>0)
		{
			res=Math.min(res, Math.abs(bitter-sour));			
		}
		if(idx==arr.length)return;
		//inductive parts
		func1(idx+1,k+1,bitter*arr[idx].getX(),sour+arr[idx].getY());
		func1(idx+1,k,bitter,sour);
	}

}



class Pair
{
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
