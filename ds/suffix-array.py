from math import ceil, log


class Suffix:
    def __init__(self):
        self.id = 0  # suffix index
        self.rl = -1  # rank left
        self.rr = -1  # rank right

    def __cmp__(self, other):
        if self.rl == other.rl:
            if self.rr < other.rr:
                return -1
            elif self.rr == other.rr:
                return 0
            else:  # if self.rr > other.rr
                return 1
        else:
            if self.rl < other.rl:
                return -1
            else:  # if self.rl > other.rl
                return 1


def buildSuffixArray(txt):
    n = len(txt)
    suffixes = [Suffix() for i in range(n)]
    # creating suffixes and assiging rank based on 1st 2 characters
    # (or based on the string of lenght 2)
    # this procedure of assignment of ranks manually is done once at
    # like an initialization
    for i in range(n):
        suffixes[i].id = i
        suffixes[i].rl = ord(txt[i]) - ord('a')
        suffixes[i].rr = ord(txt[i + 1]) - ord('a') if (i + 1) < n else -1
    suffixes.sort()

    # from this point onward all rank assignment will be done in a loop
    # and the lenght of substring under consideration will be 4, 8, 16,...
    # till the length of the substring is larger than n

    # to do this we will use iteration value of 2^k
    # where 2 <= k <= ceil(log n)
    # e.g. if n = 6, then
    # we will loop for 4(2^2; see above line) & 8(2^3; see following line)
    # upper bound of k = ceil(log 6) = ceil(2.584) = 3

    #
    ind = [-1] * n
    upto = ceil(log(n, 2))
    for k in range(2, upto):
        # sub string length
        sl = 2**k
        rank = 0
        prev_rank = suffixes[0].rl
        ind[suffixes[0].id] = 0
    return []


if __name__ == "__main__":
    txt = "banana"
    suffixArr = buildSuffixArray(txt)
    print(*suffixArr)
