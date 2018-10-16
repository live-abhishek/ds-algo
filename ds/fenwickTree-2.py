class FenwickTree2:
    def __init__(self, arr):
        n = len(arr)
        self.arr = arr
        self.ft = [0]*(n)
    
    @staticmethod
    def LSOne(s):
        return s & (-s)

    def __update(self, i, v):
        while i < len(self.ft):
            self.ft[i] += v
            i += FenwickTree2.LSOne(i)

    def updateRange(self, l, r, v):
        self.__update(l, v)
        self.__update(r + 1, -v)

    def query(self, i):
        k = i
        sm = 0
        while i:
            sm += self.ft[i]
            i -= FenwickTree2.LSOne(i)
        return sm + self.arr[k]

if __name__ == "__main__":
    arr = [0] + [5, 9, 6, 1, 8, 4, 3, 7, 2, 8]
    ft = FenwickTree2(arr)
    print(ft.query(5))
    ft.updateRange(4, 6, 1)
    print(ft.query(5))
