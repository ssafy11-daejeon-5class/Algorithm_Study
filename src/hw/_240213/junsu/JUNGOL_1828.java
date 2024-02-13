package hw._240213.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class JUNGOL_1828 {	// 냉장고

	static class Temp{
		int start;
		int end;
		public Temp(int s, int e) {
			this.start = s;
			this.end = e;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Start: " + this.start +" End: " + this.end + "\n";
		}
	}
	static int N;
	static Temp[] ranges;
	static StringTokenizer st;
	static Stack<Temp> s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ranges = new Temp[N];
		s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ranges[i] = new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ranges, (a,b)-> Integer.compare(a.start, b.start) == 0 ? -Integer.compare(a.end, b.end) :Integer.compare(a.start, b.start));
		s.push(ranges[0]);
		for(int i = 1 ; i < N ; i++) {
			if(ranges[i].start > s.peek().end || ranges[i].end < s.peek().start) {
				s.push(ranges[i]);
			} else {
				Temp pop = s.pop();
				s.push(new Temp(Math.max(pop.start, ranges[i].start), Math.min(pop.end, ranges[i].end)));
			}
		}
		System.out.println(s.size());
	}

}
