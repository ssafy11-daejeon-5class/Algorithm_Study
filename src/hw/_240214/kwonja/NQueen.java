package hw._240214.kwonja;

import java.util.Iterator;
import java.util.Scanner;

public class NQueen {

	
	static int N,Ans;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		recursive(0,0);
		System.out.println(Ans);
	}
	private static void recursive(int r, int c) {
		//basis part
		if(r==N)
		{
			//r 의 값이 다 내려왔어요
			Ans++;
			return;
		}
		//inductive part
		for(int i=0;i<N;i++)
		{
			//backtracking
			//조건에 따라 재귀를 하는 가지를 없앤다 -> 가지치기 -> 이것을 벡트래킹이라고 한다.
		if(check(r,i))
		{
			map[r][i]=1;
			recursive(r+1, i);
			map[r][i]=0;
		}
		}
	}
	private static boolean check(int r, int c) {
		//상
		for (int i = r-1; i >=0; i--) {
			if(map[i][c]==1)return false;
		}
		//좌상
		for (int i = r,j=c; i >=0 && j>=0; i--,j--) {
			if(map[i][j]==1)return false;
		}
		//우상
		for (int i = r,j=c; i >=0 && j<N; i--,j++) {
			if(map[i][j]==1)return false;
		}
		//왼
		return true;
	}
	//특정한 조건을 만족하는 경우만 살펴보는 것 -> 가지치기

}
