package hw._240219.hyeona;


//bfs, dfs 둘다 해보긔

import java.util.*;

public class BOJ_바이러스 {

 static boolean[] v;
 static int N, Ans=0;
 static List<Integer>[] arr;
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     N = sc.nextInt();
     v = new boolean[N+1];
     arr = new ArrayList[N+1];

     int E = sc.nextInt();

     for(int i=0; i<N+1; i++)
     {
         arr[i] = new ArrayList<>();
     }

     for(int i=0; i<E; i++)
     {
         int from = sc.nextInt();
         int to = sc.nextInt();

         arr[from].add(to);
         arr[to].add(from);
     }

     // System.out.println(arr[1]);
     // bfs(1);
     v[1] = true;
     dfs(1);
     
     System.out.println(Ans);
 }

 private static void dfs(int x) {

     for(int j=0; j<arr[x].size(); j++)
     {
         if(!v[arr[x].get(j)])
         {
             v[arr[x].get(j)] = true;
             Ans++;
             dfs(arr[x].get(j));
         }
     }
 }

 private static void bfs(int x) {

     Queue<Integer> queue = new LinkedList<>();
     queue.offer(x);
     v[x] = true;

     while(!queue.isEmpty())
     {
         x = queue.poll();

         for(int i=0; i<arr[x].size(); i++)
         {
             if(!v[arr[x].get(i)])
             {
                 v[arr[x].get(i)] = true;
                 queue.offer(arr[x].get(i));
                 Ans++;
             }
         }


     }




 }
}
