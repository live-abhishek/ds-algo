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
    f = [0] + f
    print(sum(f))
    ft = FenwickTree(len(f))
    for i in range(1, len(f)):
        ft.adjust(i, f[i])
        print(i, f[i], ft.rsq(1, i))
    print(ft.rsq(1, 1))
    print(ft.rsq(1, 2))
    print(ft.rsq(1, 3))
    print(ft.rsq(1, 4))
    print(ft.rsq(1, 5))
    print(ft.rsq(1, 6))
    print(ft.rsq(1, 7))
    print(ft.rsq(1, 8))
    print(ft.rsq(1, 9))
    print(ft.rsq(1, 6))
    print(ft.rsq(1, 10))
    print(ft.rsq(3, 6))
    print(ft.rsq(1, 10))
    print(ft.rsq(1, 11))
    ft.adjust(5, 2)  # increment by 2
    print(ft.rsq(1, 11))
