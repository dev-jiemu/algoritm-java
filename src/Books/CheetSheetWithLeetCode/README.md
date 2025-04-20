### 코딩 인터뷰를 위한 알고리즘 치트시트 (with leetcode)
##### https://product.kyobobook.co.kr/detail/S000061898577

1. 동적 프로그래밍
- 피보나치 수열 (https://leetcode.com/problems/fibonacci-number/description/)
- 동전 계산하기 (https://leetcode.com/problems/coin-change/description/)

2. 역추적 알고리즘
```markdown
역추적 알고리즘의 프레임
1. 경로: 이미 만들어진 선택
2. 선택 리스트: 현재 할 수 있는 선택
3. 종료 조건: 의사 결정 트리 하부에 도달하여 더 이상 선택할 수 없는 조건
```
```markdown
// 재귀처리
result = []

def backtrack(경로, 선택 리스트):
    if 종료 조건 만족:
        result.add(경로)
        return
    for 선택 in 선택 리스트:
        선택하기
        backtrack(경로, 선택리스트)
        선택해제
```
- N퀸 문제 (https://leetcode.com/problems/n-queens/description/)