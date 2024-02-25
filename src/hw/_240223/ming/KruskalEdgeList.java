package hw._240223.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class KruskalEdgeList {
    static int V, E;
    static int[] parents;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println("최소 가중치의 합: " + kruskal());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V];
        for (int i = 0; i < V; i++) parents[i] = i;

        edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(from, to, weight));
        }

        Collections.sort(edgeList);
    }

    public static long kruskal() {
        long weight = 0;
        int cnt = 0;

        for (Edge edge : edgeList) {
            // 싸이클을 형성하면 cotninue
            if(!union(edge.from, edge.to)) continue;

            // 가중치 추가
            weight += edge.weight;

            // 다 연결이 됐다면 break
            if(++cnt == V-1) break;
        }

        return weight;
    }

    public static int find(int node) {
        if(node == parents[node]) return node;
        return parents[node] = find(parents[node]);
    }

    public static boolean union(int from, int to) {
        int fromRoot = find(from);
        int toRoot = find(to);

        if(fromRoot == toRoot) return false;

        parents[toRoot] = fromRoot;

        return true;
    }

    public static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
