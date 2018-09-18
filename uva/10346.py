import sys
# sys.stdin = open("input.txt")
# sys.stdout = open("output.txt")


def cigarettes(n, k):
    tot = n  # total cigarettes smoked
    butts = n  # total butts remaining
    while butts >= k:  # loop till we have more butts to roll out atleast one cigarette
        new_cigarettes = butts // k
        butts_remaining = butts % k
        tot += new_cigarettes
        butts_new_cigarettes = new_cigarettes  # redundant; just for clarity
        butts = butts_new_cigarettes + butts_remaining
    print(tot)


def solve():
    for line in sys.stdin:
        line = [int(i) for i in line.split()]
        cigarettes(*line)


solve()
