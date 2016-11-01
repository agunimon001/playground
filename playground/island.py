i = a = 0
matrix = [['0']]

while a != '-1':
    if a != 0:
        matrix.append(['0'] + list(a) + ['0'])
    a = input('input row[{}]: '.format(i))
    i += 1

matrix[0] = ['0'] * len(matrix[1])
matrix.append(['0'] * len(matrix[1]))

"""-------------------------------------------------------------"""

flag = False

for i in range(len(matrix)):
    for j in range(len(matrix[i])):
        if matrix[i][j] == '1':
            flag = True
            break
    if flag:
        break

ref_i = i
ref_j = j

perimeter = 1

# N = 0, E = 1, S = 2, W = 3
direction = 1

while True:
    check_Matrix = []
    for k in range(3):  # Check left and front
        check = (direction + k - 1) % 4

        if check == 0:      # Check-N
            check_Matrix.append(matrix[i-1][j])
        elif check == 1:    # Check-E
            check_Matrix.append(matrix[i][j+1])
        elif check == 2:    # Check-S
            check_Matrix.append(matrix[i+1][j])
        else:               # Check-W
            check_Matrix.append(matrix[i][j-1])

    if check_Matrix[0] == '1':      # [1 x x]
        direction = (direction - 1) % 4
    elif check_Matrix[1] == '0':
        if check_Matrix[2] == '1':  # [0 0 1]
            direction = (direction + 1) % 4
            perimeter += 2
        else:                       # [0 0 0]
            direction = (direction + 2) % 4
            perimeter += 3
    else:                           # [0 1 x]
        perimeter += 1

    if direction == 0:      # Move N
        i -= 1
    elif direction == 1:    # Move E
        j += 1
    elif direction == 2:    # Move S
        i += 1
    else:                   # Move W
        j -= 1

    if i == ref_i and j == ref_j and direction == 0:
        break

print('perimeter =', perimeter)
