import sys
sys.stdin = open("input.txt")

n, k = [int(x) for x in input().strip().split()]
k_order = [int(x) - 1 for x in input().strip().split()]

next_teams = [[int(x) - 1 for x in input().strip().split()][1:]
              for _ in range(n)]
played = [False] * n
played[0] = True
k_set = set(k_order)


def solve(beat, to_play):
    if to_play == k:
        return 1
    ans = 0
    div = sum(not played[team] for team in next_teams[beat])
    for team in next_teams[beat]:
        if not played[team]:
            if team in k_set:
                if team == k_order[to_play]:
                    played[team] = True
                    ans += solve(team, to_play + 1) / div
                    played[team] = False
            else:
                played[team] = True
                ans += solve(team, to_play) / div
                played[team] = False
    return ans


print(solve(0, 0))
