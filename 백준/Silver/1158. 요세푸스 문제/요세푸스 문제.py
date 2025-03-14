from collections import deque

n, m = map(int, input().split())

dq = deque()
for i in range(1, n + 1):
  dq.append(i)

result = []
x = 1
while dq:
  if x == m:
    result.append(dq.popleft())
    x = 1
  else:
    dq.append(dq.popleft())
    x += 1

print(f"<{', '.join(map(str, result))}>")
