package study._240301.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스도쿠 {
	
	/*
	 * 빈칸을 찾고 1~9까지 넣을껀데 조건에 맞는지 확인
	 * 조건을 부합하면 다음 함수 시작
	 * 모든 빈칸을 확인하면 종료
	 */
	
	static class Pair{
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[][] board= new int[9][9];
	static List<Pair> blank = new ArrayList<>();
	static int flag=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		for(int i=0;i<9;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==0)blank.add(new Pair(i,j));
			}
		}
//		print();
		
		recursive(0);
	}
	
	public static void recursive(int idx)
	{
//		System.out.println(idx);
		if(flag ==1)return;
		if(idx==blank.size())
		{
			print();
			flag=1;
			return;
		}
		
		Pair p = blank.get(idx);
		int curx = p.x;
		int cury = p.y;
		
		//현재 빈칸에 들어갈 수 있는 숫자 찾기
		for(int i=1;i<=9;i++)
		{
			//만약 i가 들어 갈 수 있다면 map에 넣어주고 재귀
			if(check(curx,cury,i))
			{
				board[curx][cury]=i;
				recursive(idx+1);
				board[curx][cury]=0;
			}
		}
		
	}
	
	
	private static boolean check(int curx, int cury, int num) {
		
		//가로 탐색
		for(int i=0;i<9;i++)
		{
			if(board[curx][i]==num)return false;
		}
		
		//세로 탐색
		for(int i=0;i<9;i++)
		{
			if(board[i][cury]==num)return false;
		}
		
		//정사각형 탐색
		int rx = (curx/3) *3;
		int ry = (cury/3) *3;
		for(int i=rx; i<rx+3;i++)
		{
			for(int j=ry; j<ry+3;j++)
			{
				if(board[i][j]==num)return false;
			}
		}
		return true;
		
	}

	public static void print()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
	}

}
