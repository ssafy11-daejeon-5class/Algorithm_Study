package study._240125.sungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine()," ");
		int p=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		
		int t=Integer.parseInt(br.readLine());
	
		
		p=p+t;
		q=q+t; //이코드가 47퍼
		
		p=p%(2*w);
		q=q%(2*h);
		
		if(p>w) p=2*w-p;
		if(q>h) q=2*h-q;
		
		
		System.out.println(p+" "+q); //printf로 바꾸니 성공
		//printf와 차이점
	}
}
