package hw._240212.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699 {
/*
 * 수지의 수지 맞는 여행
 * 왜 DFS로 풀어야하는가?
 * DFS BFS를 사용해야할때가 갑자기 헷갈린다
 */
	
	static int r,c;
	static char[][] board;
	static int[][] visited;
	static int[] alpha;
	static int[] dx= {0,1,-1,0};
	static int[] dy= {1,0,0,-1};
	static int res = Integer.MIN_VALUE;
	static int k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			st = new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			board= new char[r][c];
			visited =new int[r][c];
			alpha= new int[26];
			res = Integer.MIN_VALUE;
			k=0;
			for(int i=0;i<r;i++)
			{
				st= new StringTokenizer(br.readLine());
				String str= st.nextToken();
				for(int j=0;j<c;j++)
				{
					board[i][j]=str.charAt(j);
				}
			}
			visited[0][0]=1;
			alpha[board[0][0]-'A']++;
			k++;
			dfs(0,0);
			System.out.println("#" + test_case + " "+res);
		}
	}
	private static void dfs(int curx, int cury) {
		res=Math.max(res, k);
		for(int i=0;i<4;i++)
		{
			int nx = curx+dx[i];
			int ny = cury+dy[i];
			if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
			if(alpha[board[nx][ny]-'A'] > 0 || visited[nx][ny]==1)continue;
			//여행
			alpha[board[nx][ny]-'A']++;
			visited[nx][ny]=1;
			k++;
			dfs(nx,ny);
			visited[nx][ny]=0;
		}
	}

}
