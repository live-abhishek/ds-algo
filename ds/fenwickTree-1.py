class FenwickTree:
    '''
    Fenwick Tree which supports Point update & Range queries
    '''
    def __init__(self, arr):
        n = len(arr)
        self.ft = [0]*(n)
        # update with all the values
        for i in range(1, len(self.ft)):
            self.update(i, arr[i])

    @staticmethod
    def LSOne(s):
        return s & (-s)

    def update(self, i, v):
        while i < len(self.ft):
            self.ft[i] += v
            i += FenwickTree.LSOne(i)

    def __query(self, r):
        sm = 0
        while r:
            sm += self.ft[r]
            r -= FenwickTree.LSOne(r)
        return sm

    def queryRange(self, l, r):
        # special handling if l is 0
        return self.__query(r) - (0 if l == 1 else self.__query(l-1))

if __name__ == "__main__":
    arr = [0] + [5, 9, 6, 1, 8, 4, 3, 7, 2, 8]
    print(sum(arr))
    ft = FenwickTree(arr)
    print(ft.queryRange(1, 10))
    print(ft.queryRange(4,6))
    ft.update(5, 2)
    print(ft.queryRange(4,6))
