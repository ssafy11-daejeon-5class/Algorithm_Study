package hw._240216.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int n,m,r;
	static int[][] board;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int[] sel= new int[3];
	
	//적 배치
	//궁수는 한 행에 3명이 랜덤으로 위치한다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		board = new int[n+1][m];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());

			}
		}
		
	}
	
	//적 제거
	public static void game(int[] sel)
	{
		
	}
	
	//조합으로 3명의 궁수를 선택하기
	public static void combination(int idx,int k, int[] sel,int round)
	{
		int[] newsel = Arrays.copyOf(sel, 3);
		if(k==3)
		{
			//3명의 궁수를 뽑음
			//적 제거
			game();
			return;
		}
		if(idx==m)
		{
			return;
		}
		
		//inductive part
		newsel[k]=idx; //어디 자리에 궁수가 배치되었는지 확인
		combination(idx+1, k+1,newsel,round); //뽑았을때
		combination(idx+1, k,sel,round); //뽑지 않았을때
	}
}
