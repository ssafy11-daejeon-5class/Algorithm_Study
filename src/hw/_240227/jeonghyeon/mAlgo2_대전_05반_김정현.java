import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class mAlgo2_대전_05반_김정현 {
	
	static int N;
	static Stack<Task> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;

		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("1")) 
				stack.push(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
			if(stack.isEmpty())
				continue;
			Task nowTask = stack.peek();
			if(--nowTask.time == 0) {
				answer += nowTask.jumsu;
				stack.pop();
				continue;
			}
		}
		
		System.out.println(answer);		
	}	
	
	static class Task{
		int jumsu, time;

		public Task(int jumsu, int time) {
			this.jumsu = jumsu;
			this.time = time;
		}
	}
}
