# algoritm-java
java로 공부하는 알고리즘

<br>
<br>

### 2023.06.18 algoritm-java

1. Generic
- 대문자 1개 사용 (가급적 소문자는 사용 안함)
- 자료형 : E (element)
- key : value 형을 표시하고 싶다면 K, V
- 그 외 일반 자료형 T

<br>

2. Stack
- LIFO : 나중에 넣은 데이터가 먼저 나옴
- java main method가 예시임(main 함수가 가장 나중에 실행됨) 

<br>

### 2023.06.25 algoritm-java
3. Queue
- FIFO : 먼저 넣은 데이터가 먼저 나옴
- 배열구조로 큐를 구현하면 : en-queue - O(1), de-queue - O(n)
- 링버퍼 형태로 구현한다면 de-queue도 시간복잡도 O(1)로 처리 가능

<br>

### 2023.07.02 algoritm-java
4. 재귀(Recuision)
- 자기 자신과 동일한 메서드를 호출하는 경우 : 직접재귀
- 메서드 a가 b를 호출, b가 a를 호출하는 경우 : 간접재귀