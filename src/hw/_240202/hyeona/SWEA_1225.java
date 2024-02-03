package algorithm.Algorithm_Study.src.hw._240202.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10; i++)
        {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int k=0; k<8; k++)
            {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            int count=1;

            while(queue.peek()-count >0)
            {
                //System.out.println(queue);
                queue.offer(queue.poll()-count);
                count++;

                if(count==6) count=1;
            }

            queue.poll();
            queue.offer(0);

            sb.append("#").append(i).append(" ");
            while(!queue.isEmpty())
            {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
