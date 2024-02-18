package hw._240216.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int n,m,d;
	static int[][] board;
	static int[][] copyboard;
	static PriorityQueue<Tuple> enemy;
	static int archorRow;
	static int ans=Integer.MIN_VALUE;
	static class Custom implements Comparator<Tuple>
	{

		@Override
		public int compare(Tuple o1, Tuple o2) {
			if(o1.dist == o2.dist)
			{
				return o1.y-o2.y;
			}
			return o1.dist-o2.dist; //거리가 짧은순
		}
		
	}
	//궁수 백트래킹
	
	//해당 궁수가 잡을 수 있는 적을 확인한다.
	//잡을 수 있는 적중에서 조건에 맞는 적을 잡는다.
	//각 궁수가 진행한다.
	//궁수는 동시에 쏘기때문에 중복해서 쏠수 있다.
	//이를 모든적이 격자판에서 제외되면 게임이 끝난다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		board = new int[n][m];
		copyboard = new int[n][];
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());

			}
		}
		combination(0, 0, new int[3]);
		System.out.println(ans);
	}
	
	public static int dist(int r,int c, int archorrow,int archorcol)
	{
		return Math.abs(r-archorrow)+Math.abs(c-archorcol);
	}
	// 적 제거
	public static int game(int[] sel)
	{
		int res=0;
		archorRow=n;
		while(archorRow>=1)
		{
			List<Tuple> kill= new ArrayList<>();
			//각 궁수에 대해서
			for(int i=0;i<sel.length;i++)
			{
				enemy = new PriorityQueue<Tuple>(new Custom());
				//해당 궁수가 잡을 적이 있는지 확인한다.
				//빠르게 코딩하기위해서 이중포문을 썻는데,
				//적이 적을경우는 리스트를 통해 돌아도 좋아보인다.
				//적이 없을때 리턴해주면 더 빨리 종료될듯?
				for(int j=0;j<archorRow;j++)
				{
					for(int h=0;h<m;h++)
					{
						//적을 발견하면
						if(copyboard[j][h]==1)
						{
							if(dist(j, h, archorRow, sel[i])<=d)
							{
								enemy.offer(new Tuple(j,h,dist(j, h, archorRow, sel[i])));						
							}
						}
					}
				}
				//중복이 없으면 죽이는 적을 담는다, 적이 없을때는 다음궁수 확인
				if(!enemy.isEmpty() && cmp(kill,enemy.peek()))
				{
					kill.add(enemy.peek());
				}
			}
			
			
			//적 죽이기
			res += kill.size();
			for(int i=0;i<kill.size();i++)
			{
				copyboard[kill.get(i).x][kill.get(i).y]=0;//보드판에 적 제거
			}
//			System.out.println(archorRow + " "+ Arrays.toString(sel));
//			print();
//			System.out.println(res);
			//다음게임진행
			archorRow--;
		}
		return res;
	}
	
	public static void BoardCopy()
	{
		for(int i=0;i<n;i++)
		{
			copyboard[i]=Arrays.copyOf(board[i], m);
		}
	}
	
	public static boolean cmp(List<Tuple> kill,Tuple temp)
	{
//		System.out.println(temp);
		for(int j=0;j<kill.size();j++)
		{
			if(kill.get(j).x ==temp.x && kill.get(j).y == temp.y)
			{
				return false;
			}
		}
		return true;
	}
	
	//조합으로 3명의 궁수를 선택하기
	public static void combination(int idx,int k, int[] sel)
	{
		if(k==3)
		{
			//3명의 궁수를 뽑음
			BoardCopy();
			ans = Math.max(ans,game(sel));
			return;
		}
		if(idx==m)
		{
			return;
		}
		//inductive part
		sel[k]=idx; //어디 자리에 궁수가 배치되었는지 확인
		combination(idx+1, k+1,sel); //뽑았을때
		combination(idx+1, k,sel); //뽑지 않았을때
	}
	public static void print()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(copyboard[i][j] +" ");
			}
			System.out.println();
		}
	}
}
class Tuple
{
	int x;
	int y;
	int dist;
	public Tuple(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	@Override
	public String toString() {
		return "Tuple [x=" + x + ", y=" + y + ", dist=" + dist + "]";
	}
	
}
