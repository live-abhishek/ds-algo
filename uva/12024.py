# Derangements
import sys
sys.stdin = open("input.txt")

derangements = [1, 0]
factorials = [1, 1]


def createDerangementTable(n):
    for i in range(2, n+1):
        derangement_i = (i - 1) * (derangements[i-1] + derangements[i-2])
        derangements.append(derangement_i)


def createFactorialTable(n):
    for i in range(2, n+1):
        fact_i = factorials[i-1] * i
        factorials.append(fact_i)


def solve():
    t = int(input())
    n_arr = []
    for _ in range(t):
        n_arr.append(int(input()))
    max_n = max(n_arr)
    createDerangementTable(max_n)
    createFactorialTable(max_n)
    for i in n_arr:
        numr = derangements[i]
        denr = factorials[i]
        print(numr, "/", denr, sep="")


solve()
