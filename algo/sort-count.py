def countSort_easy(A):
    maxVal = max(A)
    minVal = min(A)
    op = []
    counts = [0]*(maxVal - minVal + 1)
    for num in A:
        counts[num - minVal] += 1
    for i in range(len(counts)):
        count = counts[i]
        while count > 0:
            op.append(i + minVal) 
            count -= 1
    return op
    

def countSort_inefficient(A):
    maxVal = max(A)
    op = [0]*len(A)

    # this is space inefficient as well as time inefficient
    # when maxVal is very large
    counts = [0]*(maxVal+1)
    for num in A:
        counts[num] += 1
    for i in range(1, len(counts)):
        counts[i] += counts[i-1]

    for num in reversed(A):
        pos = counts[num]
        # TODO: write some notes on why extra -1
        pos = pos - 1
        op[pos] = num
        counts[num] -= 1
    
    return op


def countSort(A):
    maxVal = max(A)
    minVal = min(A)
    op = [0] * len(A)

    # efficiently assign the size of the count
    # array to be of the size of range in which the number lies
    # max - min + 1
    counts = [0]*(maxVal - minVal + 1)
    # fill the count array
    for num in A:
        pos = num - minVal
        counts[pos] += 1
    for i in range(1, len(counts)):
        counts[i] += counts[i-1]

    for num in reversed(A):
        pos = counts[num - minVal]
        pos = pos - 1
        op[pos] = num
        counts[num - minVal] -= 1
    
    return op


countSort_easy([1,4,2,2,7,5,2])