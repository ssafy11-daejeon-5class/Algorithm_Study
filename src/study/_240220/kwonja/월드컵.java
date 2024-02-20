package study._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵 {
	/*
	 * 월드컵
	 * A,B,C,D,E,F
	 */
	
	static int[][] board= new int[6][3];
	static int[][][] cup = new int[6][3][4];
	static int [] res=new int[4];
	//0 :승
	//1 :무승부
	//2 :패
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int j=0;j<4;j++)
		{
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<6;i++)
			{
				cup[i][0][j]=Integer.parseInt(st.nextToken());
				cup[i][1][j]=Integer.parseInt(st.nextToken());
				cup[i][2][j]=Integer.parseInt(st.nextToken());
				if(cup[i][0][j]>5 || cup[i][1][j]>5 || cup[i][2][j]>5)
				{
					res[j]=2; //2를 불가능으로
				}
			}	
		}
		backtracking(0, 1, 0);
		for(int i=0;i<4;i++)
		{
			if(res[i]==2)res[i]=0;
			System.out.print(res[i]+ " ");
		}
		
	}
	
	
	public static void backtracking(int player, int idx, int maxcount)
	{
			for(int i=0;i<6;i++)
			{
				int sum=0;
				for(int j=0;j<3;j++)
				{
					if(board[i][j]>5)return;
					sum+=board[i][j];
					if(sum>5)return;
				}
			}
			if(maxcount==15) //모든 경기를 다 돌면 승패가 나옴
			{
				valid();
				return;
			}
			//한줄 끝나면
			if(idx==6)
			{
				player=player+1;
				idx=player+1;
			}
			
			//이겼을때
			board[player][0]++;
			board[idx][2]++;
			backtracking(player, idx+1, maxcount+1);
			board[player][0]--;
			board[idx][2]--;
			
			//비겼을때
			board[player][1]++;
			board[idx][1]++;
			backtracking(player, idx+1, maxcount+1);
			board[player][1]--;
			board[idx][1]--;
			
			//졌을때
			board[player][2]++;
			board[idx][0]++;
			backtracking(player, idx+1, maxcount+1);
			board[player][2]--;
			board[idx][0]--;
		
	}
	//중복으로 들어오면 그냥 나가버림
	public static void valid()
	{
		for(int i=0;i<4;i++)
		{
			if(res[i]!=2) //불가능이 아닐때
			{
				int count=0;
				for(int j=0;j<6;j++)
				{
					if(cup[j][0][i]==board[j][0] && cup[j][1][i]==board[j][1] && cup[j][2][i]==board[j][2])
					{
						count++;
					}
				}
				//함수로 return 하고싶었지만 그러면 중복일 경우 인식을 못함
				if(count==6)
				{
					res[i]=1;
				}
				
			}
		}
	}
}
