from collections import Counter
import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        ctr = Counter(arr)
        counts = []
        for i in ctr.items():
            counts.append(i)
        counts.sort()
        ans = 0
        sumTill = 0
        for count in counts:
            sumTill += count[1]
            ans += count[1] * len(arr) - sumTill
        print(ans)


solve()
