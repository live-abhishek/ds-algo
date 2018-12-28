import sys
sys.stdin = open('input.txt')


def msd(n):
    # most significant digit
    while n >= 10:
        n = n // 10
    return n


def genNxtDgt(n):
    # return digit next to n in cycle of 1..9
    # genNxtDgt(4) = 5
    # genNxtDgt(9) = 1
    return msd(n+1)


def genNxtNum(n):
    # get next digit
    d = msd(n)
    nxt = n + d
    d = genNxtDgt(d)
    if msd(n+d) == d:
        nxt = n + d
    return nxt


seed = 9
ans = [0, seed]


def solveK(k):
    global seed
    while len(ans) < k:
        seed = genNxtNum(seed)
        ans.append(seed)


def solve():
    t = int(input())
    for _ in range(t):
        k = int(input())
        solveK(k)
        print(ans[k-1])


solve()
print(ans)
print(len(ans))
# def gen():
#     n = 170
#     res = [n]
#     while n > 0:
#         m = msd(n)
#         n = n - m
#         res.append(n)
#     print(len(res))
#     print(res)


# gen()
