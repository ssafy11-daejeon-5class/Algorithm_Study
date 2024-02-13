package hw._240213.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
	
	/*
	 * 규영이와 인영이의 카드게임
	 * 카드게임조져~
	 * 
	 */
	static int T;
	static int[] num = new int[19];
	static int[] player1=new int[9]; //규영
	static int[] player2=new int[9]; //인영
	static int[] visitied = new int[9];
	static int win,lose;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		T=Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			player1=new int[9]; //규영
			player2=new int[9];
			visitied = new int[9];
			num = new int[19];
			win=lose=0;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++)
			{
				player1[i]=Integer.parseInt(st.nextToken());
				num[player1[i]]++;
			}
			int k=0;
			//인영이 카드 세팅
			for(int i=1;i<=18;i++)
			{
				if(num[i]==0)
				{
					player2[k]=i;
					k++;
				}
			}
			Permuation(0, 0, 0);
			System.out.println("#" + test_case +" "+ win + " "+lose);
		}

	}
	public static void Permuation(int idx,int player1score,int player2score)
	{
		//basis
		//마지막 라운드를 돌았을때
		if(idx==9)
		{
			if(player1score>player2score)win++;
			else if(player1score<player2score)lose++;
			return;
		}
		
		//inductive
		for(int i=0;i<9;i++)
		{
			if(visitied[i]==0)
			{
				visitied[i]=1;
				//라운드비교
				if(round(idx,i)==1)
				{
					Permuation(idx+1,player1score+player1[idx]+player2[i],player2score);					
				}
				else if(round(idx,i)==2)
				{
					Permuation(idx+1,player1score,player2score+player1[idx]+player2[i]);
				}else //무승부
				{
					Permuation(idx+1,player1score,player2score);
				}
				visitied[i]=0;
			}
		}
	}
	public static int round(int idx, int i)
	{
		if(player1[idx]>player2[i]) //규영이 승리
		{
			return 1;
		}
		else if(player1[idx] == player2[i]) //무승부
		{
			return 0;
		}else //인영이 승리
		{
			return 2;
		}
	}

}
