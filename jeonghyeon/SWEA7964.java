import java.util.Scanner;

public class SWEA7964 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
		for(int t = 1; t <= T; t++) {
			
			int cityNum = sc.nextInt();
			int dist = sc.nextInt();
			int nowDist = 0;
			int cnt = 0;
			
			for(int i = 0; i < cityNum; i++) {
				if (sc.nextInt() == 1) {
					nowDist = 0;
				}
				else if (++nowDist == dist) {
					cnt++;
					nowDist = 0;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
			
		}
	}

}
