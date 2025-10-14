n = input()
stack = []
res = ''
priority = {'*': 2, '/': 2, '+': 1, '-': 1, '(': 0}

for x in n:
    if 'A' <= x <= 'Z': 
        res += x
    elif x == '(':
        stack.append(x)
    elif x == ')':
        while stack and stack[-1] != '(':
            res += stack.pop()
        stack.pop()  
    else: 
        while stack and priority[x] <= priority[stack[-1]]:
            res += stack.pop()
        stack.append(x)

while stack:
    res += stack.pop()

print(res)