T = int(input())

for test_case in range(1, T+1):
    answer = "Possible"
    N, M, K = map(int, input().split())
    customer = list(map(int, input().split()))

    customer.sort()
    for i in range(N):
        if (customer[i] // M) * K  < i + 1:
            answer = "Impossible"
    print("#{} {}".format(test_case, answer))