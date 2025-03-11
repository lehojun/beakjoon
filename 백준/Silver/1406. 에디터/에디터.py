import sys
from collections import deque

input = sys.stdin.readline
input_list = input().rstrip()
left = deque(input_list)
right = deque()

for _ in range(int(input())):
  command = input().rstrip()

  if command == "L":
    if left:
      right.appendleft(left.pop())
  elif command == "D":
    if right:
      left.append(right.popleft())
  elif command == "B":
    if left:
      left.pop()
  else:
    command = command[2]
    left.append(command)

print(''.join(left)+''.join(right))