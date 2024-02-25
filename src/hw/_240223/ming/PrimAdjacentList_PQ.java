package hw._240223.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimAdjacentList_PQ {

    static int V, E;
    static int[] minWeight;
    static boolean[] visited;
    static List<List<Edge>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(prim());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        minWeight = new int[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            minWeight[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(from).add(new Edge(to, weight));
            list.get(to).add(new Edge(from, weight));
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

            for (Edge edge : list.get(now.node)) {
                if (!visited[edge.node] && edge.weight < minWeight[edge.node]) {
                    minWeight[edge.node] = edge.weight;
                    queue.offer(new Edge(edge.node, edge.weight));
                }
            }
        }

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
