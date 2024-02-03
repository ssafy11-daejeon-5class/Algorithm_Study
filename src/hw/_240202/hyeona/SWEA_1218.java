package algorithm.Algorithm_Study.src.hw._240202.hyeona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 시작 괄호일 때, 닫는 괄호일때로 나누나?

public class SWEA_1218 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        for(int i=1; i<=10; i++)
        {
            int flag=0;
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            stack.push(str.charAt(0));

            for(int j=1; j<str.length(); j++)
            {
                if(stack.isEmpty())
                {
                    stack.push(str.charAt(j));
                    continue;
                }

                char close = stack.peek();

                if(str.charAt(j) == ')' && close=='(') stack.pop();
                else if(str.charAt(j) == '>' && close=='<') stack.pop();
                else if(str.charAt(j) == ']' && close=='[') stack.pop();
                else if(str.charAt(j) == '}' && close=='{') stack.pop();
                else if(str.charAt(j) == '(' || str.charAt(j) == '<' || str.charAt(j) == '[' || str.charAt(j) == '{') stack.push(str.charAt(j));
                else flag=1;

                if(flag==1)
                {
                    break;
                }

            }
            if(flag==1) sb.append("#").append(i).append(" ").append(0).append('\n');
            else sb.append("#").append(i).append(" ").append(1).append('\n');
        }
        System.out.println(sb);

    }
}
