package hw._240215.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class EdgeList {
    static List<int[]> list;
    static StringTokenizer st;
    static int V, E;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new int[]{s, e});
		}

        list.sort((a,b)->a[0] == b[0]?Integer.compare(a[1], b[1]):Integer.compare(a[0], b[0]));
        for (int[] edge : list) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
