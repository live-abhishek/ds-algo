MAX = 10**6 + 1
sieve = [float('inf')] * MAX
good = [[] for _ in range(MAX)]


def modifiedSieve():
    sieve[2] = 0
    for i in range(2, MAX):
        if sieve[i] == 0:
            j = i
            while j < MAX:
                s[i] += j
                j += i


def goodPairs():
    for i in range(2, MAX):
        j = i
        while j < MAX:
            if sieve[j] % sieve[i] == 0:
                good[i].append(j)
            j += i


def solveTC(arr):
    freq = [0] * MAX
    for a in arr:
        freq[a] += 1
    ans = 0
    for i in range(2, MAX):
        if freq[i] > 0:
            for j in good[i]:
                ans += freq[i] * freq[j]
    ans -= len(arr)
    print(ans)


def solve():
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = [int(i) for i in input().split()]
        solveTC()


modifiedSieve()
goodPairs()
solve()
