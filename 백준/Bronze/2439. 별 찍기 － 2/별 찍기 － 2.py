a = int(input())
star = ""
result = ""
for i in range(1,a+1):
    star=" " * (a-i)
    star+= "*" * i
    print(star)