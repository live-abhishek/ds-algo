import sys
from collections import defaultdict

sys.stdin = open('input.txt')


def findShiftedPairs(codedSet, e):
    shifts = []
    for i in range(len(e) - 1, 0, -1):
        shifts.append(e[i:] + e[:i])
    shiftedPairs = set()
    for shift in shifts:
        if shift in codedSet:
            pair = sorted([shift, e])
            pair = pair[0] + " " + pair[1]
            shiftedPairs.add(pair)
    return shiftedPairs


def uniqueRecycledPairs(A):
    codedMap = defaultdict(set)
    ans = 0
    for num in A:
        code = sorted(num)
        code = "".join(code)
        codedMap[code].add(num)

    for key in codedMap.keys():
        codedSet = codedMap[key]
        setAnagrams = set()
        for e in codedSet:
            shiftedPairs = findShiftedPairs(codedSet, e)
            setAnagrams |= shiftedPairs
        ans += len(setAnagrams)
    return ans


if __name__ == '__main__':
    n = int(input())
    A = [str(i) for i in input().split()]
    result = uniqueRecycledPairs(A)
    print(result)
