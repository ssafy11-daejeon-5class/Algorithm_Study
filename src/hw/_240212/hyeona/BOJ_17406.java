package hw._240212.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Number{
	int R;
	int C;
	int S;

	public Number(int r, int c, int s) {
		R = r;
		C = c;
		S = s;
	}
}

public class BOJ_17406 {

	static int N, M, K, R, C, S, min;
	static int[][] arr;
	static List<Number> list;

	static boolean[] visited;
	//static int[] sel;
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[K];
		//sel = new int[K];

		list = new ArrayList<>();

		arr = new int[N][M];
		min = Integer.MAX_VALUE;

		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());

			list.add(new Number(R,C,S));
			//rotate(R, C, S);
		}

		permutation(0, new int[K]);

		System.out.println(min);
		//System.out.println(Arrays.deepToString(arr));
		//System.out.println(Arrays.deepToString(new_arr));
	}

	private static void check_min(int[][] new_arr) {

		//System.out.println(Arrays.deepToString(new_arr));
		for(int i=0; i<new_arr.length; i++)
		{
			int sum=0;
			for(int j=0; j<new_arr[0].length; j++)
			{
				sum += new_arr[i][j];
			}
			min = Math.min(sum, min);
		}

	}


	private static void permutation(int index, int[] sel) {

		if(index == sel.length)
		{
			//System.out.println(Arrays.toString(sel));
			int[][] new_arr = new int[N][M];

			for(int i=0; i<arr.length; i++)
			{
				new_arr[i] = Arrays.copyOf(arr[i], arr[i].length);
			}

			for(int i=0; i<sel.length; i++)
			{
				int r = list.get(sel[i]).R;
				int c = list.get(sel[i]).C;
				int s = list.get(sel[i]).S;

				//System.out.println(r+" "+c+" "+s);
				//System.out.println();

				rotate(r, c, s, new_arr);
			}
			//System.out.println(Arrays.deepToString(new_arr));
			//System.out.println();
			check_min(new_arr);
			//System.out.println("ddddd");

			return;
		}

		for(int i=0; i<K; i++)
		{
			if(!visited[i])
			{
				sel[index] = i;
				visited[i]=true;
				permutation(index+1, sel);
				visited[i]=false;
			}
		}


	}

	private static void rotate(int r, int c, int s, int[][] new_arr) {
		
		//System.out.println(Arrays.deepToString(new_arr));
		//System.out.println("DDDDD");

		// 돌릴 배열은 무조건 정사각형
		// 돌려야할 배열의 길이 (s*2+1)
		// 시작점 : r-2, c-2

		//System.out.println(count);

		// 2,3 => 0,1
		// 3-2-1 = 0 / 4-2-1 = 1
		int x = r-s-1;
		int y = c-s-1;
		//System.out.println(x+" "+y);
		// 인덱스는 x ~ x + (s*2)
		
		int ex = x+(s*2);
		int ey = y+(s*2);


		for(int i=0; i<s; i++)
		{
			int temp = new_arr[x+i][ey-i];

			// 1 ->
			for(int j=ey-i; j>y; j--) {
				new_arr[x+i][j] = new_arr[x+i][j - 1];
			}

			// 2 위
			for(int j=x+i; j<ex-i; j++)
			{
				new_arr[j][y+i] = new_arr[j+1][y+i];
			}

			// <-
			for(int j=y+i; j<ey-i; j++)
			{
				new_arr[ex-i][j] = new_arr[ex-i][j+1];
			}

			// 아래
			for(int j=ex-i; j>=r-1; j--)
			{
				new_arr[j][ey-i] = new_arr[j-1][ey-i];
			}

			new_arr[x+i+1][ey-i] = temp;

//			System.out.println(Arrays.deepToString(new_arr));
//			System.out.println();


		}

//		System.out.println(Arrays.deepToString(new_arr));
//		System.out.println();




	}

}
