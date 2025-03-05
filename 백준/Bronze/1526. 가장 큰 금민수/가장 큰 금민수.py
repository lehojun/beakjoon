a = int(input())
result = 0
for i in range(a, 0, -1):
    num_list = list(map(int, str(i)))
    minsu = True

    for j in range(len(num_list)):
        if num_list[j] != 4 and num_list[j] != 7: 
            minsu = False
            break
    if minsu:
        result = i
        break

print(result)
