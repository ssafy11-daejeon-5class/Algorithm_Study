package study._240201.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15652 {
   static int N, M;
	static int[] arr;
	static int[] sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		sel = new int[M];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		recursive(0, 0);
	}
    private static void recursive(int idx, int k) {
        if(k == M){
            for (int i : sel) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
			return;
        }
        //Inductive Part
		for(int i = idx ; i < arr.length ; i++) {
			sel[k] = arr[i];
			recursive(i + 1, k + 1);
		}
    }
}
