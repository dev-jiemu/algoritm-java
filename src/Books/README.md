### 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편
##### https://ebook-product.kyobobook.co.kr/dig/epd/ebook/E000005185680



1. 2차원 배열
- [별 만들기:문제](https://school.programmers.co.kr/learn/courses/30/lessons/87377)

2. 문자열
- [자연수 뒤집어 배열로 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12932)

3. 재귀
```
재귀 호출은 반복 작업을 구현하는 것이라서, 시간 복잡도와 직접적으로 연결됨.
재귀 호출을 하면 호출된 메서드에서 사용할 변수들은 메모리에 추가할당됨. 중간에 종료하지 않고 깊게 들어가면 StackOverFlowError 발생함
따라서, 10000이하 ~ 20000 이하의 재귀를 유지하는게 안전함.
```
- [쿼드압축 후 개수 세기](https://school.programmers.co.kr/learn/courses/30/lessons/68936)

4. 완전탐색
```
완전 탐색: 문제에서 제시하는 모든 경우를 확인하면서 정답을 찾음
1. 간단히 구현되는 완전탐색
2. 깊이 우선 탐색(Depth First Search : DFS) -- 재귀로 구현 가능
3. 너비 우선 탐색(Breadth First Search : BFS)

완전 탐색의 시간 복잡도는 탐색해야 할 상태 개수, 즉 탐색 공간의 크기에 비례함
탐색 과정 중 이미 방문한 상태를 재방문하면 시간 복잡도는 기하급수적으로 증가하며, 실행 시간이 문제의 시간 제한을 넘어서게 됨.
```
- [수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257)