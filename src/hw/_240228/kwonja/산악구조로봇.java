package hw._240228.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 산악구조로봇 {
	/*
	 * 정점을 좌표로 관리
	 */
	
	static class Pair implements Comparable<Pair>{
		int x,y,weight;

		public Pair(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static int n;
	static int[][] minDistance;
	static boolean[][] visited;
	static int[][] board;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++)
		{
			n= Integer.parseInt(br.readLine());
			board= new int[n][n];
			minDistance = new int[n][n];
			visited = new boolean[n][n];
			pq=new PriorityQueue<>();
			for(int i=0;i<n;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//거리 초기화
			for(int i=0;i<n;i++)
			{
				Arrays.fill(minDistance[i], Integer.MAX_VALUE);
			}
			//여기서 탐색 시작
			bfs();
			print();
			System.out.println("#" + test_case + " " + minDistance[n-1][n-1]);
		} 
		

	}
	public static void bfs()
	{
		//초기설정
		minDistance[0][0]=0; //처음 서있는 곳은 0이다.
		pq.add(new Pair(0,0,0));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			if(p.x == n-1 && p.y ==n-1)break;
			if(visited[p.x][p.y])continue;
			visited[p.x][p.y]=true;
			
			int curx = p.x;
			int cury = p.y;
			for(int i=0;i<4;i++)
			{
				int nx = curx +dx[i];
				int ny = cury + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(visited[nx][ny])continue;
				//갈수 있을때
				int temp = board[nx][ny] - board[curx][cury];
				int weight=0;
				//연료 : 차이*2
				if(temp >0)
				{
					weight = temp*2;
				}
				else if (temp ==0)
				{
					weight=1;
				}
				else
				{
					weight=0;
				}
				if(minDistance[nx][ny] > minDistance[curx][cury] + weight)
				{
					minDistance[nx][ny] = minDistance[curx][cury] + weight;
					pq.offer(new Pair(nx,ny,minDistance[nx][ny]));
				}
			}
		}
	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(minDistance[i][j] + " ");
			}
			System.out.println();
		}
	}

}
