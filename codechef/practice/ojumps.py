import sys
sys.stdin = open('input.txt')


def solve():
    n = int(input())
    rem = n % 6
    if rem in [0, 1, 3]:
        print("yes")
    else:
        print("no")


solve()
