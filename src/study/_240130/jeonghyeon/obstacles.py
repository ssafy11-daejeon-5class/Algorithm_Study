import sys

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