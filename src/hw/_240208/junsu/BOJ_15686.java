package hw._240208.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
	
	static class Node{
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int N, M;
	static int[][] maps;
	static List<Node> chickens;
	static List<Node> homes;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chickens = new ArrayList<>();
		homes = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					homes.add(new Node(i, j));
				} else if (temp == 2) {
					chickens.add(new Node(i,j));
				}
			}
		}
		
//		printArray();
		
		
		
	}

	private static void printArray() {
		// TODO Auto-generated method stub
		System.out.print("치킨집 좌표 : ");
		for (Node node : chickens) {
			System.out.print("["+node.i + ", " + node.j + "], ");
		}
		System.out.println();
		System.out.println("집 좌표 :" + homes);		
	}

}
