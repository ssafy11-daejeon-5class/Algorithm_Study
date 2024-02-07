package hw._240207.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17136 {
	// 색종이 붙이기
	static int[][] map = new int[10][10];
	
	public static void main(String[] args) throws IOException {
		init();
		
		print();
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i<10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void findStart() {
		L: for(int i=0 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				if(map[i][j] == 1) {
					break L;
				}
			}
		}
	}
	
	public static void recursive() {
		// basis part
		
		
		// inductive part
		
		
		
	}
	
	public static boolean checkOverwrite(int len, int x, int y, int[][] arr) {
		
		for(int i = x; i < x + len ; i++) {
			for(int j = y ; j < y + len ; j++) {
				if(arr[x][y] == 0) return false;
			}
		}
		
		return true;
	}
	
	public static void print() {
		
	}
	
	public static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
