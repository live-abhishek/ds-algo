import sys
sys.stdin = open("input.txt")


def find(n):
    powOf5 = 5
    ans = 0
    while powOf5 <= n:
        ans += n // powOf5
        powOf5 *= 5
    print(ans)


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        find(n)


solve()
