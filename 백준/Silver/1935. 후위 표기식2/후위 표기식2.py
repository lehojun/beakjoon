import sys

input = sys.stdin.readline

x = int(input())
cmd = input().rstrip()
stack = []
num_list = [0]* x

for i in range(x):
    num_list[i] = int(input())

for i in cmd:
    if 'A' <= i <= 'Z':
        stack.append(num_list[ord(i)-ord('A')])
    else:
        num2 = stack.pop()
        num1 = stack.pop()

        if i == '+':
            stack.append(num1+num2)
        elif i == '-':
            stack.append(num1-num2)
        elif i == '*':
            stack.append(num1*num2)
        elif i == '/':
            stack.append(num1/num2)

print('%.2f' %stack[0])