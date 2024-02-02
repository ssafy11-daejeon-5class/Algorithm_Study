import sys
input = sys.stdin.readline
N, K = map(int, input().split())
M = -100 * K
cand = []

arr = list(map(int, input().split()))

for i in range(0, len(arr) - K):
    cand.append(sum(arr[i:i+K]))

print(max(cand))