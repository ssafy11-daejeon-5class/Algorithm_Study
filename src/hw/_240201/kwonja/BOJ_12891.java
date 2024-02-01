package hw._240201.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
	static char[] str;
	static int[] check = new int[4];
	static int[] arr = new int[4];
	static int res=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		str = st.nextToken().toCharArray();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
		{
			check[i]=Integer.parseInt(st.nextToken());
		}
		//초기세팅
		for(int i=0;i<p;i++)
		{
			if(str[i]=='A')arr[0]++;
			if(str[i]=='C')arr[1]++;
			if(str[i]=='G')arr[2]++;
			if(str[i]=='T')arr[3]++;
		}
		res+=checkcount();
		int k=0;
		for(int i=0;i<s-p;i++)
		{
			
			if(str[i]=='A')arr[0]--;
			if(str[i]=='C')arr[1]--;
			if(str[i]=='G')arr[2]--;
			if(str[i]=='T')arr[3]--;
			
			if(str[p+i]=='A')arr[0]++;
			if(str[p+i]=='C')arr[1]++;
			if(str[p+i]=='G')arr[2]++;
			if(str[p+i]=='T')arr[3]++;
			res+=checkcount();
		}
		System.out.println(res);
		
	}
	public static int checkcount()
	{
		for(int i=0;i<4;i++)
		{
			if(check[i]>arr[i])return 0;
		}
		return 1;
	}

}