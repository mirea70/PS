import queue

q = queue.Queue()
# 우 이동
n_right = [1, 0]
# 아래 이동
n_down = [0, 1]
# 지도 그리기
map = []
map.append([])
for i in range(1,11):
    temp = input().split()
    temp.insert(0, '-1')
    map.append(temp)
# 이동 시작
# 큐에 2, 2 넣는다
q.put([2, 2])
# 큐 빌 때 까지 반복
while(q):
# 큐에서 값을 뺀다
    now = q.get()
# 현재 위치 2이면 9로 바꾸고 stop
    if(map[now[0]][now[1]] == '2'):
        map[now[0]][now[1]] = '9'
        break
# 현재 위치를 9로 바꾼다
    map[now[0]][now[1]] = '9'
# 오른 / 아래 이동 시도
    for i in range(2):
        n_d = [now[0] + n_down[i], now[1] + n_right[i]]
# 범위 벗어날 경우 pass
        if(n_d[0] > 10 or n_d[1] > 10): continue
# 해당 위치가 1일 경우 pass
        if(map[n_d[0]][n_d[1]] == '1'): continue
# 큐에 이동할 위치를 넣는다
        q.put(n_d)
        break
# 반복문 종료
# 지도 출력
for i in range(1, 11):
    for j in range(1, 11):
        print(map[i][j], end=' ')
    print()