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

<br>

### 2023.08.13 algoritm-java
5. 우선순위 큐(Priority Queue)
- FIFO 구조이긴....한데 우선순위를 정하고 내보냄
- 필수적으로 Comparable Interface 구현되어야 함
- 시간 복잡도는 O(NLogN)
- Ref. https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90

6. Heap
- 부모값이 자식값보다 항상 큼을 만족하는 완전이진트리
- 가장 큰값이 root에 있음
- 시간 복잡도는 O(NLogN)


<br>

### 2023.08.19 algoritm-java
6. Heap : 도수정렬(counting sort)
- 도수 : 분포도수를 의미함
- 값을 비교하는 작업 필요없이 정렬함
- 도수분포표 만들기 -> 누적 도수분포표 만들기 -> 목표배열 만들기 -> 배열복사하기

ex) 10점 만점의 테스트에서 학생 9명의 점수를 가지고 도수정렬을 시행할 때

도수분포표 만들기
- 한 배열에 각자의 값을 몇개 가지고 있는지 작성함
```java
//int[] a = 학생들의 점수를 가지고 있는 배열
//int[] f = 도수분포도를 작성할 배열
for(int i = 0; i < n; i++){
    f[a[i]]++;    
} 
```
누적도수분포표 만들기
- 각 배열 값에 값이 총 얼마인지(0점부터 n점까지의 몇명의 학생이 있는지) 작성함
```java
//f[4]의 값은 0~4점을 받은 학생의 총 명수, f[10]의 값은 0~10점을 받은 학생의 총 명수
//특이점이 있다면 누적도수분포도 배열은 1번 인덱스서부터 시작함
for (int i = 1; i <= max; i++) {
    f[i] += f[i - 1];
}
```

목표 배열 만들기
```java
//중복처리의 방지를 위해 f 배열을 감소시킴
for (int i = n - 1; i >= 0; i--) {
    b[--f[a[i]]] = a[i];
}
```

배열 복사하기
```java
for (int i = 0; i < n; i ++) {
    a[i] = b[i];
}
```