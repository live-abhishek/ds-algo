import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        x, y, k, n = [int(i) for i in input().split()]
        rem = x-y  # pages remaining
        books = []
        for o in range(n):
            books.append([int(i) for i in input().split()])
        for book in books:
            if book[0] >= rem and book[1] <= k:
                print("LuckyChef")
                break
        else:
            print("UnluckyChef")


solve()
