from collections import deque
import sys

test_case = int(sys.stdin.readline())

for _ in range(test_case):
    n, m = map(int, sys.stdin.readline().split())
    dq = deque([(pos, val) for pos, val in enumerate(list(map(int, sys.stdin.readline().split())))])
    
    cnt = 0 

    while True:
        cur = dq.popleft()
        
        if any(cur[1] < x[1] for x in dq):
            dq.append(cur)
        else:
            cnt += 1
            if cur[0] == m:
                print(cnt)
                break
    # ----------------------------------------------------------------------