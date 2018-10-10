from math import floor, log
import sys
sys.stdin = open("input.txt")


def solve():
    for line in sys.stdin:
        n = int(line)
        ans = floor(log(n, 2)) + 1
        print(ans)


solve()
