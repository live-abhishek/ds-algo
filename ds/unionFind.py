class UnionFind:
    def __init__(self, n):
        self.p = [i for i in range(n)]
        self.r = [0]*n
        self.s = [1 for i in range(n)]
        self.ct = n

    def findSet(self, i):
        return i if self.p[i] == i else self.findSet(self.p[i])

    def isSameSet(self, i, j):
        return self.findSet(i) == self.findSet(j)

    def unionSet(self, i, j):
        if not self.isSameSet(i, j):
            x = self.findSet(i)
            y = self.findSet(j)
            # keep the rank short
            if self.r[x] > self.r[y]:
                self.p[y] = x
                # set represented by x now contains one more item
                self.s[x] += 1
            else:
                self.p[x] = y
                self.s[y] += 1
                if self.r[x] == self.r[y]:
                    # set represented by y now contains one more item
                    self.r[y] += 1
            self.ct -= 1

    def sizeOfSet(self, i):
        return self.s[self.findSet(i)]

    def numDisjointSets(self):
        return self.ct
