package study._240213.kwonja;
/*
 * 크로아티아 알파벳
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k=0;
		String str = st.nextToken();
		int i=0;
		while (i!=str.length()) {
			k++;
			if(str.charAt(i)=='=')
			{
				if(i>0 && str.charAt(i-1)=='c')k--;
				
				
				if(i>0 && str.charAt(i-1)=='z')
				{
					if(i>1 && str.charAt(i-1)=='z' && str.charAt(i-2)=='d')k=k-2;
					else k--;
				}
				if(i>0 && str.charAt(i-1)=='s')k--;
			}
			if(str.charAt(i)=='-')
			{
				if(i>0 && str.charAt(i-1)=='c')k--;
				if(i>0 && str.charAt(i-1)=='d')k--;
			}
			if(str.charAt(i)=='j')
			{
				if(i>0 && str.charAt(i-1)=='l')k--;
				if(i>0 && str.charAt(i-1)=='n')k--;
			}
			i++;
		}
		System.out.println(k);
	}
}
