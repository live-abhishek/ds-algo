def isSubsetSum(st, sm):
    n = len(st)
    dpArray = [[False for i in range(sm+1)] for i in range(n+1)]
    for i in range(n+1):
        dpArray[i][0] = True
    for i in range(1, n+1):
        for j in range(1, sm+1):
            dpArray[i][j] = dpArray[i-1][j-st[i-1]
                                         ] if j >= st[i-1] else dpArray[i-1][j]
    print(*dpArray, sep="\n")

    return dpArray[n][sm]


st = [1, 2, 3]
sm = 6
n = len(st)
if (isSubsetSum(st, sm) == True):
    print("Found a subset with given sum")
else:
    print("No subset with given sum")
