def solve():
    n = int(input())
    inp = input()
    # inp = '1 2 1 2'
    arr = [1 if int(i) % 2 == 1 else -1 for i in inp.split()]
    pSum = [0]
    for i in range(len(arr)):
        pSum.append(arr[i] + pSum[i])

    count = 0
    mp = {}
    mp[0] = [0]
    for i in range(1, len(pSum)):
        curr = pSum[i]
        if curr in mp:
            count += len(mp[curr])
            mp[curr].append(i)
        else:
            mp[curr] = [i]
    print(count)


solve()
