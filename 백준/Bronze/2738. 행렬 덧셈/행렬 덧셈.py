import sys

input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
result = [[0 for col in range(M)] for row in range(N)]

arrA = [list(map(int, input().rstrip().split())) for _ in range(N)]
arrB = [list(map(int, input().rstrip().split())) for _ in range(N)]

for i in range(N):
    for j in range(M):
        result[i][j] = arrA[i][j] + arrB[i][j]


for i in result:
    for j in i:
        print(j, end=' ')
    print()

