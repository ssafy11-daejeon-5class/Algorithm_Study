package hw._240205.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1228 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=1; i++)
		{
			LinkedList<String> arr = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++)
			{
				arr.add(st.nextToken());
			}
			
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<T; j++)
			{
				st.nextToken();
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				for(int k=0; k<Y; k++)
				{
					arr.add(X+k, st.nextToken());
				}

			}
			sb.append("#").append(i).append(" ");
			for(int k=0; k<10; k++)
			{
				sb.append(arr.get(k)).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
