### N과 M (1) (BOJ15649)

- 입출력, 전역변수vs인자 등등 실행시간을 줄이려고 이것저것 시도했다.

```java
/*
* 줄 바꿈이 왜이럴까
*/

public class BOJ15649 {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		visited = new boolean[N];
		
		recursive(0);
		System.out.println(sb);
		}
		
		private static void recursive(int k) {
			// basis part
			// 다 골랐어요
			if (k == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}
			// inductive part
			for(int i = 0; i<visited.length; i++){
				if (visited[i] == false) {
					visited[i] = true;
					sel[k] = i+1;
					recursive(k + 1);
					visited[i] = false;
				}
			}
		}
}

```
![image](https://github.com/ssafy11-daejeon-5class/Algorithm_Study/assets/49496217/d4687056-01e3-4cce-85b7-c3b974d3979e)
이건 노력의 흔적 ㅎㅎ


### N과 M (2) (BOJ15650)

- 다들 비슷하게 풀지 않았을까

```java

public class BOJ15650 {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		visited = new boolean[N];
		
		recursive(0, 0);
		System.out.println(sb);
		}
		
		private static void recursive(int idx, int k) {
			// basis part
			if (k == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}

			// inductive part
			for(int i = idx; i<visited.length; i++){
				if (visited[i] == false) {
					visited[i] = true;
					sel[k] = i+1;
					recursive(i+1, k + 1);
					visited[i] = false;
				}
			}
		}
}

```



### N과 M (3) (BOJ15651)

- 재귀랑 반복으로 둘 다 풀어봤는데 재귀가 조금 더 빨랐다.

```java

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		visited = new boolean[N];
		
		recursive(0);
		System.out.println(sb);
		}
		
		private static void recursive(int k) {
			// basis part
			if (k == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}

			// inductive part
			for(int i = 0; i<visited.length; i++){
				sel[k] = i+1;
				recursive(k + 1);
			}
		}
}

```



### N과 M (4) (BOJ15652)


```java

public class BOJ15652 	
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] sel;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		
		recursive(1, 0);
		System.out.println(sb);
		}
		
		private static void recursive(int nowNum, int nowIdx) {
			// basis part
			if (nowIdx == sel.length) {
				for(int num : sel) sb.append(num + " ");
				sb.append("\n");
				return;
			}

			// inductive part
			for(int i = nowNum; i<= N ; i++){
				sel[nowIdx] = i;
				recursive(i, nowIdx + 1);
			}
		}
}

```
