package study._240305.jeonghyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 혁셈블리어 {
	static int T, R, C, nr, nc;
	static char[][] orders;
	static boolean[][][][] visited;
	static int memory, direction;
	static boolean stopFlag;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			getInput();
			goGo();
			
		}
		System.out.println(sb);
	}

	private static boolean goGo() {
		while(true) {
			if(execute()) 
				return true;
			move();
			if(findInfiniteLoop()) {
				return true;
			}
		}
		
		return false
	}
	
	private static boolean execute() {
		char order = orders[nr][nc];
		switch (order) {
		case '<': {
			direction = 2;
			break;
		}
		case '>': {
			direction = 0;
			break;
		}
		case '^': {
			direction = 3;
			break;
		}
		case 'v': {
			direction = 1;
			break;
		}
		case '_': {
			direction = (memory == 0) ? 2 : 0;
			break;
		}
		case '|': {
			direction = (memory == 0) ? 1 : 3;
			break;
		}
		case '?': {
			direction = (int)(Math.random()) % 4;
			break;
		}
		case '.': {
			break;
		}
		case '@': {
			return true;
		}
		case '+': {
			memory = (memory + 1) % 16;
			break;
		}
		case '-': {
			memory = (memory + 15) % 16;
			break;
		}
		default:
			if(order < '0' || order > '9')
				break;
			memory = (int)order - '0';
			break;
		}
		
		return false;
	}
	
	private static void move() {
		switch (direction) {
		case 0: {
			nc = (nc+1) % C;
			break;
		}
		case 1: {
			nr = (nr+1) % R;
			break;
		}
		case 2: {
			nc = (nc+C-1) % C;
			break;
		}
		case 3: {
			nr = (nr+R-1) % R;
			break;
		}
		default:
			break;
		}
	}

	public static boolean findInfiniteLoop() {
		if(visited[nr][nc][direction][memory] == true) {
			return true;
		}
		return visited[nr][nc][direction][memory] = false;
	}
	
	private static void getInput() throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		orders = new char[R][C];
		for (int i = 0; i < R; i++) {
			orders[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C][4][16];
		nr = nc = 0;
		memory = 0;
		direction = 0;
		stopFlag = false;
	}
}
