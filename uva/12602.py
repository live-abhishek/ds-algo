# Base number conversion
import sys
sys.stdin = open("input.txt")


def convertStrToNum(str):
    num = 0
    for i in range(len(str)):
        c = str[i]
        code = ord(c) - ord('A')
        power = len(str) - i - 1
        num += code*(26**power)
    return num


def findNice(plate):
    first, second = plate.split("-")
    first = convertStrToNum(first)
    second = int(second)
    if abs(first - second) <= 100:
        return True
    else:
        return False


def solve():
    t = int(input())
    for _ in range(t):
        plate = input()
        is_nice = findNice(plate)
        if is_nice:
            print("nice")
        else:
            print("not nice")


solve()
