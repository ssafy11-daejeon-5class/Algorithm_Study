package hw._240202.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//List<Integer> arr = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Stack<Pair> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			
			int prevIdx = -1;
			while(true) {
				if(stack.size() == 0) {
					stack.push(new Pair(nums[i], i));
					break;
				}
				if(stack.peek().getHeight() < nums[i]) {
					stack.pop();
				}
				else {
					prevIdx = stack.peek().getIdx();
					stack.push(new Pair(nums[i], i));
					break;
				}
				
			}
			if(prevIdx == -1) {
				sb.append("0 ");
			}
			else {
				sb.append(prevIdx + 1 + " ");
			}
		}
		System.out.println(sb.toString());
	}
	
	static class Pair {
	    private int height;
	    private int idx;

	    Pair(int height, int idx) {
	        this.idx = idx;
	        this.height = height;
	    }

	    public int getHeight(){
	        return height;
	    }

	    public int getIdx(){
	        return idx;
	    }
	}

}
