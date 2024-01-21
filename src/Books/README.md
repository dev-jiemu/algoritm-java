### 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편
##### https://ebook-product.kyobobook.co.kr/dig/epd/ebook/E000005185680



1. 2차원 배열
- [별 만들기:문제](https://school.programmers.co.kr/learn/courses/30/lessons/87377)

2. 문자열
- [자연수 뒤집어 배열로 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12932)
- [문자열 압축](https://school.programmers.co.kr/learn/courses/30/lessons/60057)
- [이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

3. 재귀
```
재귀 호출은 반복 작업을 구현하는 것이라서, 시간 복잡도와 직접적으로 연결됨.
재귀 호출을 하면 호출된 메서드에서 사용할 변수들은 메모리에 추가할당됨. 중간에 종료하지 않고 깊게 들어가면 StackOverFlowError 발생함
따라서, 10000이하 ~ 20000 이하의 재귀를 유지하는게 안전함.
```
- [쿼드압축 후 개수 세기](https://school.programmers.co.kr/learn/courses/30/lessons/68936)

4. 정렬하기
- [두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)

5. 이진탐색
```
찾고자 하는 정답이 포함된 범위 중 가운데를 검사함. 절반씩 뽀개서 계산하는게 포인트
따라서, 탐색 전 정렬이 반드시 필요함
```
- [입국심사](https://school.programmers.co.kr/learn/courses/30/lessons/43238)

6. 완전탐색
```
완전 탐색: 문제에서 제시하는 모든 경우를 확인하면서 정답을 찾음
1. 간단히 구현되는 완전탐색
2. 깊이 우선 탐색(Depth First Search : DFS) -- 재귀로 구현 가능
3. 너비 우선 탐색(Breadth First Search : BFS)

완전 탐색의 시간 복잡도는 탐색해야 할 상태 개수, 즉 탐색 공간의 크기에 비례함
탐색 과정 중 이미 방문한 상태를 재방문하면 시간 복잡도는 기하급수적으로 증가하며, 실행 시간이 문제의 시간 제한을 넘어서게 됨.
```
- [수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257)

7. 해시(Hash)
```
데이터에서 대표값을 추출하는 과정: Hash
충돌될 가능성이 있으므로 충돌을 최대한 일으키지 않는 해시함수를 정의하는게 중요
hashCode(), equals()
```
- [평행](https://school.programmers.co.kr/learn/courses/30/lessons/120875)
- [중복된 문자 제거](https://school.programmers.co.kr/learn/courses/30/lessons/120888)

8. 그래프, 트리
- [순위](https://school.programmers.co.kr/learn/courses/30/lessons/49191)
- [방의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/49190)
- [길 찾기 게임](https://school.programmers.co.kr/learn/courses/30/lessons/42892)

9. 동적 프로그래밍
```
동적 프로그래밍: 완전 탐색의 종류 중 하나
완전 탐색의 문제점: 중복 계산을 많이함
메모이제이션: 재귀로 처리할때 한번 풀었던 부분 문제에 대한 답을 저장해놓았다가, 해당 부분 문제를 다시 풀일이 있으면 재사용
```
```java
// 재귀가 아닌 순차누적으로 구현하는 메모이제이션도 존재함
private static long iterativeFibonacci(int n) {
    long[] mem = new long[n + 1];
    mem[0] = 0;
    mem[1] = 1;

    for (int i = 0; i <= n - 1; i++) {
        mem[i + 1] += mem[i];
        if (i + 2 < mem.length) mem[i + 2] += mem[i];
    }

    return mem[n];
}
```
- [피보나치 수](https://school.programmers.co.kr/learn/courses/30/lessons/12945)
- [정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)

10. 그리디 알고리즘
```
그리디 알고리즘: 탐색 중인 숫자와 목표 숫자의 차이를 이용해서 최선의 상태로 전이해나감.
최선의 상태로 전이하는게 독이 되는 경우도 있으므로 잘 생각해야함 ㅠ
```
- [큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)
- [단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884)