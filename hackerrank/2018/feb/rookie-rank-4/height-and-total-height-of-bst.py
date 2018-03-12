#!/bin/python3

import os
import sys
sys.setrecursionlimit(10000)
# sys.stdin = open('input.txt')


class Node:
    def __init__(self, v):
        self.v = v
        self.p = None
        self.l = None
        self.r = None
        self.h = 0

    def addToLeft(self, node):
        self.l = node
        node.p = self

    def addToRight(self, node):
        self.r = node
        node.p = self


def insertNode(root, node):
    parNode = None
    currNode = root
    while currNode is not None:
        parNode = currNode
        if node.v is currNode.v:
            return
        elif node.v < currNode.v:
            currNode = currNode.l
        else:
            currNode = currNode.r
    if node.v < parNode.v:
        parNode.addToLeft(node)
    else:
        parNode.addToRight(node)


def calcHeight(root):
    if root is None:
        return -1
    else:
        hL = calcHeight(root.l)
        hR = calcHeight(root.r)
        root.h = max(hL, hR) + 1
        return root.h


def heightAndTotalHeight(arr):
    root = Node(arr[0])
    nodes = [root]
    for i in range(1, len(arr)):
        newNode = Node(arr[i])
        nodes.append(newNode)
        insertNode(root, newNode)
    calcHeight(root)
    totalHeight = 0
    for node in nodes:
        totalHeight += node.h
    return [root.h, totalHeight]


if __name__ == '__main__':
    arr_size = int(input())
    arr = [int(i) for i in input().split()]
    result = heightAndTotalHeight(arr)
    print(result[0])
    print(result[1])
