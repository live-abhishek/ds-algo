import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        sal = [int(i) for i in input().split()]
        print(sum(sal) - len(sal)*min(sal))


solve()
