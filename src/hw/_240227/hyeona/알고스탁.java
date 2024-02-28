package hw._240227.hyeona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;


public class 알고스탁 {
	
	
	static class Stock{
		
		int curPrice;
		int diff;

		public Stock(int curPrice, int diff) {
			super();
			this.curPrice = curPrice;
			this.diff = diff;
		}
		
		
	}

	// 예치금, 월별 불입금액
	static int Ms, Ma, N, L, monthMaxBenefit;
	static int[][] arr;
	static List<Stock> list;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++)
		{
			st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][L+1];
			int money = Ms;
			
			for(int x=0; x<N; x++)
			{
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<L+1; y++)
				{
					arr[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 매달 오르는 종목만 고려해보면 됨
			for(int month=0; month<L; month++)
			{
				for(int y=0; y<N; y++)
				{
					// 오르는 종목이라면
					if(arr[y][month] < arr[y][month+1])
					{
						list.add(new Stock(arr[y][month], arr[y][month+1]-arr[y][month]));
					}
				}
				
				// 매달 이익금
				monthMaxBenefit = 0;
				dfs(month, money, 0);
				money += monthMaxBenefit;
				money += Ma;
				
			}
			
		}
		
		

	}
	private static void dfs(int index, int curMoney, int addMoney) {
		
		// addMoney가 최대가 되어야함. 그때의 curMoney도 필요
		if(index == list.size())
		{
			monthMaxBenefit = Math.max(addMoney, monthMaxBenefit);
			return;
		}
		
		
		
		// 현재 살 수 있는 주식보다 내가 가진 돈이 더 많으면
		if(curMoney >= list.get(index).curPrice)
		{
			// 하나씩 매수
			dfs(index, curMoney - list.get(index).curPrice, addMoney + list.get(index).diff);
		}else // 현재 종목을 살 수 없다면 다음 종목으로 넘기기
		{
			dfs(index+1, curMoney, addMoney);
		}
		
	}

}

