# import sys
# sys.stdin = open('input.txt')


def solve():
    t = int(input())
    for _ in range(t):
        p1, p2, k = [int(i) for i in input().split()]
        total_serves = p1 + p2
        number_of_changes = total_serves // k
        ans = 'CHEF' if number_of_changes % 2 == 0 else 'COOK'
        print(ans)


solve()
