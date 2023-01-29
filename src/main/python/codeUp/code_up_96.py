d = []
d.append([])
for i in range(1, 20):
    temp = input().split()
    temp.insert(0, '-1')
    d.append(temp)
n = int(input())
for i in range(n):
    x, y = input().split()
    x = int(x)
    y = int(y)
    for j in range(1, 20):
        if(d[x][j] == '0'): d[x][j] = '1'
        else: d[x][j] = '0'
        if(d[j][y] == '0'): d[j][y] = '1'
        else: d[j][y] = '0'
for i in range(1, 20):
    for j in range(1, 20):
        print(d[i][j], end=' ')
    print()