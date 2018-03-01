import math
import sys
sys.stdin = open("input.txt")

com = 1e-9
n = int(input())
ai = [[0, 0] for x in range(n)]
f1 = [float(i) for i in input().split()]
f2 = [float(i) for i in input().split()]

for i in range(n):
    ai[i][0] = f1[i]
    ai[i][1] = f2[i]

ai = sorted(ai)


def calc(i, d):
    v = 0
    for a in range(n):
        sgn = int(a <= i) * 2 - 1
        v += sgn * ai[a][1] / math.log(2 + abs(d - ai[a][0]))
    return v


def check(i):
    v1 = calc(i, ai[i][0])
    v2 = calc(i, ai[i + 1][0])

    if v1 > 0 and v2 < 0:
        return True
    return False


def fun(x):
    b = ai[x][0]
    e = ai[x + 1][0]
    m = (b + e) / 2

    while e - b > com:
        v = calc(x, m)
        if v > 0:
            b = m
        else:
            e = m
        m = (b + e) / 2
    return m


res = 0
pos = []

for i in range(n - 1):
    if check(i):
        res += 1
        pos.append(fun(i))

print(res)
print(*pos)
