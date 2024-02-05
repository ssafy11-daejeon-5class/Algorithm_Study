package study._240205.sungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 * SWEA 줄기 세포 배양
 */
public class SWEA_5563 {
	
	
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int[][] board = new int[350][350];
	static int[][] visitied = new int[350][350];
	static int timer;
	static Queue<Ceil> q = new LinkedList<>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
		}
	}
}


class Ceil{
	private int x;
	private int y;
	private int time;
}

