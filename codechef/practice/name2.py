import sys
sys.stdin = open('input.txt')


def find(target, toFind):
    cur = 0
    i = 0
    while i < len(toFind):
        c = toFind[i]
        while cur < len(target):
            if target[cur] == c:
                cur += 1
                break
            else:
                cur += 1
        i += 1
        if cur == len(target):
            break
    return True if i == len(toFind) else False


def solve():
    t = int(input())
    for _ in range(t):
        a, b = input().split()
        res = False
        if len(a) > len(b):
            res = find(a, b)
        else:
            res = find(b, a)
        if res:
            print("YES")
        else:
            print("NO")


solve()
