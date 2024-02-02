package hw._240202.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {

	static int N, flag;
	static String str;
	static Stack<String> s;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t < 2 ; t++) {
			flag = 0;
			s = new Stack<>();
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			
			for(int i = 0 ; i < str.length() ; i++) {
				if(str.charAt(i) == '<') s.push("<");
				if(str.charAt(i) == '{') s.push("{");
				if(str.charAt(i) == '(') s.push("(");
				else {
					if(s.isEmpty()) {
						flag = 1;
						break;
					} else {
						if(str.charAt(i) == ']' && s.peek() == "[") s.pop();
						if(str.charAt(i) == '}' && s.peek() == "{") s.pop();
						if(str.charAt(i) == ')' && s.peek() == "(") {
							System.out.println(s.pop());		
						}
					}
				}	
			}
			if(!s.isEmpty()) {
				System.out.println(s);
				flag = 1;
			}
			System.out.println("#" + t + " " + flag);
		}
	}

}
