def findPrimes(upto):
    arr = [True]*(upto+1)
    arr[0] = False
    arr[1] = False
    for i in range(2, len(arr)):
        if not arr[i]:  # skip if arr[i] is true, i.e. is prime skip
            continue
        for j in range(2*i, len(arr), i):
            arr[j] = False

    primes = []
    for i in range(len(arr)):
        if arr[i]:
            primes.append(i)
    return primes


def findPowerPrimes(primes, upto):
    powerPrimes = []
    for prime in primes:
        powerPrime = prime**2
        if powerPrime <= upto:
            powerPrimes.append(powerPrime)
        else:
            break
    return powerPrimes


upto = 10**4
primes = findPrimes(upto)
print(primes)
print(len(primes))
powerPrimes = findPowerPrimes(primes, upto)
print(powerPrimes)
print(len(powerPrimes))
