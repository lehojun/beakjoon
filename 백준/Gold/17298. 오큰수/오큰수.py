import sys

input = sys.stdin.readline

N = int(input())
nums = list(map(int,input().split()))

stack = []
result = []

while len(nums) > 0:
    tmp = nums.pop()
    if len(stack) == 0:
        stack.append(tmp)
        result.append(-1)
    else:
        if stack[-1] <= tmp:
            while len(stack) > 0 and stack[-1] <= tmp:
                stack.pop()
        if len(stack) == 0:
            result.append(-1)
        else:
            result.append(stack[-1])

        stack.append(tmp)

for i in range(len(result)-1, -1, -1):
    print(result[i], end=' ')