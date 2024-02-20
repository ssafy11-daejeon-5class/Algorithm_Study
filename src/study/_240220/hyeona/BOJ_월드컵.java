package study._240220.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
 * 0 ~ 5 (총 6팀)
 * 각 팀 별 5경기 -> 총 경기 수 : 15 -> 승+무+패의 합은 30
 *  
*/


public class BOJ_월드컵 {

	
	
	static int[] A = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] B = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	
	static int[][] score;
	static int flag, game;
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<4; i++)
		{
			int sum=0;

			flag = 0;
			score = new int[6][3];
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<6; x++)
			{
				for(int y=0; y<3; y++)
				{
					score[x][y] = Integer.parseInt(st.nextToken());
					sum += score[x][y];
				}
			}
			
			if(sum <30) sb.append(0).append(" ");
			
			dfs(game);
			
//			if(dfs(game))
//			{
//				sb.append(1).append(" ");
//			}
//			else
//			{
//				sb.append(0).append(" ");
//			}
			// System.out.println(Arrays.deepToString(score));
			
			if(flag == 1) sb.append(1).append(" ");
			else sb.append(0).append(" ");
			
		}
		
		System.out.println(sb);

	}
	
	private static void dfs(int game) {
		
		if(game == 15)
		{
			flag = 1;
			return;
		}
			
			
		// A가 이기는 경우
		// 승, 무, 패
		if(score[A[game]][0] > 0 && score[B[game]][2] > 0)
		{
			score[A[game]][0]--;
			score[B[game]][2]--;

			dfs(game+1);
			// if(dfs(game+1)) return true;
			
			if(flag == 1)
			{
				return;
			}
			score[A[game]][0]++;
			score[B[game]][2]++;
		}
		
		
		// A가 지는 경우 - B가 이김
		if(score[A[game]][2] > 0 && score[B[game]][0] > 0)
		{
			score[A[game]][2]--;
			score[B[game]][0]--;
			//if(dfs(game+1)) return true;
			dfs(game+1);
			
			if(flag == 1)
			{
				return;
			}
			score[A[game]][2]++;
			score[B[game]][0]++;
			
		}
		
	
		// 무승부
		if(score[A[game]][1] > 0 && score[B[game]][1] > 0)
		{
			score[A[game]][1]--;
			score[B[game]][1]--;
			// if(dfs(game+1)) return true;
			dfs(game+1);
			
			if(flag == 1)
			{
				return;
			}
			score[A[game]][1]++;
			score[B[game]][1]++;
		}
		
		return;
		
		
	}

}
