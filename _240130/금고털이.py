import sys
input = sys.stdin.readline

W, N = map(int, input().split())
minerals = []

for _ in range(N):
    m, p = map(int, input().split())
    minerals.append((m,p))

minerals.sort(key = lambda x : x[1], reverse = True)
answer = 0
for m, p in minerals:
    if W - m >= 0:
        answer += m*p
        W -= m
    else:
        answer += W * p
        break

print(answer)