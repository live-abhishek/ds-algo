dictionary = ["mobile","samsung","sam","sung","man",
"mango","icecream","and","go","i","like","ice","cream"]

def canWordBreak(testString):
    dp = [False]*(len(testString))
    # array which holds the index of last chacter of a word in testString
    wordEndIndices = []
    for i in range(len(testString)):
        # not a single word from the 1st character has been matched yet
        if len(wordEndIndices) == 0:
            substr = testString[:i+1]
            if substr in dictionary:
                dp[i] = True
                wordEndIndices.append(i)
        else:
            # nice thing in python; reversed is just an iterator
            # it does not create a new reversed list
            for wordEndIndex in reversed(wordEndIndices):
                substr = testString[wordEndIndex+1:i+1]
                if substr in dictionary:
                    dp[i] = True
                    wordEndIndices.append(i)
                    break
            else: # case to test substring upto i in dictionary
                # above loop leaves this last substring
                # a better written loop should consider both of them
                substr = testString[:i+1]
                if substr in dictionary:
                    dp[i] = True
                    wordEndIndices.append(i)
    return dp[-1] if len(dp) > 0 else True


def wordBreak(testString):
    if canWordBreak(testString):
        print("Yes")
    else:
        print("No")

wordBreak("ilikesamsung") 
wordBreak("iiiiiiii") 
wordBreak("") 
wordBreak("ilikelikeimangoiii") 
wordBreak("samsungandmango") 
wordBreak("samsungandmangok") 
