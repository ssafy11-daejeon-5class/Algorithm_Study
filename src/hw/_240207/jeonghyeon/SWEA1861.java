package hw._240207.jeonghyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1861 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		PriorityQueue<Room> queue = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					queue.offer(new Room(i, j, Integer.parseInt(st.nextToken())));
				}
			}

			Room prevRoom = queue.poll();
			int cnt = 1;
			int maxCnt = 1;
			int bestStartNum = 1;
			int nowStartNum = 1;

			while (!queue.isEmpty()) {
				Room newRoom = queue.poll();
				int distance = Math.abs(newRoom.x - prevRoom.x) + Math.abs(newRoom.y - prevRoom.y);
				if (distance == 1) {
					if (++cnt > maxCnt) {
						maxCnt = cnt;
						bestStartNum = nowStartNum;
					}
				} else {
					cnt = 1;
					nowStartNum = newRoom.num;
				}
				prevRoom = newRoom;
			}

			System.out.println("#" + t + " " + bestStartNum + " " + maxCnt);
		}
	}
}

class Room {
	public int x;
	public int y;
	public int num;

	public Room(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}

}
