import sys
sys.stdin = open("input.txt")

def solveTC():
    a,b,c,d,m = [int(i) for i in input().split()]
    n = int(input())
    nums = [int(i) for i in input().split()]
    # used to speed up calculations for which we have already calculated RHS
    xMap = {} 
    # count of different RHS values encountered
    rhsValueCount = {}
    for i in nums:
        iModM = i % m
        if iModM in xMap:
            val = xMap[iModM]
        else:
            iModMSq = iModM*iModM
            iModMCube = iModMSq*iModM
            val = (a*iModMCube + b*iModMSq + c*iModM+d)%m
        rhsValueCount[val] = rhsValueCount.get(val, 0)+1
    lhsValueCount = {}
    for i in nums:
        val = (i*i) % m
        lhsValueCount[val] = lhsValueCount.get(val, 0)+1
    pairCount = 0
    for key, val in lhsValueCount.items():
        if key in rhsValueCount:
            pairCount += val*rhsValueCount[key]
    print(pairCount)


def solve():
    t = int(input())
    for _ in range(t):
        solveTC()

solve()
