import sys
sys.stdin = open("input.txt")


def solve():
    a, b = [int(i) for i in input().split()]
    d = a - b
    last = d % 10
    last = 1 if last is not 1 else 2
    d = d // 10
    d = d * 10 + last
    print(d)


solve()
