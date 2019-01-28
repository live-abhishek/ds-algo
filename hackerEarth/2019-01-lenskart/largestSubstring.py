def solve():
    n = int(input())
    s = input()
    currSum = 0
    firstOccSum = {}
    maxLen = 0
    for i in range(len(s)):
        currSum += 1 if s[i] == '0' else -1
        if currSum > 0:
            maxLen = i + 1
        elif currSum <= 0:
            if (currSum-1) in firstOccSum:
                curLen = i - firstOccSum[currSum - 1]
                maxLen = max(maxLen, curLen)
        if currSum not in firstOccSum:
            firstOccSum[currSum] = i
    print(maxLen)

solve()
