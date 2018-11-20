import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = list(input())

        for i in range(0, len(arr)):
            if arr[i] == "1":
                if i-1 >= 0 and arr[i-1] == "0":
                    arr[i-1] = "X"
                if i+1 < n and arr[i+1] == "0":
                    arr[i+1] = "X"
        print(arr.count("0"))


solve()
