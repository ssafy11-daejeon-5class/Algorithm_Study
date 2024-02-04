package hw._240202.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SWEA1218 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String gwalhos = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			int answer = 1;
			
			for(int i = 0; i < N; i++) {
				char newChar = gwalhos.charAt(i);
				List<Character> lefts = Arrays.asList('(', '{', '[', '<');
				List<Character> rights = Arrays.asList(')', '}', ']', '>');
				if(lefts.contains(newChar)) {
					stack.add(newChar);
				}
				else {
					int idx = rights.indexOf(newChar);
					if(lefts.indexOf(stack.peek()) == idx) {
						stack.pop();
					}
					else {
						answer = 0;
						break;
					}
				}
			}
			
			if(stack.size() == 0 && answer == 1) {
				System.out.println("#" + t + " 1");
			}
			else {
				System.out.println("#" + t + " 0");
			}
		}
	}

}
