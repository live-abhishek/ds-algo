import sys
sys.stdin = open("input.txt")


def findAns(n, m, compTsk):
    unCompTasks = [True] * (n + 1)
    for i in compTsk:
        unCompTasks[i] = False
    chef = []
    ass = []
    turn = 'c'
    for i in range(1, n + 1):
        # if task is incomplete
        if unCompTasks[i]:
            if turn == 'c':
                chef.append(i)
            else:
                ass.append(i)
            turn = 'c' if turn != 'c' else 'a'
    print(*chef)
    print(*ass)


def solve():
    t = int(input())
    for _ in range(t):
        n, m = [int(i) for i in input().split()]
        compTsk = [int(i) for i in input().split()]
        findAns(n, m, compTsk)


solve()
