import sys
sys.stdin = open('input.txt')


def solve():
    n = int(input())
    arr = [int(i) for i in input().split()]
    sa = sum(arr)
    if sa == (n * (n+1)//2):
        print("YES")
    else:
        print("NO")


solve()
