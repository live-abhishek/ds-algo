def func1(i):
    res = [i]
    while i > 0:
        i = i & -i
        res.append(i)
    return res

print(func1(5))
print(func1(11))
print(func1(17))
print(func1(21))
print(func1(23))
print(func1(31))
