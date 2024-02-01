import sys


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
