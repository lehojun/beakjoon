from collections import deque

while True:
    try:
        s, t = input().split()
        s = deque(s)

        for x in t:
            if s and s[0] == x:
                s.popleft()
        
        if not s: 
            print('Yes')
        else:
            print('No')

    except:
        break