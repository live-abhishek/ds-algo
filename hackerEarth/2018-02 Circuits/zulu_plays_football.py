from bisect import bisect

import sys
sys.stdin = open("input.txt")

totalProbability = 0


def isNodeInT(T, node):
    return True if T[bisect(T, node)-1] == node else False


def isNextInT(T, lastVisitedFromT, node):
    if lastVisitedFromT:
        pos = bisect(T, lastVisitedFromT)
        # if this node is next to the lastVisitedFromT
        return True if pos <= len(T) and T[pos] == node else False
    else:
        return True


def isBeforeLastVisitedInT(T, lastVisitedFromT, node):
    if lastVisitedFromT:
        posLastVisited = bisect(T, lastVisitedFromT)
        posNode = bisect(T, node)
        return True if posNode < posLastVisited else False
    else:
        return False


def getAllUnvisitedNodes(visitedSet, currentSet):
    unvisitedSet = set()
    for e in currentSet:
        if e not in visitedSet:
            unvisitedSet.add(e)
    return unvisitedSet


def calcUnvisitedNodeCount(visitedSet, currentSet):
    unvisitedCount = 0
    for e in currentSet:
        if e not in visitedSet:
            unvisitedCount += 1
    return unvisitedCount


def visitSomeNode(T, mainMap, listIndex=1, visitedSet=set(), runningProbability=1, lastVisitedFromT=None):
    global totalProbability
    if lastVisitedFromT is T[-1]:
        totalProbability += runningProbability
        return
    else:
        currentSet = mainMap[listIndex]
        unvisitedSet = getAllUnvisitedNodes(visitedSet, currentSet)
        if len(unvisitedSet) is 0:
            return
        else:
            newProbability = 1/len(unvisitedSet)
        for node in unvisitedSet:
            nodeInT = isNodeInT(T, node)

            if nodeInT and isBeforeLastVisitedInT(T, lastVisitedFromT, node):
                continue

            visitedSet.add(node)
            if not nodeInT:
                visitSomeNode(T, mainMap, node, visitedSet,
                              runningProbability*newProbability, lastVisitedFromT)
            if nodeInT and isNextInT(T, lastVisitedFromT, node):
                visitSomeNode(T, mainMap, node, visitedSet,
                              runningProbability*newProbability, node)
            visitedSet.remove(node)


def solve():
    n, k = [int(i) for i in input().split()]
    T = [int(i) for i in input().split()]
    mainMap = {}
    for i in range(1, n+1):
        mainMap[i] = [int(i) for i in input().split()][1:]
    visitSomeNode(T, mainMap)
    print(totalProbability)


solve()
