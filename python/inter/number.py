def checkEquals(a, b):
    return a == b


print("checkEquals(2, None) = ", checkEquals(2, None))
print("checkEquals(2, 2) = ", checkEquals(2, 2))
print("checkEquals(2, 'a') = ", checkEquals(2, 'a'))
print("checkEquals(2, object()) = ", checkEquals(2, object()))
print("checkEquals(-1, -1) = ", checkEquals(-1, -1))
