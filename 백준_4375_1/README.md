## 백준 4375 1

--- 
(https://www.acmicpc.net/problem/4375)

### 사용 알고리즘 : 정수론

- 제약조건 : 1, 11, 111로 계속 늘어나다보면 나머지 연산을 할 수 있는 int형의 범위를 넘어가기 때문에 정수론을 이용해야함
- 정수의 나머지 연산에서는 *, +의 교환법칙, 분배법칙이 모두 성립하기 때문에 1, 11, 111 계속 늘어나는 과정에서 항상 n으로 나머지 연산을 한 후 계산해주면 최대 수는 n으로 줄게되어 int의 최대값을 넘어가지 않고 해결할 수 있음. 