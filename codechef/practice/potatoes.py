import sys
sys.stdin = open('input.txt')

primes = [True]*(3000)


def calculatePrimes():
    for i in range(2, len(primes)):
        if primes[i]:
            for j in range(2*i, len(primes), i):
                primes[j] = False


def solveTC(arr):
    sm = sum(arr)
    nextPrime = -1
    for i in range(sm+1, len(primes)):
        if primes[i]:
            nextPrime = i
            break
    print(nextPrime - sm)


def solve():
    t = int(input())
    for _ in range(t):
        arr = [int(i) for i in input().split()]
        solveTC(arr)


calculatePrimes()
solve()
