package hw._240223.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimAdjacentMatrix_PQ {
    static int V, E;
    static int[] minWeight;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(prim());
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
        int idx = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(0, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if(visited[now.node]) continue;

            visited[now.node] = true;
            weightSum += now.weight;
            if(++idx == V) break;

            for (int i = 0; i < V; i++) {
                if(!visited[i] && map[now.node][i] != 0
                        && map[now.node][i] < minWeight[i]) {

                    minWeight[i] = map[now.node][i];
                    queue.offer(new Edge(i, minWeight[i]));
                }
            } // end of for i loop
        } // end of while

        return weightSum;
    }

    public static class Edge implements Comparable<Edge> {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
