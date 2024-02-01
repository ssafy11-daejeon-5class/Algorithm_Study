### 구간 합 구하기 4 (BOJ11659)

- 아이디어 떠올려서 코드 짜는 거 까진 괜찮았는데 i, j를 받고 누적합 배열에 대입했을 때 딱 맞지가 않고 뭔가 달라서 찾느라 고민 좀 했다.
- 이런데서 시간 많이 쓰면 안될 거 같은데 아직 익숙해지지 않는다
- 이 코드로 백준에서 Scanner와 br가 속도가 많이 차이나는지 함 해봤는데 스캐너는 안쓰는게 좋겠다. 스캐너 왜쓰지

```java

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] sums = new int[N + 1];
		
		sums[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int n = 1; n < N + 1; n++) {
			sums[n] = sums[n - 1] + Integer.parseInt(st.nextToken());
		}

		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sums[end] - sums[start]);
		}

```




### 구간 합 구하기 5 (BOJ11660)

- 집에 와서 다시 보니 방법이 생각났다.
- 다만 출력을 sysout으로 하니까 시간초과가 났다. 
- sysout은 적게 쓸 수록 좋은 거 같다. 출력이 길거나 테스트 케이스 여러개면 StringBuilder로 한번에 모아서 하는게 좋아보인다

```java

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] sums = new int[N + 1];
		
		sums[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int n = 1; n < N + 1; n++) {
			sums[n] = sums[n - 1] + Integer.parseInt(st.nextToken());
		}

		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sums[end] - sums[start]);
		}

```





### 우울 안 달팽이 (SWEA1954)

- 2차원 배열에서 x랑 y중에 뭐가 앞이고 뭐가 뒤인지 자꾸 헷갈려서 계속 틀렸다.
- 앞으로는 시작점이 좌측상단이면 row와 col을 쓰도록 하겠다
- 다시 보니 sysout을 줄일 수 있는 부분이 보인다. 나 성장했다

``` java

for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
      // 2차원 배열 만들고 모두 -1로 초기화
			int[][] snail = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					snail[i][j] = -1; 

      // direction의 값을 0~3으로 해서 오른쪽 아래 왼쪽 위 표시
			int[] stepY = new int[] {0, 1, 0, -1};
			int[] stepX = new int[] {1, 0, -1, 0};
			int direction = 0;
			int nowX = -1, nowY = 0;
			
			for(int n = 1; n <= N*N; n++) {
				int nextY = nowY + stepY[direction];
				int nextX = nowX + stepX[direction];
        // 다음칸이 2차원배열 밖이거나 이미 먹힌 칸이면 거기로 안가고 방향 바꿔서 전진
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || snail[nextY][nextX] != -1) {
					direction = (direction +1) % 4;
					nextY = nowY + stepY[direction];
					nextX = nowX + stepX[direction];
				}
				snail[nextY][nextX] = n;
				nowY = nextY;
				nowX = nextX; 
			}
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < N; j++) {
					sb.append(snail[i][j]);
					sb.append(" ");
				}
				System.out.println(sb.toString());
			}
		}

```




