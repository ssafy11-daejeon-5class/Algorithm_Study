package study._240201.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15649 {

    static int N, M;
	static int[] arr;
	static int[] sel;
	static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		sel = new int[M];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
			v[i] = false;
		}
		permutations(0);
	}

	private static void permutations(int i) {
		// TODO Auto-generated method stub
		if(i == sel.length) {
			for(int k = 0 ; k < M ; k++){
                System.out.print(sel[k] + " ");
            }
            System.out.println();
			return;
		}
		
		for(int k = 0 ; k < N ; k++) {
			if(!v[k]) {
				v[k] = true;
				sel[i] = arr[k];
				permutations(i+1);
				v[k] = false;
			}
		}
	}

}
