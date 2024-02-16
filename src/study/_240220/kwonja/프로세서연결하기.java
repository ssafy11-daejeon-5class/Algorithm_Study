package study._240220.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//링크드 리스트가 더 성능이 좋다
public class 프로세서연결하기 {

	/*
	 * SWEA 1767
	 * 
	 */
	static int n;
	static List<Pair> core = new ArrayList<>();
	static int[] sel;
	static int[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
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
						//코어 개수 세기
						core.add(new Pair(i,j));
					}
				}
			}
			sel = new int[core.size()];
			
		}
		//코어의 종류를 배열에 저장
		//선택한 코어를 관리할 배열
		//각 재귀를 통해 방문여부를 넘겨준다
	}
	
	public static void connect(int[][] v, int idx)
	{
		
		
		//4방향중 전선 연결하기
		for(int i=0;i<4;i++)
		{
			
		}
		//선택코드
		for(int i=0;i<core.size();i++)
		{
			if(sel[i]!=0)
			{
				sel[idx]=1;
				
				sel[idx]=0;				
			}
		}
		
		
	}

}
