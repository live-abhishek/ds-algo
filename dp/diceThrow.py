def numWaysDiceThro(n, f, sm):
    dp =[[0 for i in range(n+1)] for i in range(sm+1)]
    for i in range(1, f+1):
        if i <= sm:
            dp[i][1] = 1
    for i in range(1, sm+1):
        for j in range(1, n+1):
            # calculating for each different face
            for k in range(1, f+1):
                dp[i][j] += dp[i-k][j-1] if i-k >= 0 else 0
    return dp[-1][-1]

print(numWaysDiceThro(4,2,1)) 
print(numWaysDiceThro(2,2,3)) 
print(numWaysDiceThro(6,3,8)) 
print(numWaysDiceThro(4,2,5)) 
print(numWaysDiceThro(4,3,5))
