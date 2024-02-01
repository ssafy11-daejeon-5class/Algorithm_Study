package hw._240201.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String string = br.readLine();
		st = new StringTokenizer(br.readLine());
		int minA = Integer.parseInt(st.nextToken());
		int minC = Integer.parseInt(st.nextToken());
		int minG = Integer.parseInt(st.nextToken());
		int minT = Integer.parseInt(st.nextToken());

		int nowA = 0;
		int nowC = 0;
		int nowG = 0;
		int nowT = 0;
		int answer = 0;
		
		for(int i = 0; i < S; i++) {
			if (i-P >= 0) {
				if(string.charAt(i-P) == 'A')
					nowA--;
				else if(string.charAt(i-P) == 'C')
					nowC--;
				else if(string.charAt(i-P) == 'G')
					nowG--;
				else if(string.charAt(i-P) == 'T')
					nowT--;
			}
			if(string.charAt(i) == 'A')
				nowA++;
			else if(string.charAt(i) == 'C')
				nowC++;
			else if(string.charAt(i) == 'G')
				nowG++;
			else if(string.charAt(i) == 'T')
				nowT++;
			
			if(i + 1 >= P &&nowA >= minA && nowC >= minC && nowG >= minG && nowT >= minT) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
