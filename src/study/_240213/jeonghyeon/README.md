# 치킨 거리
- 허무하다..
- 구현을 못했습니다 죄송합니다

# 배열 돌리기1
- 사각형 하나가 한 바퀴를 돌아 원래대로 돌아오려면 몇 칸 이동해야 하는지를 계산해서 oneRoundDist라는 변수로 저장
- 회전수 R이 oneRoundDist보다 클 경우 모듈러 연산으로 이동 횟수를 줄여주도록 했음
- 한 칸씩 R번 이동하는 게 아니라 위치를 계산해서 한번에 이동하면 좋을 것 같은데 어려워서 실패

```java
for (int i = 0; i < Math.min(N, M) / 2; i++) {
	turning(i);
}

static void turning(int startPoint) {
	int smallR = startPoint;
	int smallC = startPoint;
	int largeR = N - 1 - smallR;
	int largeC = M - 1 - smallC;

	int oneRoundDist = ((N - smallR * 2 - 1) + (M - smallC * 2 - 1)) * 2;
	int leftDist = R % oneRoundDist;
	for (int i = 0; i < leftDist; i++) {
		String[] upString = map[smallR].clone();
		for (int r = smallR; r < largeR; r++) {
			map[r][largeC] = map[r + 1][largeC];
		}
		for (int c = largeC; c > smallC; c--) {
			map[largeR][c] = map[largeR][c - 1];
		}
		for (int r = largeR; r > smallR; r--) {
			map[r][smallC] = map[r - 1][smallC];
		}
		for (int c = smallC; c < largeC; c++) {
			map[smallR][c] = upString[c + 1];
		}
	}
}


```
# 크로아티아 알파벳
- "dz="가 3글자라 이거인지를 먼저 검사하고 다음에 나머지 크로아티아 문자들을 검사하는 방식
- 예전에 풀었던 문제인데 그때보다 더 오래 걸린 듯ㅋㅋ

```java
String[] croatia = { "c=", "c-", "d-", "lj", "nj", "s=", "z=" };

for (int i = 0; i < s.length(); i++) {
	answer++;
	if (i < s.length() - 2 && s.substring(i, i + 3).equals("dz=")) {
		i += 2;
	} else if (i < s.length() - 1) {
		for (String word : croatia) {
			if (s.substring(i, i + 2).equals(word)) {
				i++;
				break;
			}
		}
	}
}

//test3	

```
