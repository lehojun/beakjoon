import sys
x = int(input())
stack = []


for i in range(x):
  command = sys.stdin.readline().strip()
  if command == "top":
    if len(stack) == 0:
      print(-1)
    else:
      print(stack[-1])
  elif command == "pop":
    if len(stack) == 0:
      print(-1)
    else:
      print(stack.pop())
  elif command == "size":
    print(len(stack))
  elif command == "empty":
    if len(stack) == 0:
      print(1)
    else:
      print(0)
  else:
    x = int(command[5:])
    stack.append(x)


