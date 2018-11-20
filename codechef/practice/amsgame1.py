from fractions import gcd
from functools import reduce
import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        print(reduce(gcd, arr))


solve()
