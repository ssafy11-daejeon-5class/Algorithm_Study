package algorithm.Algorithm_Study.src.hw._240202.hyeona;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1; i<=N; i++)
        {
            queue.offer(i);
        }

        while(queue.size()!=1)
        {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());
    }

}
