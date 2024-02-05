package study._240205.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
	
	static class Node {
		int i;
		int j;
		public Node(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

	static int N, L, R;
	static int[][] maps;
	static StringTokenizer st;
	static boolean[][] visited;
	static Queue<Node> list;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		maps = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move());

	}

	private static int move() {
		int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); //bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        if(list.size() > 1) {
                            changePopulation(sum); //열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
	}

	private static void changePopulation(int sum) {
		int avg = sum / list.size();
		while(!list.isEmpty()){
			Node temp = list.poll();
			maps[temp.i][temp.j] = avg;
		}
	}

	private static int bfs(int i, int j) {
		Queue<Node> q = new ArrayDeque<>();
		list = new ArrayDeque<>();

		q.offer(new Node(i,j));
		list.add(new Node(i, j));
		visited[i][j] = true;

		int sum = maps[i][j];
		while(!q.isEmpty()){
			Node current = q.poll();

			for(int k = 0 ; k < 4 ; k++){
				int ni = current.i + di[k];
				int nj = current.j + dj[k];

				if(ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]){
					int diff = Math.abs(maps[current.i][current.j] - maps[ni][nj]);
                    if(L <= diff && diff <= R) {
                        q.offer(new Node(ni, nj));
                        list.offer(new Node(ni, nj));
                        sum += maps[ni][nj];
                        visited[ni][nj] = true;
                    }     
				}
			}
		}
		return sum;
	}
}
