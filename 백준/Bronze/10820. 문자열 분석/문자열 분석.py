import sys

while True:
    try:

        cmd = input()
        lower = 0
        upper = 0
        blank = 0
        number = 0
        for i in range(len(cmd)):
            if cmd[i].isupper() == True:
                upper += 1
            elif cmd[i].islower() == True:
                lower += 1
            elif cmd[i] == ' ':
                blank += 1
            else:
                number += 1
        print(lower , upper,  number, blank)
    except EOFError:
        break
    