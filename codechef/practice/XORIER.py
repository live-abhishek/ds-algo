import sys
sys.stdin = open("input.txt")


def calc(n, arr):
    freq = [0] * (10**6)
    for a in arr:
        freq[a] += 1
    odd = even = 0
    for a in arr:
        if a & 1:
            odd += 1
        else:
            even += 1
    ans = 0
    for a in arr:
        if a & 1:
            ans += odd
        else:
            ans += even
        # remove count of elements by which XOR is 2
        ans -= freq[a ^ 2]
        # remove count of elements by which XOR is 0
        ans -= freq[a]
    # as we counted both (i, j) & (j, i), we divide by half
    ans = ans // 2
    return ans


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        ans = calc(n, arr)
        print(ans)


solve()
