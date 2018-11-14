import re
import sys
sys.stdin = open("input2.txt")

numberPat = re.compile("[0-9]+")
namePat = re.compile("[0-9a-zA-Z]+")
N = "N"
V = "V"
M = "M"


def isName(word):
    return namePat.match(word) and not isNumber(word)


def isNumber(word):
    return numberPat.match(word)


def checkMusic(wordA, wordB):
    if isName(wordA) and isNumber(wordB):
        print(M)
    else:
        print(N)


def checkVideo(wordA, wordB, wordC):
    if isName(wordA) and isNumber(wordB) and isNumber(wordC):
        print(V)
    else:
        print(N)


def solve():
    n = int(input())
    for _ in range(n):
        words = input().split()
        if len(words) == 2:
            checkMusic(words[0], words[1])
        else:
            checkVideo(words[0], words[1], words[2])


solve()
