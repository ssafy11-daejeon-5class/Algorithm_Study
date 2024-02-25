package hw._240223.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimAdjacentList {
    static int V, E;
    static int[] minWeight;
    static boolean[] visited;
    static List<List<Edge>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println("최소 가중치의 합: " + prim());
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

            for (Edge node : list.get(idx)) {
                if (!visited[node.to] && node.weight < minWeight[node.to]) {
                    minWeight[node.to] = node.weight;
                }
            } // end of iterator

        } // end of for i loop

        return weightSum;
    }


    public static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
