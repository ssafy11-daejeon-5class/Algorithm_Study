package hw._240229.codingFestival;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나무재테크 {
	
	static int N, M, K;
	static int[][] A;
//	static Tree[] trees;
	static PriorityQueue<Tree>[][] queueMap;
	static int[][] yangbun;
	static int[][] nextYangbun;
	
	public static void main(String[] args) throws IOException{
		
		init();
		int Ans=0;
		
		for(int i = 0; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();

		}
		
		for(int r = 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				Ans += queueMap[r][c].size();
			
			}
		}
		
		System.out.println(Ans);
		
		
	}
	
	private static void winter() {

		for(int r = 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				yangbun[r][c] += A[r][c];
			}
		}
		
	}

	private static void autumn() {
		for(int r = 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				PriorityQueue<Tree> newQ = new PriorityQueue<>();
				while(!queueMap[r][c].isEmpty()) {
					Tree newTree = queueMap[r][c].poll();
					newQ.offer(newTree);
					if(newTree.age%5 != 0) continue;
					int[] nr = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
					int[] nc = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
					for(int i = 0 ; i < 8; i++) {
						int newR = newTree.r + nr[i];
						int newC = newTree.c + nc[i];
						if(newR < 0 || newC <0 || newR >=N || newC>=N) continue;
						queueMap[newR][newC].offer(new Tree(newR,newC, 1));
					}
					
				}
				queueMap[r][c] = newQ;
			}
		}
		
	}

	private static void summer() {
		for(int r = 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				yangbun[r][c] += nextYangbun[r][c];
			}
		}
		
	}

	private static void spring() {

		nextYangbun = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				PriorityQueue<Tree> newQ = new PriorityQueue<>();
			
				while(!queueMap[r][c].isEmpty()) {
					Tree newTree = queueMap[r][c].poll();
					if(yangbun[newTree.r][newTree.c] >= newTree.age) {
						yangbun[newTree.r][newTree.c] -= newTree.age;
						newTree.age += 1;
						newQ.offer(newTree);
					}
					else {
						nextYangbun[newTree.r][newTree.c] += newTree.age/2;
					}
				}
				queueMap[r][c] = newQ;
			}
		}
		
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queueMap = new PriorityQueue[N][N];
		for(int i = 0; i < N; i++) {
			queueMap[i] = new PriorityQueue[N];
			for(int j = 0; j < N; j++) {
				queueMap[i][j] = new PriorityQueue<>();
			}
		}
	
		A = new int[N][N];
		yangbun = new int[N][N];
		nextYangbun = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				yangbun[i][j] = 5;
			}
		}
		
//		trees = new Tree[M];
		for(int i=0 ;i <M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
//			trees[i] = new Tree(x, y, z);
			
			queueMap[x][y].offer(new Tree(x, y, z));
		}
	}
	
	public static class Tree implements Comparable<Tree>{
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

}
