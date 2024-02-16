package hw._240215.kwonja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class 인접리스트 {
	
	static List<List<Integer>> adjList = new ArrayList<>();
	//ArrayList<String>[] list_D1 = new ArrayList[3]; 정점이 정해져 있으면 미리 정점의 개수를 지정해줘도될듯
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=V;i++)
		{
			adjList.add(new ArrayList<Integer>());
		}
		for(int i=0;i<E;i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken()); //가중치는 일단 보류
			adjList.get(start).add(to);
		}
		for(int i=0;i<=V;i++)
		{
			System.out.println( "[" + i +"] " + adjList.get(i));
		}
	}
}
