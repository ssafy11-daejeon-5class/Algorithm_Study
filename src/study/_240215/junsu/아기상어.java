package study._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

	static int N, answer, count;
	static StringTokenizer st;
	static int[][] maps;
	static int size = 2;
	static int[] di = new int[] { -1, 1, 0, 0 };
	static int[] dj = new int[] { 0, 0, -1, 1 };
	static int[] start;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		maps = new int[N][N];
		answer = 0;
		count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 9) {
                    maps[i][j] = 0;
					start = new int[] { i, j };
				}
			}
		}

        // bfs의 리턴 타입을 boolean으로 지정함. 먹을수 있는 물고기가 없을때 멈춘다.
		while(bfs(start)) {
			continue;
		}
		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean bfs(int[] s) {
		Queue<int[]> q = new ArrayDeque<>();
		v = new boolean[N][N];
		List<int[]> cand = new ArrayList<>();
		
		q.offer(new int[] {s[0], s[1], 1});
		v[s[0]][s[1]] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = cur[0] + di[k];
				int nj = cur[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
                    // 아기상어는 자기와 크기가 작거나 같은 물고기가 있는 칸과 물고기가 없는 칸만 지나갈 수 있다.
					if(maps[ni][nj] == 0 || maps[ni][nj] == size) {
						v[ni][nj] = true;
						q.offer(new int[] {ni, nj, cur[2] + 1});
					}
                    // 아기상어는 자기보다 크기가 작은 물고기를 먹을 수 있다. 먹을 수 있는 물고기는 cand 리스트에 추가한다.
					if(maps[ni][nj] < size && maps[ni][nj] != 0) {
						v[ni][nj]= true;
						cand.add(new int[] {ni, nj, cur[2]});
					}
				}
			}
		}
        // 먹을 수 있는 물고기가 있는 경우
		if(cand.size() != 0) {
            // 우선 거리가 가장 가까운 물고기 먼저. 만약 거리가 같다? 위쪽. 그거마저 같다? 가장 왼쪽 정렬해서 0번째 요소 활용
			cand.sort((a,b)-> a[2] == b[2]? a[0] == b[0]?Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]):Integer.compare(a[2], b[2]));
            count++;                            // 잡아먹은 물고기 수를 추가해준다.
            answer += cand.get(0)[2];     // answer에 이동하는데에 걸린 초를 더해준다.
			
            // 만약 잡아먹은 물고기가 현재 크기와 같으면 초기화해주고 물고기 크기 증가
            if(count == size) {
				count = 0;
				size++;
			}

            // 잡아먹은 물고기 있는 칸은 0으로 바꿔주고
			maps[cand.get(0)[0]][cand.get(0)[1]] = 0;

            // 다음 bfs 시작 좌표를 업데이트하고 true를 반환하여 bfs 메소드 종료
			start = new int[] {cand.get(0)[0], cand.get(0)[1]};
			return true;
		}
        // 후보인 물고기가 없는 경우에는 false를 반환함으로 while문을 멈출 수 있도록 한다.
		return false;
	}
}
