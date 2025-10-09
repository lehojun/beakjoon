def Count(mid):
    cnt = 1
    sum = 0
    for i in range(len(li)-1):
        sum += li[i+1] - li[i]
        if sum >= mid:
            cnt += 1
            sum = 0
    return cnt


n, c = map(int, input().split())
li = []

for i in range(n):
    house = int(input())
    li.append(house)

li.sort()

lt = 1
rt = li[-1] - li[0]  
res = 0

while lt <= rt:
    mid = (lt+rt) // 2
    if Count(mid) >= c:
        res = mid
        lt = mid + 1
    else:
        rt = mid -1

print(res)