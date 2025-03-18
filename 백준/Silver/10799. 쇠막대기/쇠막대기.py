import sys

input = sys.stdin.readline
cmd_stack = list(input().rstrip())
result = 0
stick = 0

for i in range(len(cmd_stack)):
    if cmd_stack[i] == '(':
        if cmd_stack[i + 1] == '(':
            stick += 1
        else:
            result += stick
    else:
        if i == len(cmd_stack)-1:
            break
        if cmd_stack[i + 1] == ')':
            stick -= 1
            result += 1

print(result)
