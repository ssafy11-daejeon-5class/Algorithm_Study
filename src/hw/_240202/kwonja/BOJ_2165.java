package hw._240202.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2165 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		for(int test_case=1;test_case<=10;test_case++)
		{
			int n = sc.nextInt();
			String str = sc.next();
			for(int i=0;i<n;i++)
			{
				char c =str.charAt(i);
				if(c=='[')
				{
					stack.push(c);
				}
				else if(c=='(')
				{
					stack.push(c);
				}
				else if(c=='{')
				{
					stack.push(c);
				}
				else if(c=='<')
				{
					stack.push(c);
				}
				
				//
				if(c==']')
				{
					stack.push(c);
				}
				else if(c==')')
				{
					stack.push(c);
				}
				else if(c=='}')
				{
					stack.push(c);
				}
				else if(c=='>')
				{
					stack.push(c);
				}
			}
		}
		
		
	}

}
