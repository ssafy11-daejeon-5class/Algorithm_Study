package study._240207.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_2477 {

	/*
	 * 실버2 : 참외밭
	 * 2번 겹치는곳중에서 중간에 있는 면적을 빼야한다는 규칙을 찾았지만
	 * 
	 * 423131423131
	 */
	
	
	
	static Pair[] arr = new Pair[12];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int i=0;i<6;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			arr[i]=arr[i+6]= new Pair(x,y);
		}
		for(int i=3;i<12;i++)
		{
			if(arr[i].getX() == arr[i-2].getX() && arr[i-1].getX() == arr[i-3].getX())
			{
				int res=(arr[i].getY()+arr[i-2].getY())* 
				(arr[i-1].getY()+arr[i-3].getY()) - 
				arr[i-1].getY()*arr[i-2].getY();
				System.out.print(n*res);
				break;
			}
		}
	}
}
class Pair
{
	int x;
	int y;
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
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
