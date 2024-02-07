package hw._240206.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {

	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=10; i++)
		{
			int flag = 1;
			int N = Integer.parseInt(br.readLine());
			// 1~85
			for(int x=1; x<=N/2; x++)
			{
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String alpha1 = st.nextToken();
				
				// 이게 숫자면 플래그 1
				if(alpha1 != "-" || alpha1 != "+" || alpha1 != "*" || alpha1 != "/")
				{
					flag = 0;
				}
			}
			// 85~171
			for(int x=0; x<N/2; x++)
			{
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String alpha1 = st.nextToken();
				
				// 이게 숫자면 플래그 1
				if(alpha1 == "-" || alpha1 == "+" || alpha1 == "*" || alpha1 == "/")
				{
					flag = 0;
				}
			}
			
			sb.append("#").append(i).append(" ").append(flag).append("\n");
		}
		System.out.print(sb);
	}

}
