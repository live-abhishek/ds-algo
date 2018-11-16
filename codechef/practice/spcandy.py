import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n, k = [int(i) for i in input().split()]
        if k == 0:
            print(0, n)
        else:
            print(n//k, n % k)


solve()
