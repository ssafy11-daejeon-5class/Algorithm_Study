def solution(n, s):
    answer = []
    if n > s :
        answer.append(-1)
        return answer
    
    else:
        diff = s - s//n*n
        print(diff)
        for i in range(n-diff):
            answer.append(s//n)
        for i in range(diff):
            answer.append(s//n + 1)
        return answer