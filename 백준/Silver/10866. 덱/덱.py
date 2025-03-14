import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
dq = deque()

for _ in range(n):
  command = input().strip()
  if command == "pop_front":
    if dq:
      print(dq.pop())
    else:
      print("-1")
  elif command == "pop_back":
    if dq:
      print(dq.popleft())
    else:
      print("-1")
  elif command == "size":
    print(len(dq))
  elif command == "empty":
    if dq:
      print("0")
    else:
      print("1")
  elif command == "front":
    if dq:
      print(dq[-1])
    else:
      print("-1")
  elif command == "back":
    if dq:
      print(dq[0])
    else:
      print("-1")
  elif command[:10] == "push_front":
    dq.append(command[11:])
  else:
    dq.appendleft(command[10:])
