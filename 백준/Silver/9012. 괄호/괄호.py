import sys

read = sys.stdin.readline
N = int(read())
command = [read().strip() for _ in range(N)]

for i in range(N):
  right = 0
  left = 0
  result = ""
  for j in range(len(command[i])):
    if command[i][j] == "(":
      left += 1
      if right != 0:
        right -= 1
        left -= 1
    elif command[i][j] == ")":
      right += 1
      if right > left:
        break
  if right == left:
    result = "YES"
  elif right != left:
    result = "NO"
  print(result)
    