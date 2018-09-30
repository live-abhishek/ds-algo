def naive_suffix_array(T):
    n = len(T)
    suffixes = [T[i:n] for i in range(n)]
    SA = sorted(suffixes)
    return SA

naive_suffix_array("GATAGACA$")
