line = input()

for i in range(0, len(line)):
    # check if index out of bounds
    if line[i] == ':':
        if i + 1 < len(line) and line[i + 1] == ')':
            print(i)
        elif i + 2 < len(line) and line[i+ 1] == '-' and line[i + 2] == ')':
            print(i)
        else:
            continue
    elif line[i] == ';':
        if i + 1 < len(line) and line[i + 1] == ')':
            print(i)
        elif i + 2 < len(line) and line[i+ 1] == '-' and line[i + 2] == ')':
            print(i)
        else:
            continue
    else:
        continue
