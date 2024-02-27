package hw._240227.ming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1753 {
    // 최단경로
    static int V, E;
    static int start;
    static Node[] adjList;
    static int[] minDistance;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
        print();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        adjList = new Node[V+1];
        minDistance = new int[V+1];
        visited = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, weight, adjList[from]);
        }

        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;
    }

    public static void dijkstra() {
        int min = 0, stopOver = 0;

        for (int i = 1; i <= V; i++) {
            min = INF;
            stopOver = -1;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && min > minDistance[j]) {
                    min = minDistance[j];
                    stopOver = j;
                }
            }

            if(stopOver == -1) break;
            visited[stopOver] = true;

            for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
                if(minDistance[temp.vertex] > min + temp.weight)
                    minDistance[temp.vertex] = min + temp.weight;
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++)
            sb.append(minDistance[i] != INF ? minDistance[i] : "INF").append("\n");
        System.out.println(sb);
    }

    public static class Node {
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
}
