import sys
sys.stdin = open('input.txt')

# https://www.quora.com/Maximize-V-x-y-z-xyz-for-left-left-x-y-z-right-vert-4x+4y+4z-P-right-left-2xy+2yz+2zx-S-right-where-P-and-S-are-known-constants


def solve():
    t = int(input())
    for _ in range(t):
        p, s = [int(i) for i in input().split()]
        x = y = (p - ((p**2 - 24*s)**0.5)) / 12
        z = (p + 2*((p**2 - 24*s)**0.5)) / 12
        v = x * y * z
        print(round(v, 2))


solve()
