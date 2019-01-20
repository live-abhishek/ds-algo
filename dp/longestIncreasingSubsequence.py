def lis(arr):
    n = len(arr)
    # lis[i] is length of longest subsequence found
    # in the array arr[0..i]
    # initially each length is of size 1
    lis = [1]*n
    # for each element of the original array
    for i in range(1, n):
        # check against each of the previos element of original array
        for j in range(i):
            # if by including arr[i] with the longest subsequence
            # ending at arr[j] gives a larges subsequence
            if arr[i] >= arr[j]:
                # record this
                lis[i] = max(lis[i], lis[j] + 1)
    # return the largest recorded subsequence found
    return max(lis)

arr = [10, 22, 9, 33, 21, 50, 41, 60]
ans = lis(arr)
print(ans)
