T = "I DO NOT LIKE SEVENTY SEV BUT SEVENTY SEVENTY SEVEN"
P = "SEVENTY SEVEN"
b = [None]*(len(P)+1)  # KMP back table


def kmpPreprocess():
    # initialization
    i = 0
    j = -1
    b[0] = -1
    # preprocess pattern
    while i < len(P):
        # different, reset j using b
        pi = P[i]
        pj = P[j]
        while j >= 0 and P[i] is not P[j]:
            bj = b[j]
            j = b[j]
        # if same, advance both pointers
        i += 1
        j += 1
        b[i] = j


def kmpSearch():
    # initialization
    i = 0
    j = 0
    # search through string T
    while i < len(T):
        # different, reset j using b
        while j >= 0 and T[i] is not P[j]:
            j = b[j]
        i += 1
        j += 1
        if j == len(P):
            print("P is found at index {} in T".format(i - j))
            j = b[j]


kmpPreprocess()
print(b)
kmpSearch()
