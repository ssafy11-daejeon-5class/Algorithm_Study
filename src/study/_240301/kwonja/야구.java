package study._240301.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 야구 {
/*
 * 야구
 * 1번 선수는 4번 타자에 위치한다.
 */
	static int n;
	static int[][] board;
	static boolean[] visitied = new boolean[9];
	static int[] sel= new int[9];
	static int ans=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		n= Integer.parseInt(br.readLine());
		
		board= new int[n][9];
		//각 선수의 회차별 결과를 대입
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		sel[3]=0; //4번에 0번 타자 고정
		visitied[0]=true; //해당 타자를 사용했음
		permu(0);
		
		System.out.println(ans);
		
		
	}
	public static void permu(int idx)
	{
		//basis part
		//전부 뽑았을때
		if(idx==sel.length)
		{
			//게임을 시작한다.
			game();
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx==3)permu(idx+1);
		else
		{
			//inductive
			for(int i=0;i<9;i++)
			{
				if(!visitied[i])
				{
					visitied[i]=true;
					sel[idx]=i;
					permu(idx+1);
					visitied[i]=false;
				}
			}
		}
	}
	public static void game()
	{
		
		
		//경기를 n번 진행한다.
		//경기를 시작할때는 1번타자부터 진행한다.
		
		//1 : 안타
		//2 : 2루타
		//3 : 3루타
		//4 : 홈런
		//0 : 아웃
		
		int player=0; //타자
		int goal=0; ///득점
		
		
		for(int i=0;i<n;i++)
		{
			int outcount=0;
			int [] base= new int[9]; //회차가 바뀌면 베이스는 초기화됨
			Arrays.fill(base, 0); //-1은 베이스에 오르지 않은것
			while(outcount !=3) //3아웃이 안될때 까지
			{
				//해당 타자가 아웃일때
				if(board[i][sel[player]] ==0) //해당 플레이어 아웃
				{
					outcount++;
					
				}
				//해당 타자가 쳤을때
				else
				{
					//해당 타자는 이동
					base[sel[player]]=board[i][sel[player]];
					//베이스에 있는 사람들이 있다면 친 만큼 이동
					for(int j=0;j<9;j++)
					{
						if(base[j]!=0)
						{
							//처음 이동한 타자는 앞에서 이동시켰기때문에 기존 베이스에 있는 타자들만 이동시켜줘야함
							if(sel[player]!=j) base[j]+=board[i][sel[player]];
						}
						//득점!
						if(base[j]>=4)
						{
							goal++;
							base[j]=0; //해당 선수의 위치 초기화
						}
					}
				}
				player = (player+1)%9;
			}
		}
		ans = Math.max(ans,goal);
		
	}

}
