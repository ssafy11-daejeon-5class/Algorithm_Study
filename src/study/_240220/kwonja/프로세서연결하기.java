package study._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//링크드 리스트가 더 성능이 좋다-> 그래프를 만들때
public class 프로세서연결하기 {

	/*
	 * SWEA 1767
	 * 
	 */
	static int n,Ans,maxCore;
	static List<Pair> core = new ArrayList<>();
	static int[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			core.clear();
			Ans=maxCore=0;
			n=Integer.parseInt(br.readLine());
			board = new int[n][n];
			for(int i=0;i<n;i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
					if(board[i][j]==1)
					{
						if(i==0 || j==0 || i==n-1 || j==n-1)continue; //벽에 붙어 있는 코어는 전선을 가질 필요가 없다.
						//코어 개수 세기
						core.add(new Pair(i,j));
					}
				}
			}
			connection(0, 0,0);
			System.out.println("#" + test_case + " "+Ans);
		}
		//전선이 전부 연결이 되지 않아도 된다. 그중에 최대값 전선을 깔수 있는 영역을 구하는것
		//코어를 전부 돌때까지 부분조합
		
		
	}
	public static void connection(int idx,int wireCnt,int coreCnt)
	{
		//basis part
		if(idx==core.size())
		{
			//최대한 많은 코어에 연결한 경우
			if(maxCore<=coreCnt)
			{
				if(maxCore==coreCnt)Ans=Math.min(wireCnt, Ans);
				else Ans=wireCnt;//코어의 개수가 많은 경우
				maxCore=coreCnt;
			}
			//코어가 적은 경우는 전선의 길이의 합이 필요 없음
			return;
		}
		//inductive part
		
		
		//해당 코어를 선택했을때
		Pair p = core.get(idx);
		int curx= p.x;
		int cury= p.y;
		
		
		//상 하 좌 우 탐색
		for(int i=0;i<4;i++)
		{
			int count=0;
			int nx=curx;
			int ny=cury;
			while(true)
			{
				nx+=dx[i];
				ny+=dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n) //벽에 도달해 전선을 설치
				{
					break;
				}
				if(board[nx][ny]==1 || board[nx][ny]==3)
				{
					count=0;
					break;
				}
	
				count++; //전선 탐색
				
			}
			int fillx=curx;
			int filly=cury;
			for(int j=0;j<count;j++)
			{
				fillx +=dx[i];
				filly +=dy[i];
				board[fillx][filly]=3; //전선은 3으로 깔자
			}
			if(count!=0)
			{
				connection(idx+1, wireCnt+count,coreCnt+1);				
			}
			else
			{
				//해당 코어를 선택하지 않았을때
				connection(idx+1, wireCnt,coreCnt);
			}
			fillx=curx;
			filly=cury;
			for(int j=0;j<count;j++)
			{
				fillx +=dx[i];
				filly +=dy[i];
				board[fillx][filly]=0; //깔았던 전선 초기화
			}
		}
		
	}

}
