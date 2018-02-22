import sys
sys.stdin = open("input.txt")


def solve():
    n = int(input())
    d = [float(i) for i in input().split()]
    a = [int(i) for i in input().split()]

    ad = [a[i]*d[i] for i in range(n)]
