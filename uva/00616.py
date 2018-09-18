import sys
sys.stdin = open("input.txt")
sys.stdout = open("output.txt", "w")

# TODO: NOT SOLVED


def find(coco):
    peo = -1
    monkey_share = 1
    for tot_peo in range(int(coco**0.5), 1, -1):
        curr_coco = coco
        people_woke = 0
        for p_num in range(1, tot_peo + 1):
            people_woke += 1
            if curr_coco % tot_peo == 1:
                persons_share = curr_coco // tot_peo
                curr_coco = curr_coco - persons_share - monkey_share
            else:
                peo = -1
                break
        if curr_coco % tot_peo == 0 and people_woke == tot_peo:
            peo = tot_peo
            break
        else:
            peo = -1
    if peo == -1:
        print('{} coconuts, no solution'.format(coco))
    else:
        print('{} coconuts, {} people and 1 monkey'.format(coco, peo))


def solve():
    while True:
        n = int(input())
        if n < 0:
            break
        else:
            find(n)


solve()
