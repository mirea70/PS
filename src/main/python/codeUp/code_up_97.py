h, w = input().split()
h = int(h)
w = int(w)
n = int(input())
# 격자판 초기화
map = [[0]*(w+1) for _ in range(h+1)]
# 막대 그려내기
for i in range(n):
    l, d, y, x = input().split()
    l = int(l)
    d = int(d)
    y = int(y)
    x = int(x)
    for j in range(l):
        if(d == 0):
            map[y][x + j] = 1
        else:
            map[y + j][x] = 1
# 격차판 출력
for i in range(1, h + 1):
    for j in range(1, w + 1):
        print(map[i][j], end=' ')
    print()