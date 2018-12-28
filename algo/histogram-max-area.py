hists = [2, 1, 5, 6, 2, 3]


def largestArea():
    maxArea = 0
    numBars = len(hists)
    # pick each bar one-by-one
    for curBarPos in range(numBars):
        curBar = hists[curBarPos]
        # minimum of heights of bar till seen
        minHt = curBar
        # pick any bar following this bar
        for nextBarPos in range(curBarPos, numBars):
            nextBar = hists[nextBarPos]
            # find min considering this new bar
            minHt = min(minHt, nextBar)
            # calculate the area
            areaUptoThisBar = (nextBarPos - curBarPos + 1) * minHt
            maxArea = max(maxArea, areaUptoThisBar)
    return maxArea


ans = largestArea()
print(ans)
