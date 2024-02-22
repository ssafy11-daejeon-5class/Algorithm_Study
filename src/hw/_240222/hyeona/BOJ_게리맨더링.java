/*
 * N개를 두 그룹으로 나누기
 * 
 * N/2
 * 6개를 (1,5) (2,4) (3,3) 이런 가짓수 들로 2그룹을 만들 수 있음
 * 7개 (1,6) (2,5) (3,4)
 * 8개 (1,7) (2,6) (3,5) (4,4)
 * 9개 (1,8) (2,7) (3,6) (4,5)
 * 
 * 
 * 
 * 
 * */
package hw._240222.hyeona;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Election{
	
	// 두 그룹의 구역 가짓수
	int a;
	int b;
	
	public Election(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	
}

public class BOJ_게리맨더링 {
	
	static List<Election> cnt_list;
	static List<Integer>[] arr;

	static int N, Answer = Integer.MAX_VALUE;
	
	static int[] people;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		arr = new ArrayList[N+1];
		cnt_list = new ArrayList<>();
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++)
		{
			people[i] = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
		}
		
		
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			
			for(int k=0; k<len; k++)
			{
				arr[i].add(Integer.parseInt(st.nextToken()));
			}

		}
		

		// print();
		
		// 가능한 그룹의 모든 가짓수 구하기 -> 6개를 (1,5) (2,4) (3,3)
		make_cnt();
		
		// (1,5) -> 1개 뽑고, 나머지 5개를 어떻게 구분 짓지? -> 방문 배열 활용?
		// N개 중에 count개 뽑기 (조합)
		for(int i=0; i<cnt_list.size(); i++)
		{
			int count = cnt_list.get(i).a;
			
			// System.out.println("몇개를 뽑을까요?" + count);
			// 1번부터 N까지 (총 N개)
			combinations(0,1, new boolean[N+1], count);
		}
		
		
		System.out.println(Answer == Integer.MAX_VALUE ? -1 : Answer);
		
	}

	private static void combinations(int index, int k, boolean[] v, int count) {
		
		
		if(index == count)
		{
			// true: count / false : N-count개
			// 방문 배열로 그룹 나누기 완료
			
			if(check_connect(v, count))
			{
				count_people(v);
			}
			
//			for(int i=1; i<=N; i++)
//			{
//				if(v[i]) System.out.print(i+ " ");
//			}
//			System.out.println();
//			
//			
//			System.out.println("connect : "+result);
			
			
			return;
		}
		
		for(int i=k; i<=N; i++)
		{
			v[i] = true;
			combinations(index+1, i+1, v, count);
			v[i] = false;
		}

	}

	private static void count_people(boolean[] v) {
		
		int first = 0;
		int second = 0;
		
		for(int i=1; i<=N; i++)
		{
			if(v[i])
			{
				first += people[i];
			}
			
			if(!v[i])
			{
				second += people[i];
			}
		}
		
		Answer = Math.min(Answer, Math.abs(first-second));

	}

	private static boolean check_connect(boolean[] v, int count) {

		
		// true(1번 그룹 : count개)와 false(2번 그룹) 으로 구분되어 있음
		// 각 그룹의 연결성 확인 -> 연결되어 있으면 인구 수 카운팅
		// (1,3,4) (2,5,6) 
		// 각 그룹의 숫자만으로 다 방문할 수 있어야함 (다른 정점을 거치면 안됨)
		boolean first = false;
		boolean two = false;
		
		int one=0;
		int second=0;
		
		for(int i=1; i<=N; i++)
		{
			if(v[i])
			{
				one = i;
				break;
			}
		}
		
		for(int i=1; i<=N; i++)
		{
			if(!v[i])
			{
				second = i;
				break;
			}
		}
		
		// true 그룹 검사
		if(v[one])
		{
			// 연결성 확인
			if(bfs(one, v) == count)
			{
				first = true;
			}
		}
		
		// false 그룹 검사
		if(!v[second])
		{
			// 연결성 확인
			if(bfs(second, v) == N-count)
			{
				two = true;
			}
		}
		
		if(first && two) return true;
		else return false;
		
	}

	private static int bfs(int v, boolean[] visited) {
		
		boolean[] double_v = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<>();		
		queue.offer(v);
		double_v[v] = true;
		
		int Ans=1;
		
		
		while(!queue.isEmpty())
		{
			v = queue.poll();
			
			for(int i=0; i<arr[v].size(); i++)
			{
				if(!double_v[arr[v].get(i)])
				{
					if(visited[v] == visited[arr[v].get(i)])
					{
						double_v[arr[v].get(i)] = true;
						queue.offer(arr[v].get(i));
						Ans++;
					}
				}

			}
		}
		
		return Ans;
		
		
	}

	private static void print() {
		
		for(int i=1; i<=N; i++)
		{
			for(int j=0; j<arr[i].size(); j++)
			{
				System.out.print(arr[i].get(j)+" ");
			}
			System.out.println();
		}
		
	}

	private static void make_cnt() {
		
		// N개를 2개의 그룹으로 쪼갤 수 있는 가짓 수 구하기
		int index = N/2;
		
		for(int i=1; i<=index; i++)
		{
			cnt_list.add(new Election(i, N-i));
		}
		
		
		// System.out.println(cnt_list.get(2).a + " " + cnt_list.get(2).b);
	}

}
