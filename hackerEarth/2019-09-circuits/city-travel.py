from math import ceil
import sys
sys.stdin = open("input.txt")

exceptionArr = []
exceptionIdx = 0


def getNextException():
    global exceptionIdx
    if exceptionIdx < len(exceptionArr):
        exception = exceptionArr[exceptionIdx]
        exceptionIdx += 1
        return exception
    else:
        return None


def solve():
    S, X, N = [int(i) for i in input().split()]
    for _ in range(N):
        t, y = [int(i) for i in input().split()]
        exceptionArr.append((t, y))
    exceptionArr.sort(key=lambda excep: excep[0])  # sort by day number
    covered = 0
    days = 0
    while covered < S:
        nextException = getNextException()
        if nextException is not None:
            # days can travel without exception; No Exception days
            noExDays = nextException[0] - days - 1
            canCover = noExDays * X
            remaining = S - covered
            if remaining <= canCover:
                extraDays = ceil(remaining / X)
                days += extraDays
                covered += remaining
            else:
                days += noExDays
                covered += canCover
            if covered < S:
                covered += nextException[1]
                days += 1
        else:
            remaining = S - covered
            days += ceil(remaining / X)
            covered += X * remaining
    print(days)


solve()
