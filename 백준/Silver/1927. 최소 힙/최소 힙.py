import sys
import heapq as hq

input = sys.stdin.readline

m = int(input())
a = []
for _ in range(m):
    n = int(input())
    if n == 0:
        if len(a) == 0:
            print(0)
        else:
            print(hq.heappop(a))
    else:
        hq.heappush(a, n)

