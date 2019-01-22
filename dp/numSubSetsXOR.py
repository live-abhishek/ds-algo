# Count number of subsets having a particular XOR value
from math import log, floor


def maxXorVal(num):
    numBits = floor(log(num, 2)) + 1
    maxVal = (2**numBits) - 1
    return maxVal


def numSubSetXor(st, val):
    n = len(st)
    m = maxXorVal(max(st))
    dp = [[0 for i in range(m+1)] for i in range(n + 1)]
    dp[0][0] = 1
    for i in range(1, n+1):
        for j in range(m+1):
            lt = dp[i-1][j]
            rt = dp[i-1][j ^ st[i-1]]
            dp[i][j] = lt + rt

    return dp[n][val]


print(numSubSetXor([1, 2, 3, 4, 5], 4))  # 4
