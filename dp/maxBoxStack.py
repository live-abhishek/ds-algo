class Box:
    def __init__(self, l, b, h):
        self._l = l;
        self._b = b;
        self._h = h;

    def area(self):
        return self._l * self._b

    def __lt__(self, other):
        """
        Comparing based on the area of the box. Used for sorting based on area
        """
        return self.area() < other.area()

    def isBaseSmallerThan(self, other):
        return self._l < other._l and self._b < other._b

    def __str__(self):
        return "[{}, {}, {}]".format(self._l, self._b, self._h)

    def generatedRotatedBoxes(self):
        """
        Generates 3 boxes with different rotation than the given box.
        While generating orientation the length of the box will alway
        be kept greater than the breadth.
        """
        b0 = Box(max(self._l, self._b), min(self._l, self._b), self._h)
        b1 = Box(max(self._b, self._h), min(self._b, self._h), self._l)
        b2 = Box(max(self._l, self._h), min(self._l, self._h), self._b)
        return (b0, b1, b2)

def generateAllOreintationOfAllBoxesSorted(boxes):
    rotatedBoxes = []
    for box in boxes:
        rotatedBoxes += box.generatedRotatedBoxes()
    # keep the box with largest area at the bottom
    # which means at the 0th index of sorted array
    # so we reverse the sorted list
    rotatedBoxes.sort(reverse = True)
    return rotatedBoxes

def maxBoxStackHeight(boxes):
    # dp table which holds the max heigth attainable
    # by keeping box[i] at the top
    maxHeights = [box._h for box in boxes]
    
    for i in range(len(boxes)):
        currBox = boxes[i]
        for j in range(i):
            prevBox = boxes[j]
            if currBox.isBaseSmallerThan(prevBox):
                maxHeights[i] = max(maxHeights[i], maxHeights[j]+currBox._h)
    return max(maxHeights)

# boxes
b1 = Box(4, 6, 7); 
b2 = Box(1, 2, 3); 
b3 = Box(4, 5, 6); 
b4 = Box(10, 12, 32)
boxes = [b1, b2, b3, b4]
boxes = generateAllOreintationOfAllBoxesSorted(boxes)
ans = maxBoxStackHeight(boxes)
print(ans)
