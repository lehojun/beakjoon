import sys

input = sys.stdin.readline

cmd = input().rstrip()
list = []
for i in range(1,len(cmd)+1):
    list.append(cmd[len(cmd)-i:len(cmd)])
list.sort()

for i in range(len(list)):
    print(list[i])
