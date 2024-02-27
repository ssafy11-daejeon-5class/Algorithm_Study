package hw._240227.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 알고스탁 {
	static int Ans=Integer.MAX_VALUE;
	static int monthMaxBenefit;
	static int ms,ma,N,L;
	static int[][] data;
	/*
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		
		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ms= Integer.parseInt(st.nextToken()); //예치금
		ma= Integer.parseInt(st.nextToken()); // 월별 불입금액
		st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		L= Integer.parseInt(st.nextToken());
		data = new int[N][L+1];
		
		
		for(int test_case=1; test_case<=T;test_case++)
		{
			//월별 주식 가격 정보 입력
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<L+1;j++)
				{
					data[i][j]=Integer.parseInt(st.nextToken());
				}
			}
//			print();
			
			//매달 구입하는것
			int money=ms;
			for(int month=0; month<L;month++)
			{
				//주식 구매 리스트
				ArrayList<Stock> stockList = new ArrayList<>();
				for(int i=0;i<N;i++)
				{
					//다음달에 오를 주식을 리스트에 저장
					if(data[i][month] < data[i][month+1])
					{
						stockList.add(new Stock(data[i][month], data[i][month+1], data[i][month+1] -data[i][month]));
					}
				}
				monthMaxBenefit=0;
				//내 돈이 되는 만큼 주식을 구매하면 된다.
				//어떤주식을 얼마만큼 살까요
				recursive(0,money,stockList,0);
				
				
				// 매달 이익금
				money += (monthMaxBenefit + ma);
				
			}
			Ans = money - ms - ma*L;
			System.out.println("#" + test_case + " "+Ans);
		}
	}
	
	
	
	
	
	
	private static void recursive(int idx, int money, ArrayList<Stock> stockList, int benefit) {
		//basis part
		if(idx==stockList.size())
		{
			monthMaxBenefit = Math.max(monthMaxBenefit, benefit);
			return;
		}
		
		//inductive part
		
		//살 종목
		Stock stock = stockList.get(idx);
		
		if(money >=stock.curPrice)
		{
			//구매할 수 있다면
			recursive(idx, money - stock.curPrice, stockList, benefit + stock.diff);
		}
		//살만큼 샀다면 다음 종목으로
		recursive(idx+1, money, stockList, benefit);
		
	}






	public static void print()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<L+1;j++)
			{
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class Stock{
		int curPrice,nextPrice,diff;

		public Stock(int curPrice, int nextPrice, int diff) {
			super();
			this.curPrice = curPrice;
			this.nextPrice = nextPrice;
			this.diff =diff;
		}
		
		
	}

}
