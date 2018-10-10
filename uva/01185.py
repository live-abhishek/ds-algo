# logarithm
# number of digits in m is
# floor(log(m, 10)) + 1
# log(n!) = log(n * n-1 * n-2 * ... * 1)
# log(n!) = log(n) + log(n-1) + log(n-2) + ... + log(1)

# so create an array of log(i, 10) where log(0, 10) = -1
# then compute the array upto max value of n
# then compute prefix sum of that array from 1 to n, exclude 0
from math import floor, log
import sys
sys.stdin = open("input.txt")

log_arr = [1, 0]


def calculate(max_n):
    # calculate logs
    for i in range(2, max_n + 1):
        log_i = log(i, 10)
        log_arr.append(log_i)
    # calculate prefix sum of logs
    for i in range(2, len(log_arr)):
        log_arr[i] = log_arr[i] + log_arr[i-1]


def findDigits(n):
    return floor(log_arr[n]) + 1


def solve():
    t = int(input())
    arr = []
    for _ in range(t):
        n = int(input())
        arr.append(n)
    max_n = max(arr)
    calculate(max_n)
    for n in arr:
        ans = findDigits(n)
        print(ans)


solve()
