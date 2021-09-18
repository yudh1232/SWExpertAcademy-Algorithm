import copy

# 상, 우, 하, 좌
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 전선 설치
def set_wire(core_number, connected_core, wire_length, wire):
    global max_connected
    global min_wire_length

    # 가지치기(남은 코어를 모두 연결해도 최대로 연결된 코어 수보다 작을 때)
    if core_count - core_number + connected_core < max_connected:
        return

    # 모든 코어를 다 체크했을 때
    if core_number == core_count:
        if connected_core > max_connected:
            max_connected = connected_core
            min_wire_length = wire_length
        elif connected_core == max_connected:
            min_wire_length = min(min_wire_length, wire_length)
        return

    # 가장자리에 있는 코어는 연결
    if cores[core_number][0] == 0 or cores[core_number][0] == n - 1 or cores[core_number][1] == 0 or cores[core_number][1] == n - 1:
        # 다음 코어 체크하러 감
        set_wire(core_number + 1, connected_core + 1, wire_length, wire)
    # 가장자리에 있지 않은 코어
    else:
        # 전선을 연결하지 않고 다음 코어 체크
        set_wire(core_number + 1, connected_core, wire_length, wire)
        # 상우하좌에 대해
        for d in range(4):
            temp = copy.deepcopy(wire)
            # 전선을 연결할 수 있는지 체크
            l = linear_check(cores[core_number][0], cores[core_number][1], d, temp)
            # 전선을 연결할 수 있으면 연결
            if l != None:
                # 다음 코어 체크
                set_wire(core_number + 1, connected_core + 1, wire_length + l, temp)

# 전선을 연결할 수 있는지 체크하는 함수
def linear_check(x, y, d, temp):
    wire_length = 0
    while True:
        nx = x + dx[d]
        ny = y + dy[d]
        # 가장자리에 도달했을 때
        if nx == 0 or nx == n - 1 or ny == 0 or ny == n - 1:
            # 그 자리에 코어가 있거나 전선이 있으면 전선 설치 실패
            if board[nx][ny] == 1 or temp[nx][ny] == 1:
                return None
            # 그 자리에 코어가 없고 전선이 없으면 전선 설치 성공
            else:
                temp[nx][ny] = 1
                wire_length += 1
                return wire_length
        # 가장자리가 아닐 때
        else:
            # 그 자리에 코어가 있거나 전선이 있으면 전선 설치 실패
            if board[nx][ny] == 1 or temp[nx][ny] == 1:
                return None
            # 그 자리에 코어가 없고 전선이 없으면 다음 칸을 살펴봄
            else:
                temp[nx][ny] = 1
                wire_length += 1
        # 다음 칸을 살펴보러 감
        x = nx
        y = ny

# 테스트 케이스 수를 입력받음
TC = int(input())

# 테스트 케이스 수 만큼 반복
for tc in range(1, TC + 1):
    # n을 입력받음
    n = int(input())
    
    # 보드판을 입력받음
    board = []
    for _ in range(n):
        board.append(list(map(int, input().split())))
    
    # 전선을 나타내는 리스트 생성
    wire = [[0] * n for _ in range(n)]

    # 코어의 좌표를 저장하는 리스트
    cores = []

    # 코어의 개수를 나타내는 변수
    core_count = 0

    # 코어의 정보를 저장함
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                cores.append((i, j))
                core_count += 1
    
    # 최대로 연결된 코어 수
    max_connected = 0

    # 코어를 최대로 연결했을 때 최소 전선 길이
    min_wire_length = int(1e9)

    # 전선 설치(재귀)
    set_wire(0, 0, 0, wire)

    # 결과 출력
    answer = min_wire_length
    print('#', tc, ' ', answer, sep = '')
