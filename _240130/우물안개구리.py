import sys
from collections import defaultdict

input = sys.stdin.readline
N, M = map(int, input().split())
powers = list(map(int, input().split()))

graph = defaultdict(list)
answer = 0

for i in range(M):
    k, v = map(int, input().split())
    graph[k].append(v)
    graph[v].append(k)

for key, value in graph.items():
    flag = True
    M = powers[key-1]
    for i in value:
        if M <= powers[i-1]:
            flag = False
            break
    if flag:
        answer += 1
    
answer += N - len(graph.keys())
print(answer)