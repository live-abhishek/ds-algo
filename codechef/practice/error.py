import sys
sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        s = input()
        p1 = s.find("101")
        p2 = s.find("010")
        if p1 == -1 and p2 == -1:
            print("Bad")
        else:
            print("Good")


solve()
