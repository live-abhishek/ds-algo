from enum import Enum
import sys
sys.stdin = open("input.txt")


class Citizen(Enum):
    bit = 1
    nibble = 2
    byte = 3


dp = []


def calculate(n):
    count = 1
    itr = 0
    while itr <= n+2:
        for i in range(2):
            dp.append((Citizen.bit, count))
        itr += 2
        for i in range(8):
            dp.append((Citizen.nibble, count))
        itr += 8
        for i in range(16):
            dp.append((Citizen.byte, count))
        itr += 16
        count *= 2


def findAns(n):
    return dp[n-1]


def solve():
    t = int(input())
    arr = []
    for _ in range(t):
        n = int(input())
        arr.append(n)
    max_n = max(arr)
    calculate(max_n)
    for i in arr:
        ans = findAns(i)
        if ans[0] is Citizen.bit:
            print(ans[1], 0, 0)
        elif ans[0] is Citizen.nibble:
            print(0, ans[1], 0)
        elif ans[0] is Citizen.byte:
            print(0, 0, ans[1])


solve()
