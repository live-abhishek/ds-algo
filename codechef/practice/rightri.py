import sys
sys.stdin = open('input.txt')


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Vector:
    def __init__(self, p1, p2):
        self.x = p1.x - p2.x
        self.y = p1.y - p2.y

    def dot(self, other):
        return self.x * other.x + self.y * other.y


class Triangle:
    def __init__(self, p1, p2, p3):
        self.p1 = p1
        self.p2 = p2
        self.p3 = p3

    def is_right(self):
        v1 = Vector(self.p1, self.p2)
        v2 = Vector(self.p2, self.p3)
        v3 = Vector(self.p3, self.p1)
        return v1.dot(v2) == 0 or v1.dot(v3) == 0 or v2.dot(v3) == 0


def solve():
    t = int(input())
    count = 0
    for _ in range(t):
        arr = [int(i) for i in input().split()]
        p1 = Point(arr[0], arr[1])
        p2 = Point(arr[2], arr[3])
        p3 = Point(arr[4], arr[5])
        t = Triangle(p1, p2, p3)
        if t.is_right():
            count += 1
    print(count)


solve()
