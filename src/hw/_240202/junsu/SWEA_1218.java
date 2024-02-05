package hw._240202.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {

	static int N, flag;
	static String str;
	static Stack<Character> s;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10 ; t++) {
			flag = 0;
			s = new Stack<>();
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			
			for(int i = 0 ; i < str.length() ; i++) {
				if(str.charAt(i) == ')' && s.peek() == '(') {
					s.pop();
				} else if (str.charAt(i) == '}' && s.peek() == '{') s.pop();
				else if (str.charAt(i) == '>' && s.peek() == '<') s.pop();
				else if (str.charAt(i) == ']' && s.peek() == '[') s.pop();
				else {
					s.push(str.charAt(i));
				}
			}
			
			if(s.isEmpty()) {
				System.out.println("#" + t + " 1");
			} else {
				System.out.println("#" + t + " 0");
			}
		}
	}

}
