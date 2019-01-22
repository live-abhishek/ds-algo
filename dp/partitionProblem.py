def canBePartitioned(arr):
    """
    Function which determines whether an array can be
    partitioned in 2 equal arrays or not
    """
    sm = sum(arr)
    if sm % 2 != 0:
        return False
    else:
        hf = sm // 2
        n = len(arr)
        # dp[i][j] = True if there is any subset {arr[0], arr[1], ...arr[j-1]}
        # with sum equal to i
        dp = [[False for i in range(n+1)] for i in range(hf+1)]
        dp[0] = [True for i in range(n+1)]
        for i in range(1, hf + 1):
            for j in range(1, n+1):
                # if sum was formed with subarray, then even with 
                # adding this element the sum will be formed
                dp[i][j] = dp[i][j-1]
                neededSum = i - arr[j-1]
                if i >= neededSum:
                    dp[i][j] = dp[i][j] | dp[neededSum][j-1]
        return dp[-1][-1]

arr = [3, 1, 1, 2, 2, 1]
ans = "Yes" if canBePartitioned(arr) else "No"
print(ans)
