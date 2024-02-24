package hw._240223.junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PrimAdjList {
    static class Node{
        int end, weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
           adjList.add(new ArrayList<>()); 
        }

        boolean[] v = new boolean[V];
        int[] minEdge = new int[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(s).add(new Node(e, w));
            adjList.get(e).add(new Node(s, w));
        }

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        int result = 0;
        int c;
        for (c = 0; c < V; c++) {
            
            // step 1 : 비트리 정점 중 최소간선비용의 정점 찾기!
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 0; j < V; j++) {
                if(!v[j] && minEdge[j] < min){
                    min = minEdge[j];
                    minVertex = j;
                } 
            }

            if(minVertex == -1){
                break;
            }            
            result += min;
            v[minVertex] = true;

            // step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려 최적 업데이트
            for (int j = 0; j < V; j++) {
                if(!v[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]){
                    minEdge[j] = adjMatrix[minVertex][j];
                } 
            }
        }
        System.out.println(c==V?result:-1);

    }
}
