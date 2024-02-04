package study._240205.sungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	static int n;
	static Queue<Pair> q;
	static int[][] board;
	static int[][] dist;
	static int[] dx=new int[] {1,-1,0,0};
	static int[] dy=new int[] {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		int l= Integer.parseInt(st.nextToken());
		int r= Integer.parseInt(st.nextToken());
		
		board=new int[n][n];
		dist=new int[n][n];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//입력받기
		
	}

}



class Pair{
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
