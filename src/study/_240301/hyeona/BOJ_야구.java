/*
 * 가능한 모든 타선 뽑아서 다 경기 시켜보기
 * 1번 선수는 무조건 < 4번 타자 >
 * 
 * 
 * 
 * 
 * */

package study._240301.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_야구 {
	
	static class lotte{
		int score = 0;
		int out = 0;
		

		public lotte(int score, int out) {
			super();
			this.score = score;
			this.out = out;
		}
		
		
		
	}

	static int N, flag;
	static int[][] arr;
	static boolean[] v;
	static int[] sel;
	
	static boolean base1;
	static boolean base2;
	static boolean base3;
	
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][10];
		

		
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++)
			{
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		// 타순 만들기
		v = new boolean[10];
		sel = new int[10];
			
		v[4] = true;
		sel[4] = 1;
			
		permutation(2);
			
	
		System.out.println(max);
			
			
		

	}
	
	private static void permutation(int num) {
		
		
		if(num == 10)
		{
			//System.out.println(Arrays.toString(sel));
			int score = baseball_go();
			max = Math.max(score, max);
			return;
		}
		
		for(int i=1; i<=9; i++)
		{
			if(!v[i])
			{
				v[i] = true;
				sel[i] = num; 
				permutation(num+1);
				v[i] = false;
			}
			
			
		}
		
	}

	private static int baseball_go() {
		

		int score = 0;
		
		// 1번 타자 부터 시작
		int hitter = 1;
		
		
		// arr에는 0~8번 까지 선수의 기록이 담겨있음
		// sel에는 타순이 담겨있음 arr[sel[]] -> sel[]번 타자의 기록
		
		// 몇이닝, 몇번 타자
		for(int x=0; x<N; x++)
		{
			// 8번 타자에서 이닝이 끝났으면, 다음 이닝은 9번 타자부터
			base1=false;
			base2=false;
			base3=false;
			int out = 0;
			
			// i번 타자 - i번 타자는 누구 ? sel[i] 얘 arr[x][sel[i]]
			// int cnt = 0;
			while(true)
			{
				int record = arr[x][sel[hitter]];
				
				lotte L = attack(record, score, out);
				score = L.score;
				
				hitter = (hitter+1)%10;
				if(hitter == 0) hitter = 1;
				// 3아웃이면 다음 이닝으로
				if(L.out == 3) break;
				
				
				out = L.out;
				
				//System.out.println(x+ " " + hitter + " " + sel[hitter]+ " "+ record);
				//System.out.println("score: " + score);
				//System.out.println("out : " + out);
				//Scanner sc = new Scanner(System.in);
				//sc.nextInt();
				// cnt++;
				

			}

		}
		
		return score;
		
		
	}

	private static lotte attack(int record, int score, int out) {
		
		// 진루를 어떻게 구현할 것인가? 큐? nono.. 2루타 어떡할건데
		// 홈런치면 베이스에 있는 사람 + 나 까지 사람 수 만큼 득점

		
		// 안타[1], 2루타[2], 3루타[3], 홈런[4], 아웃[0]
		switch(record)
		{
			case 0:
				out++;
				break;
			case 1:
				score = hit(score);
				break;
			case 2:
				score =two_hit(score);
				break;
			case 3:
				score = three_hit(score);
				break;
			case 4:
				score = homerun(score);
				break;	
		}

		return new lotte(score, out);
		
	}

	
	private static int homerun(int score)
	{
		
		if(base1 && !base2 && !base3 || !base1 && base2 && !base3 || !base1 && !base2 && base3)
		{
			score++;
			
		}else if(base1 && base2 && !base3 || !base1 && base2 && base3 || base1 && !base2 && base3) // 2개
		{
			score+=2;
			
		}else if(base1 && base2 && base3) { // 만루홈런
			score+=3;
		}
		
		base1 = false;
		base2 = false;
		base3 = false;
		
		score+=1;
		
		return score;

		
	}

	private static int three_hit(int score) {
		
		// 3루타
		// 베이스가 비어있을 때 : 3루
		if((base1 && !base2 && !base3) || (!base1 && base2 && !base3) || (!base1 && !base2 && base3)) // 1루에만 사람이 있을 때 : 다 비우기 + 1득점
		{
			score++;
			
		}else if((base1 && base2 && !base3) || (!base1 && base2 && base3) || (base1 && !base2 && base3))
		{
			score+=2;
			
		}else if(base1 && base2 && base3)
		{
			score+=3;
		}
		
		base1 = false;
		base2 = false;
		base3 = true;
		
		return score;
		
		
	}

	private static int two_hit(int score) {
		
		// 2루타

		if(base1 && !base2 && !base3) // 1루에만 사람이 있을 때 : (2루, 3루)
		{
			base1 = false;
			base2 = true;
			base3= true;
			
		}else if(!base1 && base2 && !base3) // 2루 : (2루) + 1득점
		{
			score++;
			
		}else if(!base1 && !base2 && base3) // 3루 : (2루) + 1득점
		{
			base3 = false;
			score++;
			
		}else if(base1 && base2 && !base3) // 1루, 2루에만 사람이 있을 때 : (2루, 3루) + 1득점
		{
			base1 = false;
			base3 = true;
			score++;
			
		}else if(!base1 && base2 && base3) // 2, 3 : (2루) + 2득점
		{
			base3 = false;
			score+=2;
		}else if(base1 && !base2 && base3) // 1,3 : (2루, 3루) + 1득점
		{ 
			score++;
			base1 = false;
			
		}else if(base1 && base2 && base3) { // 1루, 2루, 3루 베이스가 다 차 있을 때 : (2루, 3루) + 2득점
			base1 = false;
			score+=2;
		}
		
		base2 = true;
		
		
		return score;
		
	}

	private static int hit(int score) {
		
		// 안타
		if(base1 && !base2 && !base3) // 1루에만 사람이 있을 때 : (1루, 2루)
		{
			base2 = true;
			
			
		}else if(!base1 && base2 && !base3) // 2루 : (1루, 3루)
		{
			base2 = false;
			base3 = true;
			
		}else if(!base1 && !base2 && base3) // 3루 : (1루) + 1득점
		{
			score++;
			base3 = false;
			
		}else if(base1 && base2 && !base3) // 1루, 2루에만 사람이 있을 때 : (1루, 2루, 3루)
		{
			base3 = true;
		}else if(!base1 && base2 && base3) // 2루, 3루 : (1루, 3루) + 1득점
		{
			base2 = false;
			base3 = true;
			score++;
		}else if(base1 && !base2 && base3) // 1루, 3루 : (1루, 2루) + 1득점
		{
			base2 = true;
			score++;
			base3 = false;
		}else if(base1 && base2 && base3) {
			score++;
		}
		
		base1 = true;
		
		
		return score;
		
	}


}
