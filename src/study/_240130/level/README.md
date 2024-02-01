## 금고털이 💵

- 처음엔 0-1 배낭 문제인줄 알고, 백트래킹, DP 연습하려고 했음
- 근데 알고보니 그냥 `그리디`로 풀면 되는 문제
- 그리디에서는 정렬이 포인트 → 해당 문제에서는 각 금속의 `무게당 가격` 을 기준으로 내림차순 정렬
- 가방에 가성비 좋은것부터 가능한 많이 챙긴다.
- 가방에 남은 자리가 금속 무게보다 적을경우 그만큼만 잘라서 챙기기
- minerals 배열에 무게와 무게당 가치를 저장. 내림차순 정렬 후 탐욕 알고리즘 적용

```python
answer = 0
for m, p in minerals:
    if W - m >= 0:
        answer += m*p
        W -= m
    else:
        answer += W * p
        break
```

<aside>
💡 잘 알다시피 그리디에서는 검증이 가장 중요하다. 무게당 가격이 높은 보석을 가능한 많이 챙기는 것이 가장 가방의 가치를 높이는 방법인 것이 자명하기에 가능했던 풀이

</aside>

## 장애물 인식 프로그램 🏎

- DFS/BFS 문제
- BFS 활용해서 문제를 풀었는데, 재귀 활용한 DFS로 풀었으면 시간 복잡도가 터졌을지도
- BFS의 return value를 count한 1의 숫자로 함
- 큐를 활용한 BFS 풀이

```python
def bfs(i, j, maps):
    q = deque()
    di = [-1, 1, 0, 0]
    dj = [0, 0, -1, 1]
    maps[i][j] = 0
    q.append((i,j))
    cnt = 1
    while q:
        i, j = q.popleft()
        for ddi, ddj in zip(di, dj):
            ni = ddi + i
            nj = ddj + j
            if 0 <= ni < N and 0 <= nj < N and maps[ni][nj] == 1:
                cnt += 1
                maps[ni][nj] = 0
                q.append((ni, nj))
```

## 우물 안 개구리 🐸

- 단순한 그래프 탐색 문제
- 문제를 풀기 나름이겠지만 인접 리스트를 활용하여 관계를 표현
- 아무런 관계가 없는 사람에 대한 처리를 위해 고민했다
- `key`의 길이에서 사람의 수를 뺌으로서 관계가 없는 노드의 개수를 계산
- `flag` 활용하여 만약 본인과 같은 무게를 드는 사람을 발견하면 `answer` 증가
- 만약 딕셔너리의 key에 번호에 해당하는 사람이 없다? → 주변과 아무런 관계가 없다 → `answer` 증가

```python
for key, value in graph.items():
    flag = True
    M = powers[key-1]
    for i in value:
        if M <= powers[i-1]:
            flag = False
            break
    if flag:
        answer += 1
```