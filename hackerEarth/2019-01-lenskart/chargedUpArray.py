MOD = pow(10,9)+7

def solveTC():
    n = int(input())
    arr = [int(i) for i in input().split()]
    # arrSet = set(arr)
    presentCount = pow(2, len(arr) - 1)
    resultArr = [i%MOD for i in arr if i >= presentCount]
    print(sum(resultArr) % MOD)

def solve():
    t = int(input())
    for _ in range(t):
        solveTC()

solve()
