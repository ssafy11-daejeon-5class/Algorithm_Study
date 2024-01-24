W, H = map(int, input().split())
p, q = map(int, input().split())
t = int(input())

if ((p+t) // W) % 2 == 0:
    p = (p + t) % W
elif ((p+t) // W) % 2 == 1:
    p = W - (p + t) % W

if ((q+t) // H) % 2 == 0:
    q = (q+t) % H
elif ((q+t) // H) % 2 == 1:
    q = H - (q+t)%H 
print(p, q)