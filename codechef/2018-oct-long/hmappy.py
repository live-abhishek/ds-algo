from math import ceil
import sys
sys.stdin = open("input.txt")

def binary(low, high, b, c, n, m):
    if low<=high:
        mid = (low+high)//2
        val = 0
        for i in range(n):
            if c[i] > mid: 
                if (c[i] - mid)%b[i] == 0: val += (c[i] - mid)//b[i]
                else: val += (c[i] - mid)//b[i] + 1
        if val <= m: low = binary(low, mid - 1, b, c, n, m)
        else: low = binary(mid+1, high, b, c, n, m)
    return low

def extend_binary(b, c, n, m):
    return binary(0, max(c), b, c, n, m)

if __name__ == "__main__":
    n,m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = [a[i] * b[i] for i in range(n)]
    print(extend_binary(b, c, n, m)) 
