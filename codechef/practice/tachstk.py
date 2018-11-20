import sys
sys.stdin = open('input.txt')


def solve():
    n, d = [int(i) for i in input().split()]
    arr = []
    for _ in range(n):
        arr.append(int(input()))
    arr.sort()
    count = 0
    i = 1
    while i < len(arr):
        if arr[i] - arr[i-1] <= d:
            count += 1
            i += 2
        else:
            i += 1
    print(count)


solve()
