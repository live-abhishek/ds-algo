def isOdd(n):
    return n % 2 == 1

def isEven(n):
    return n % 2 == 0

class Solution:
    def sumEvenAfterQueries(self, A: 'List[int]', queries: 'List[List[int]]') -> 'List[int]':
        ans = []
        currEvenSum = sum([a for a in A if isEven(a)])
        for q in queries:
            idx = q[1]
            oldVal = A[idx]
            newVal = q[0] + A[idx]
            if isEven(newVal):
                if isEven(oldVal):
                    currEvenSum += newVal - oldVal
                else:
                    currEvenSum += newVal
            else:
                if isEven(oldVal):
                    currEvenSum -= oldVal

            A[idx] = newVal
            ans.append(currEvenSum)
        return ans

queries = [[1,0],[-3,1],[-4,0],[2,3]]
A = [1,2,3,4]
print(Solution().sumEvenAfterQueries(A, queries))
queries = [[4,0]]
A = [1]
print(Solution().sumEvenAfterQueries(A, queries))