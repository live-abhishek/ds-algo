import sys
sys.stdin = open('input.txt')


def findAns(arr):
    minSpeed = [-1] * len(arr)
    minSpeed[0] = arr[0]
    for i in range(1, len(arr)):
        minSpeed[i] = min(arr[i], minSpeed[i-1])
    ct = 0
    for i in range(len(arr)):
        if minSpeed[i] == arr[i]:
            ct += 1
    print(ct)


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        findAns(arr)


solve()
