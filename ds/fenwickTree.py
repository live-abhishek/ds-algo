class FenwickTree:
    def __init__(self, n):
        self.ft = [0]*(n+1)

    @staticmethod
    def LSOne(s):
        return s & (-s)

    def rsq1(self, b):
        sm = 0
        while b:
            sm += self.ft[b]
            b -= FenwickTree.LSOne(b)
        return sm

    def rsq(self, a, b):
        return self.rsq1(b) - (0 if a == 1 else self.rsq1(a-1))

    def adjust(self, k, v):
        '''
        Adjust value of k-th element by v
        v can be +/-ve
        note: n = len(self.ft) - 1
        '''
        while k < len(self.ft):
            self.ft[k] += v
            k += FenwickTree.LSOne(k)


if __name__ == "__main__":
    f = [2, 4, 5, 5, 6, 6, 6, 7, 7, 8, 9]
    ft = FenwickTree(max(f)+1)
    for i in f:
        ft.adjust(f[i], 1)
    print(ft.rsq(1, 1))
    print(ft.rsq(1, 2))
    print(ft.rsq(1, 6))
    print(ft.rsq(1, 10))
    print(ft.rsq(3, 6))
    ft.adjust(5, 2)  # increment by 2
    print(ft.rsq(3, 10))
