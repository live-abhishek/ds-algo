import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n, k = [int(i) for i in input().split()]
        arr = [int(i) for i in input().split()]
        arr.sort()
        son = sum(arr[:k])
        chef = sum(arr[k:])
        diff1 = abs(chef-son)
        son = sum(arr[len(arr)-k:])
        chef = sum(arr[:len(arr)-k])
        diff2 = abs(chef-son)
        print(max(diff1, diff2))


solve()
