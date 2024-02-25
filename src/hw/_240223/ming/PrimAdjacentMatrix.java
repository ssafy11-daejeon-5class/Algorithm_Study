package hw._240223.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimAdjacentMatrix {

    static int V, E;
    static int[][] map;
    static int[] minWeight;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println("최소 가중치의 합: " + prim());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V][V];
        minWeight = new int[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) minWeight[i] = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from][to] = map[to][from] = weight;
        }
    }

    public static long prim() {
        long weightSum = 0;
        minWeight[0] = 0;

        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && minWeight[j] < min) {
                    min = minWeight[j];
                    idx = j;
                }
            } // end of for j loop

            if(idx == -1) break;
            visited[idx] = true;
            weightSum += minWeight[idx];

            for (int j = 0; j < V; j++) {
                if (map[idx][j] != 0 && !visited[j] &&
                        map[idx][j] < minWeight[j]) {
                    minWeight[j] = map[idx][j];
                }
            } // end of for j loop
        } // end of for i loop

        return weightSum;
    }
}
