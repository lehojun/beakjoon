a = int(input())
s_list = [input() for _ in range(a)]
length = len(s_list[0])
result = ''

for j in range(length):
    current_char = s_list[0][j]  
    for i in range(1, a):
        if s_list[i][j] != current_char:
            result += '?' 
            break
    else:
        result += current_char  
print(result)
