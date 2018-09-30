def countingSort(arr, exp):
    n = len(arr)
    rng = 10
    output = [0] * n
    count = [0] * rng

    for num in arr:
        idx = (num // exp) % 10
        count[ idx ] += 1

    for i in range(1, rng):
        count[i] += count[i-1]

    for num in reversed(arr):
        idx = (num // exp) % 10
        pos = count[idx]
        pos = pos - 1
        output[pos] = num
        count[idx] -= 1
    
    return output


def radixSort(arr):
    maxVal = max(arr)
    exp = 1
    while maxVal // exp > 0:
        output = countingSort(arr, exp)
        arr = output
        exp *= 10
    return arr

arr = [170, 45, 75, 90, 802, 24, 2, 66] 
arr = radixSort(arr)
print(arr)
