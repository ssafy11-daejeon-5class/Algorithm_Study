package algorithm.Algorithm_Study.src.hw._240202.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int height;
    int index;

    public Top(int height, int index) {
        this.height = height;
        this.index = index;
    }

    public Top() {
        // TODO Auto-generated constructor stub
    }
}

public class BOJ_2493 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        int nTop=0;
        int nIndex=0;

        for(int i=0; i<N; i++)
        {
            Top top = new Top(Integer.parseInt(st.nextToken()), i+1);
            while(!stack.isEmpty())
            {
                if(stack.peek().height >= top.height)
                {
                    sb.append(stack.peek().index).append(" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) sb.append(0).append(" ");
            stack.push(top);
        }
        System.out.println(sb);

    }
}


/*처음 실패 코드
로직 ) 스택이 비어있거나, 스택의 top이 입력 높이를 감당하지 못할 때만 스택에 푸쉬
스택의 top이 입력 높이를 감당할 수 있다면, 입력 높이를 스택에 넣지 않고 top을 출력
-> 이렇게 하면 직전에 나오는 것들 중 최고 높이만 기록하는 형태라 실패
8 5 4 7 이런 형태일 때, (정답) 0 1 2 1 -> (출력) 0 1 1 1

-> 그렇다면? 무조건 스택에 들어가야함
-> 스택에서 (입력 높이를 감당할 수 있는 높이)가 나올 때 까지 pop하는 형태로 가야함
-> 입력 높이를 감당할 수 있는게 발견되면 ? break
*/



//public class Main {
//
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        Stack<Top> stack = new Stack<>();
//        int nTop=0;
//        int nIndex=0;
//
//        for(int i=0; i<N; i++)
//        {
//            Top top = new Top(Integer.parseInt(st.nextToken()), i);
//            // 같을 때
//            if(stack.isEmpty() || top.height > stack.peek().height)
//            {
//                stack.push(top);
//                System.out.println(0);
//            }else if(top.height == stack.peek().height)
//            {
//                System.out.println((stack.peek().index)+1);
//            }
//            else
//            {
//
//                if(nTop >=top.height) System.out.println(nIndex);
//                    // 안에 들어있는게 들어오는거 보다 크면, 넣지 않고 스택의 탑 출력
//                else if(top.height <= stack.peek().height)
//                {
//                    System.out.println((stack.peek().index)+1);
//                    nTop = top.height;
//                    nIndex = top.index+1;
//                }
//            }
//
//        }
//
//    }
//
//}
