import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n, x = [int(i) for i in input().split()]
        notes = [int(i) for i in input().split()]
        tot = sum(notes)
        if tot % x == 0:
            print(tot // x)
        else:
            print(-1)
