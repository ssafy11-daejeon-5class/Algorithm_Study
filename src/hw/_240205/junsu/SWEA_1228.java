package hw._240205.junsu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1228 {

	static String cmd;
	static int N, commandCnt, x, y;
	static int[] nums;
	static Queue<Integer> q;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		for(int t = 1 ; t <= 10 ; t++) {
			N = Integer.parseInt(br.readLine());
			q = new ArrayDeque<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			
			// 명령의 개수를 입력받은 후, 명령의 개수만큼 명령을 실행하여 큐 값을 변경한다.
			commandCnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < commandCnt ; i++) {
				cmd = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				// 추가할 배열 nums 입력
				nums = new int[y];
				for(int j = 0 ; j < y ; j++) {
					nums[j] = Integer.parseInt(st.nextToken());
				}
				insert();
				N += y;
			}

			System.out.print("#" + t);
			for(int i = 0 ; i < 10 ; i ++) {
				System.out.print(" " + q.poll());
			}
			System.out.println();
		}
	}
	private static void insert() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < x ; i++) {
			q.offer(q.poll());
		}
		
		for(int i = 0 ; i < y ; i++) {
			q.offer(nums[i]);
		}
		
		for(int i = 0 ; i < N - x; i++) {
			q.offer(q.poll());
		}
		
	}

}
