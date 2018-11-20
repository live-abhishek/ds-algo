import sys
sys.stdin = open('input.txt')


def decode(s, perm):
    res = ""
    for c in s:
        if c == "_":
            res += " "
        elif c.isupper():
            res += perm[ord(c) - ord('A')].upper()
        elif c.islower():
            res += perm[ord(c) - ord('a')]
        else:
            res += c
    return res


def solve():
    n, perm = input().split()
    for _ in range(int(n)):
        decoded = decode(input(), perm)
        print(decoded)


solve()
