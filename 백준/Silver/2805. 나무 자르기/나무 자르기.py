def Count(high):
    cnt = 0
    for x in li:
        if (x-high) < 0:
            continue
        else:
            cnt+=(x-high)
    return cnt

n, m = map(int, input().split())
li = list(map(int, input().split()))
largest = max(li)
res = 0

lt = 1
rt = largest

while lt <= rt:
    mid = (lt+rt) //2
    if Count(mid) >= m:
        res = mid
        lt = mid+1
    else:
        rt = mid -1
print(res)
    