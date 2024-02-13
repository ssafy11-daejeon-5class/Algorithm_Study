package hw._240213.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// 회의실을 최대한 많이 배정하려면, 빨리 끝나는 회의를 배치해야함 !
class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	
	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		return this.end != o.end ? this.end - o.end : this.start - o.start;
	}
	
	
	
}

public class BOJ_1931 {

	static Meeting[] meetings;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		meetings = new Meeting[N];
		List<Meeting> list = new ArrayList<>();
		
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meetings);
		list.add(meetings[0]);
		
		for(int i=1; i<N; i++)
		{
			if(list.get(list.size()-1).end <= meetings[i].start)
			{
				list.add(meetings[i]);
			}
		}
		System.out.println(list.size());
		

	}

}
