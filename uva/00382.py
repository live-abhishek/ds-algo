def findAns(num):
    # divisors sum
    ds = 1
    upto = int((num**0.5)+1)
    divisors = []
    for i in range(2, upto):
        if num % i is 0:
            divisors.append(i)
            ds += i
            other = num // i
            if other != i:
                ds += num // i
    if num == 1:
        ans = 'DEFICIENT'
    elif ds == num:
        ans = 'PERFECT'
    elif ds < num:
        ans = 'DEFICIENT'
    else:
        ans = 'ABUNDANT'
    print('{:>5}  {}'.format(num, ans))


def solve():
    # inp = input()
    inp = '2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 0'
    arr = [int(i) for i in inp.split()]
    print('PERFECTION OUTPUT')
    for i in range(len(arr) - 1):
        findAns(arr[i])
    print('END OF OUTPUT')
    print()


solve()
