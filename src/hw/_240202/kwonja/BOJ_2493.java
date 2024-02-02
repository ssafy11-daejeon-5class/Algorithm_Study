package hw._240202.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		Stack<Pair> stack = new Stack<>();
		for(int i=1;i<=n;i++)
		{
			int n= Integer.parseInt(st.nextToken());
			while(!stack.isEmpty() && n>stack.peek().getX())
			{
				stack.pop();
			}
			if(stack.isEmpty())
			{
				System.out.print("0 ");
				stack.push(new Pair(n,i));
			}
			else if(!stack.isEmpty())
			{
				System.out.print(stack.peek().getY()+" ");
				stack.push(new Pair(n,i));
			}
		}
		
	}
}