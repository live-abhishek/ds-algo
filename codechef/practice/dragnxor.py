import sys
sys.stdin = open('input.txt')


def countOne(n):
    oneCount = 0
    while n:
        if n & 1 == 1:
            oneCount += 1
        n = n >> 1
    return oneCount


def makeNum(leftOne, rightOne, totalbits):
    arr = ["0" for i in range(totalbits)]
    for i in range(leftOne):
        arr[i] = "1"
    for i in range(rightOne):
        arr[totalbits - i - 1] = "1"
    intersection = rightOne + leftOne - totalbits
    if intersection > 0:
        for i in range(intersection):
            arr[totalbits - i - 1] = "0"
    return "".join(arr)


def solve():
    t = int(input())
    for _ in range(t):
        n, a, b = [int(i) for i in input().split()]
        oneA = countOne(a)  # contains num of 1s in a
        oneB = countOne(b)  # contains num of 1s in b
        x = min(oneA, n - oneB)
        y = min(oneB, n - oneA)
        p = x + y
        num = 1 << p
        num = num - 1
        num = num << (n-p)
        print(num)


solve()
