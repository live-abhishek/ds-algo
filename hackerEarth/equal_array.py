# import sys
# sys.stdin = open("input.txt")


def findAns(arr):
    pS = [arr[0]]
    for i in range(1, len(arr)):
        pS.append(pS[i-1]+arr[i])
    mx = pS[-1]
    ans = -1
    for i in range(len(arr)):
        currDiff = (mx - pS[i]) - pS[i]
        if currDiff < 0:
            break
        if ans == -1 or currDiff < ans:
            ans = currDiff
    return ans


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        ans = findAns(arr)
        print(ans)


solve()
