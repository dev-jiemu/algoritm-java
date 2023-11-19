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