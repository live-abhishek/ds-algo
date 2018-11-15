import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        j = set(input())
        s = set(input())
        ct = 0
        for c in s:
            if c in j:
                ct += 1
        print(ct)


solve()
