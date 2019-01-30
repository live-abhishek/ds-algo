from math import log, ceil, floor


def createSparseTable(arr):  # 7
    n = len(arr)  # 7
    # should come as 4, because we need to iterate
    # for sizes from 2^0(1) to 2^3(8)
    k = ceil(log(n, 2))+1
    spt = [[0 for i in range(n)] for i in range(k)]
    # for sizes of 1, just copy values from the arr
    for i in range(n):
        spt[0][i] = arr[i]
    # for sizes of 2 to 2^3(8)
    for i in range(1, k):
        # for last but one iteration the currSize should be 2^i but
        # for last iteration currSize should be min of 2^3(=8) and n(=7)
        currSize = min(pow(2, i), n)
        lastSize = currSize // 2
        j = 0
        # finding minimum in the range arr[j...j + currSize)
        # notice the extra +1
        while j + currSize < n+1:
            # e.g. currSize = 4; lastSize = 2; finding spt[2][1]
            # e.g. finding min in the range arr[1...1+4)
            # find min of arr[1...1+2) & arr[1+2..1+4)
            # now min of arr[1..1+2) is stored in spt[1][1]
            # & min of arr[1+2..1+4) is stored in spt[1][1+2]
            spt[i][j] = min(spt[i-1][j], spt[i-1][j+lastSize])
            j += 1
    return spt


def searchMin(spt, l, r):
    # e.g. l=0, r=5; therefore we will check min of
    # arr[0...4) & arr[2...5+1) => this range has size 6(5-0+1)
    # i.e. the smaller size of 4 => exp = 2
    # NOTE: if there are many queries, its a good idea to cache/precompute logs
    exp = floor(log(r - l + 1, 2))  # exp=2
    size = pow(2, exp)  # size=4
    minimum = min(spt[exp][l], spt[exp][r - size + 1])
    return minimum


arr = [4, 3, 7, 2, 1, 3, 2, 3]
spt = createSparseTable(arr)
print(searchMin(spt, 0, 5))  # 1
print(searchMin(spt, 0, 2))  # 3
print(searchMin(spt, 0, 3))  # 2
