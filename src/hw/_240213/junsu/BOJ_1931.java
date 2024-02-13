package hw._240213.junsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1931 { // 회의실 배정

	static class Meeting {
		int start, end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(meetings, (a,b) -> Integer.compare(a.end, b.end) == 0 ? Integer.compare(a.start, b.start) : Integer.compare(a.end, b.end));

		List<Meeting> list = new ArrayList<>();
		list.add(meetings[0]);

		for (int i = 1; i < N; i++) {
			if (list.get(list.size() - 1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		
		System.out.println(list.size());
	}

}
