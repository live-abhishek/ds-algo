# import sys
# sys.stdin = open("input.txt")

M = 10**9+7


def findAns(m, n, arr):
    dp = [0] * (n+1)
    dp[0] = 1
    for a in arr:
        for i in range(a, n+1):
            if i-a >= 0:
                dp[i] += dp[i-a]
    return dp[n] % M


def solve():
    m, n = [int(i) for i in input().split()]
    arr = [int(i) for i in input().split()]
    ans = findAns(m, n, arr)
    print(ans)


solve()
