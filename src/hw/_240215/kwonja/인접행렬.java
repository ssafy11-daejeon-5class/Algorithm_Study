package hw._240215.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 인접행렬 {
	
	static int [][] matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		matrix= new int[V+1][V+1];
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken()); //가중치는 일단 보류
			matrix[start][to]=1;
		}
		for(int i=0;i<=V;i++)
		{
			System.out.println( "[" + i +"] "  +Arrays.toString(matrix[i]));
		}
	}
}
