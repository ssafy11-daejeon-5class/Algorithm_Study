# 치킨 거리
- 조합을 활용한 구현 문제
- 이전에 언급했던 것과 같이 문제를 단계별로 차근차근 정리하고 요구사항을 만족시켜 나가면 충분히 해결할 수 있는 문제
- 주의 사항 : 지도 보인다고 무조건 bfs, dfs 하지 말것
- 조합, 순열 코드는 강사님 말씀처럼 구구단이다. 그 안에서 비즈니스 로직은 구현 능력이다. 

# 배열 돌리기1
- 그냥 구현 문제? 이런식의 문제는 사실 DP 문제 풀때 분명 빛을 발하리라 생각된다.
- 각 단계가 이전 단계와 어떠한 "관계"를 갖는지에 집중
```java
  private static int[][] rotate() {
		// TODO Auto-generated method stub
		int[][] res = new int[N][M];
		int n = Math.min(N, M) / 2;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < N - i - 1; j++) {
				res[j+1][i] = arr[j][i];
			}
			for (int j = i; j < M - i - 1; j++) {
				res[N-i-1][j+1] = arr[N-i-1][j];
			}
			for (int j = N - i - 1; j > i; j--) {
				res[j-1][M-i-1] = arr[j][M-i-1];
			}
			for (int j = M - i - 1; j > i; j--) {
				res[i][j-1] = arr[i][j];
			}
		}
		return res;
	}
```
# 크로아티아 알파벳
- 이전에 파이썬으로 풀었던 문제 였다. 이를 자바로 옮겨보는 식으로 문제를 풀었다.
- 어쩌면 이제 .. 파이썬보다 자바가 편할지도..?
- 변경 대상인 크로아티아 알파벳을 미리 선언을 해두고 이를 입력 문자열에서 찾아 replace 시킨다. 이때 그냥 없앨것이 아니라 다른 문자열로 대치 시킴으로써 문자열 길이를 셀 수 있도록 구현.
```java
  static String input;
	static String[] croatic = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		for (String s : croatic) {
			input = input.replace(s, "*");
		}
		System.out.println(input.length());
	}
```
