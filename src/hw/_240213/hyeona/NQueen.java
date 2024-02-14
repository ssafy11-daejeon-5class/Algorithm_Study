package hw._240213.hyeona;

import java.util.Scanner;

public class NQueen {

	
	static int N, Ans=0;
	static int[][] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		recursive(0,0);	
		System.out.println(Ans);
	}

	private static void recursive(int r, int c) {
		
		// basis part
		// 각 줄마다 퀸을 하나씩 놓았으면
		if(r==N)
		{
			Ans++;
			return ;
		}
		
		
		// inductive part
		for(int i=0; i<N; i++)
		{
			// 백트래킹
			if(check(r, i)) {
				map[r][i] = 1;
				recursive(r+1, i);
				map[r][i] = 0;
			}
			
			
		}
		
		
		
		
	}

	private static boolean check(int r, int c) {
		
		// 상
		for (int i = r-1; i >=0; i--) {
			if(map[i][c]==1) return false;
			
		}
		
		
		// 좌상
		for (int i = r, j = c;i >=0 && j>=0 ; i--, j--) {
			if(map[i][j]==1) return false;
		}
		
		// 우상
		for (int i = r, j = c;i>=0 && j<N ; i--, j++) {
			if(map[i][j]==1) return false;
		}
		
		// 좌 : 어차피 한칸에 하나만 놓으니까 할 필요 없음
		
		return true;
	}

}
