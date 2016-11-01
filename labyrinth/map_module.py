def mapgenerate():
    size = int(input("Input size: "))

    matrix = size*[size*["*"]]

    return matrix

def mprint(matrix):
    size = len(matrix)

    for i in range(size):
        for j in range(size):
            print(matrix[i][j], end = " ")
        print("")
