import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        s = input()
        ct = s.count("1")
        print(ct * (ct+1) // 2)


solve()
