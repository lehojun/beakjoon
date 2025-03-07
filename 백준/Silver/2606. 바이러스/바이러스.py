from collections import deque

x = int(input()) 
y = int(input())
graph = [[] for i in range(x+1)] #리스트 초기화, 0번 컴퓨터는 없으므로 x+1개 생성
visited = [0]*(x+1)
result = 0
for i in range(y):
  a, b = map(int, input().split())
  graph[a] += [b]
  graph[b] += [a]
# 인접 리스트 생성 완료됨

def dfs(v):
  visited[v] = True
  for i in graph[v]:
    if not visited[i]:
      dfs(i)


dfs(1)
print(sum(visited)-1)