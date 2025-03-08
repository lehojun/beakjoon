import sys

read = sys.stdin.readline
N = int(read())
command = [read().strip() for _ in range(N)]

for i in range(len(command)):
  command_list = command[i].split()
  result = ''
  reverse_words = []

  for j in range(len(command_list)):
    reverse_word = ''.join(reversed(command_list[j]))
    result += reverse_word+' '

  print(result)
