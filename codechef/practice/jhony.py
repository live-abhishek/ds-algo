from bisect import bisect_right as bi
import sys
sys.stdin = open('input.txt')


def findAns(n, arr, k):
    ak = arr[k - 1]
    arr.sort()
    pos = bi(arr, ak)
    print(pos)


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        k = int(input())
        findAns(n, arr, k)


solve()
