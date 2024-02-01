### 금고털이(softeer)

- 소프티어 문제들 후기 : 문제를 잘 읽어야 하는 거 같다
- 언뜻보면 냅샙??으로 풀어야 될 거 같이 써놨는데 잘 읽어보니 그렇지 않았다

```python

# dictionary로 무게당 가격을 key, 무게를 value로 저장하고
# 무게당 가격이 높은 순으로 가방을 채워나감
# 마지막에 남은 가방 무게보다 귀금속 무게가 크면 남은 가방 무게만큼만 잘라서 넣고 끝

W, N = map(int, input().split())
nobles = dict()
for _ in range(N):
    M, P = list(map(int, input().split()))
    if P in nobles.keys():
        nobles[P] += M
    else:
        nobles[P] = M

answer = 0
for p in range(10000, 0, -1):
    if p in nobles.keys():
        if nobles[p] < W:
            answer += p * nobles[p]
            W -= nobles[p]
        else:
            answer += p * W 
            W = 0

print(answer)

```




### 장애물 인식 프로그램(softeer)

- 제일 쉬워보여서 먼저 풀었는데 제일 오래 걸린 문제

```python

# block_list에 블럭 크기를 저장했음
# bfs로 블럭 영역과 크기 업데이트하면서 했음.

def bfs(i:int, j:int, block_num:int):
    block_list[block_num] += 1
    new_map[i][j] = block_num + 1
    
    nexts = [[i-1, j], [i+1, j], [i, j-1], [i, j+1]]
    for next_ in nexts:
        if next_[0] not in range(0, N) or next_[1] not in range(0,N):
            continue
        if roadmap[next_[0]][next_[1]] == 1 and new_map[next_[0]][next_[1]] == 0:
            bfs(next_[0], next_[1], block_num)
            
N = int(input())
roadmap = list()
for n in range(N):
    roadmap.append(list(map(int, input().rstrip())))

new_map = list(list(0 for n in range(N)) for a in range(N))
block_list = list()
for i in range(N):
    for j in range(N):
        if roadmap[i][j] == 1 and new_map[i][j] == 0:
            block_list.append(0)
            bfs(i, j, len(block_list) - 1)
        
print(len(block_list))
block_list.sort()
for i in range(len(block_list)):
    print(block_list[i])

```




### 우물 안 개구리(softeer)

- 개구리들

``` python

# 모두가 자기가 최고라고 생각한다고 가정
# => Im_the_best 리스트에 회원수만큼 true 저장
# 친분관계에서 지거나 비긴 친구들을 false로 변경
# 마지막에 true 개수 출력

N, M = map(int, input().split())
W = list(map(int, input().split()))
W = [0] + W

Im_the_best = list(True for _ in range(N));
Im_the_best = [False] + Im_the_best
for _ in range(M):
    man1, man2 = map(int, input().split())
    if W[man1] < W[man2]:        
        Im_the_best[man1] = False
    elif W[man1] > W[man2]:        
        Im_the_best[man2] = False
    elif W[man1] == W[man2]:       
        Im_the_best[man1] = False 
        Im_the_best[man2] = False

print(Im_the_best.count(True))

```




