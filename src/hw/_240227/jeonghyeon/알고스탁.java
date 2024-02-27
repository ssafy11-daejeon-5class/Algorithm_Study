package hw._240227.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 알고스탁 {
	static int initialMoney, Ms, Ma, N, L;
	static int[][] chart;
	static List<Stock> stockList;
	static int maxAsset;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			getInput();

			for (int l = 0; l < L; l++) {
				monthlyInvest(l);
			}

			int answer = Ms - initialMoney - Ma * L;
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	private static void getInput() throws Exception {
		st = new StringTokenizer(br.readLine());
		initialMoney = Integer.parseInt(st.nextToken());
		Ms = initialMoney;
		Ma = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		chart = new int[N][L + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < L + 1; j++) {
				chart[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void monthlyInvest(int l) {

		stockList = new ArrayList<>(); // 수익률이 +인 주식들을 담음
		for (int i = 0; i < N; i++) {
			if (chart[i][l + 1] > chart[i][l])
				stockList.add(new Stock(chart[i][l], chart[i][l + 1] - chart[i][l]));
		}
		stockList.sort(null); // 주식의 수익률 순으로 정렬

		maxAsset = Ms;
		if (!stockList.isEmpty())
			findBestCombination(0, maxAsset, maxAsset);
		Ms = maxAsset + Ma;
	}

	private static void findBestCombination(int stockIdx, int leftCash, int asset) {
		if (stockIdx == stockList.size()) { // 마지막 주식까지 다 조합해본 경우 종료
			return;
		}

		// 주식별 수익률
		double revenueRateOfStock = (double) stockList.get(stockIdx).revenue / stockList.get(stockIdx).price;
		if (asset + leftCash * revenueRateOfStock < maxAsset) {
			// 남은 금액으로 더 나은 수익을 낼 방법이 없는 경우 종료
			return;
		}

		int maxBuyCnt = leftCash / stockList.get(stockIdx).price; // 주식의 최대 구매 가능 개수
		for (int i = maxBuyCnt; i >= 0; i--) { // 최대로 구매하는 경우부터 0개 구매까지 반복
			int newAsset = asset + stockList.get(stockIdx).revenue * i; // i개를 구매했을 때의 자산(주식+현금)
			int newleftCash = leftCash - stockList.get(stockIdx).price * i; // i개를 구매했을 때 남은 현금
			if (newAsset > maxAsset) { // 지금까지 가장 높았던 자산보다 현재가 더 높으면 업데이트
				maxAsset = newAsset;
			}
			findBestCombination(stockIdx + 1, newleftCash, newAsset); // 다음 주식을 사러감
		}
	}

	static class Stock implements Comparable<Stock> {
		int price, revenue;

		public Stock(int price, int revenue) {
			this.price = price;
			this.revenue = revenue;
		}

		@Override
		public int compareTo(Stock s) { // 주식의 수익률 순으로 정렬
			return Double.compare(((double) s.revenue / s.price), ((double) this.revenue / this.price));
		}
	}

}
