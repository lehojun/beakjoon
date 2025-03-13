import sys
from collections import deque

input = sys.stdin.readline
x = int(input())
dq = deque()


def p(queue):
  if len(queue):
    print(queue.popleft())
  else:
    print('-1')


def e(queue):
  if len(queue):
    print('0')
  else:
    print('1')


def f(queue):
  if len(queue):
    print(queue[0])
  else:
    print('-1')


def b(queue):
  if len(queue):
    print(queue[-1])
  else:
    print('-1')


for _ in range(x):
  command = input().rstrip()

  if command == "pop":
    p(dq)
  elif command == "size":
    print(len(dq))
  elif command == "empty":
    e(dq)
  elif command == "front":
    f(dq)
  elif command == "back":
    b(dq)
  else:
    command = int(command[5:])
    dq.append(command)
