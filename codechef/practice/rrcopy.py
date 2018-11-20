import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        print(len(set([int(i) for i in input().split()])))


solve()
