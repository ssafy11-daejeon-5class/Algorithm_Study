package hw._240202.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	static int N;
	static Stack<Integer> stack;
	static int[] arr;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stack = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = arr[N-1];
		int cnt = 1;
		answer = new int[N];
		
		for(int i = N - 1 ; i >= 0 ; i--) {
			if(arr[i] >= max){
				while(!stack.isEmpty()) answer[stack.pop()] = i + 1;
				max = arr[i];
				stack.push(i);
			} else {
				stack.push(i);
			}
		}
		
		for(int i =0 ; i < N ; i++) {
			System.out.print(answer[i] + " ");
		}

	}

}
