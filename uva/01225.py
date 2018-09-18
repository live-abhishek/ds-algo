# import sys
# sys.stdin = open("input.txt")
# sys.stdout = open("output.txt", 'w')


def calc(upto):
    arr = [0]*10
    for num in range(1, upto+1):
        while num > 0:
            arr[num % 10] += 1
            num = num // 10
    print(*arr)


def solve():
    t = int(input())
    for _ in range(t):
        calc(int(input()))


solve()
