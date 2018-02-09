def editDistance(str1, str2):
    m, n = len(str1), len(str2)
    dp = [[0 for j in range(n + 1)] for i in range(m + 1)]

    for i in range(m + 1):
        for j in range(n + 1):

            if i == 0:
                dp[i][j] = j
            elif j == 0:
                dp[i][j] = i
            elif str1[i - 1] == str2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]
            else:
                dp[i][j] = 1 + min(dp[i - 1][j - 1],
                                   dp[i - 1][j], dp[i][j - 1])
    print(*dp, sep="\n")
    return dp[m][n]


str1 = "sunday"
str2 = "saturday"
print(editDistance(str1, str2))
