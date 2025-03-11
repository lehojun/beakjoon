import sys

n = int(input())
stack, result, find = [], [], True
now = 1

for _ in range(n):
  num = int(input())
  while now <= num:
    stack.append(now)
    result.append("+")
    now += 1
  if stack[-1] == num:
    stack.pop()
    result.append("-")
  else:
    find = False
    
if not find:
  print("NO")
else:
  for i in result:
    print(i)