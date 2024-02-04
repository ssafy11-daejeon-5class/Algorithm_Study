package hw._240202.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * 괄호 짝짓기
 */
public class SWEA_1218 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack;
		for(int test_case=1;test_case<=10;test_case++)
		{
			stack = new Stack<>();
			int n = sc.nextInt();
			int check=0;
			String str = sc.next();
			for(int i=0;i<n;i++)
			{
				char c =str.charAt(i);
				
				//왼쪽괄호
				if(c=='[')
				{
					stack.push(c);continue;
				}
				else if(c=='(')
				{
					stack.push(c);continue;
				}
				else if(c=='{')
				{
					stack.push(c);continue;
				}
				else if(c=='<')
				{
					stack.push(c);continue;
				}
				
				// 오른쪽 괄호
				if(c==']')
				{
					if(stack.peek()=='[')
					{
						stack.pop();
					}else check=1;
				}
				else if(c ==')')
				{
					if(stack.peek()=='(')
					{
						stack.pop();
					}
					else check=1;
				}
				else if(c=='}')
				{
					if(stack.peek()=='{')
					{
						stack.pop();
					}
					else check=1;
				}
				else if(c=='>')
				{
					if(stack.peek()=='<')
					{
						stack.pop();
					}
					else check=1;
				}
				if(check==1)break;
			}
			if(check==1)
			{
				System.out.println("# "+test_case +" 0");
			}
			else
			{
				System.out.println("# "+test_case +" 1");
			}
			
		}
		
		
	}

}
