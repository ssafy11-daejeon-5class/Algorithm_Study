import sys

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