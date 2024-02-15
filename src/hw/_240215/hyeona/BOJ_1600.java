package algorithm.Algorithm_Study.src.hw._240215.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 원숭이는 (x,y)에 말 점프 or 상하좌우 이동으로 올 수 있음
// 말 점프를 다 채워서 온 경로, 그렇지 않은 경로

// 내가 취할 수 있는 액션 : 말 점프, 그냥 이동
// 말 점프를 해야할지 그냥 이동을 해야할지 ? 몰르

// H-1, W-1 도달하면 종료


// 말 점프를 K번 다 썼으면 상하좌우 이동만 할 수 있다 -> K번을 점프했는지 기록 필요

/* 습관적으로 visited 방문 검사 할 때 말 점프 횟수를 그대로 가져다 넣어서 계속 틀림
말 점프를 하러 메서드에 들어왔으니까 횟수를 증가시키고 방문 검사를 해야함
말 점프를 한칸 증가 시켜서 검사해야함. 생각을 하자.
* */

class Monkey{
	int x;
	int y;
	int horse_jump;
	int move;
	
	public Monkey(int x, int y, int horse_jump, int move) {
		super();
		this.x = x;
		this.y = y;
		this.horse_jump = horse_jump;
		this.move = move;
	}
}

public class BOJ_1600 {
	
	static int K, W, H, Ans, flag;
	static int[][] arr;
	static boolean[][][] visited;
	static Queue<Monkey> queue;
	
	static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int[] mx = {-1,1,0,0};
	static int[] my = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0,0,0);
		if(flag==1) System.out.println(Ans);
		else System.out.println(-1);
		
		

	}

	private static void bfs(int x, int y, int horse_jump, int move) {
		
		queue = new LinkedList<>();
		
		queue.offer(new Monkey(x, y, horse_jump, move));
		visited[x][y][horse_jump] = true;
		
		while(!queue.isEmpty())
		{
			Monkey m = queue.poll();
			
			if(m.x == H-1 && m.y == W-1)
			{
				flag=1;
				Ans = m.move;
				break;
			}
			
			go_monkey(m.x, m.y, m.horse_jump, m.move);
			go_horse(m.x, m.y, m.horse_jump, m.move);
			
		}
		
	}

	private static void go_horse(int x, int y, int horse_jump, int move) {
		
		if(horse_jump<K)
		{
			for(int i=0; i<8; i++)
			{
				int nx = x+hx[i];
				int ny = y+hy[i];


				if(nx>=0 && ny>=0 && nx<H && ny<W)
				{
					if(!visited[nx][ny][horse_jump+1] && arr[nx][ny]!=1)
					{
						visited[nx][ny][horse_jump+1] = true;
						queue.offer(new Monkey(nx, ny, horse_jump+1, move+1));
						Ans++;
					}
				}
			}
		}
	}

	private static void go_monkey(int x, int y, int horse_jump, int move) {
		
		for(int i=0; i<4; i++)
		{
			int nx = x+mx[i];
			int ny = y+my[i];
			
			
			if(nx>=0 && ny>=0 && nx<H && ny<W)
			{
				if(!visited[nx][ny][horse_jump] && arr[nx][ny]!=1)
				{
					visited[nx][ny][horse_jump] = true;
					queue.offer(new Monkey(nx, ny, horse_jump, move+1));
					Ans++;
				}
			}
			
		}
		
	}

}
