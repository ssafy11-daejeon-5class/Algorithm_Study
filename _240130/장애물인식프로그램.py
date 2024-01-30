import sys
from collections import deque
input = sys.stdin.readline

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
    return cnt

N = int(input())
maps = []
for _ in range(N):
    i = input()
    temp = []
    for j in range(N):
        temp.append(int(i[j]))
    maps.append(temp)

answer = 0
counts = []
for i in range(N):
    for j in range(N):
        if maps[i][j] == 1:
            flag = True
            counts.append(bfs(i, j, maps))
print(len(counts))
counts.sort()
for i in counts:
    print(i)
            