# Algori

## 목차
- [백준_12865_평범한_배낭](#백준-12865-평범한-배낭)
- [백준_1655_가운데를_말해요](#백준-1655-가운데를-말해요)

---

## 백준 12865 평범한 배낭
### 사용 알고리즘 : DP
#### 가장 기본적인 배낭문제를 풀기 위해서 부분집합을 이용해 물건을 선택해서 배낭에 집어넣고 무게제한과 최대 가치를 구할 수 있지만 이 문제의 물건 개수는 100개여서 부분집합으로 풀게되면 2^100의 시간복잡도가 걸려서 시간 초과가 되기 때문에 DP로 풀어야함.
- DP로 풀게되면 생기는 제약조건
  - 최대 가치가 100,000이고 메모리 제한이 256MB여서 1차원 배열 100,000개 만들어도 괜찮음.
  - 최대 배열 100,000개에 최대 물건 개수 100개여서 반복횟수 100,000 * 100 해도 10,000,000 대략 0.1초여서 시간복잡도도 괜찮음.
- 문제풀이
  - 물건의 개수 N, 최대 무게 K를 입력받는다.
  - N번 반복하며 물건의 무게 W, 가치 V를 각각 배열을 만들어서 입력받는다.
  - 배낭에 물건을 담는 것을 표현할 K만큼의 배열을 만들어서 가방에 물건을 집어넣는 것을 Mamoization 하는 느낌으로 사용.
  - 물건의 개수만큼 반복하면서 배낭에 물건을 담으려 할 때 물건을 담는게 그 무게에서 만들 수 있는 최대 가치를 업데이트해줌
    - 배낭에 물건을 담으면 그 무게만큼 추가되니까 "무게를 더한 부분의 배낭에 원래 저장된 값"과 "무게를 추가하기 전의 무게 부분의 가치에서 물건의 가치를 더한 가치"를 비교
    - 비교할 배낭의 무게가 10, 담으려 하는 물건의 무게가 5면 배낭[10]의 위치의 값과 배낭[5(10-5)] + 물건의 가치와 비교를 해서 최대값을 배낭[10]에 저장
    - 위의 과정을 물건을 담을 수 있는 모든 무게에서 실행 -> 배낭에 모든 무게(인덱스)마다 담을 수 있는 최대 가치가 저장되게됨.
    - 배열의 앞 인덱스부터 하면 계속 비교하면서 바뀐 값을 비교하게 될 수 있으니 뒤 인덱스(최대무게부분)부터 실행!
  - 마지막으로 배열의 K번째 인덱스 즉 가방에 담을 수 있는 최대 무게 부분에 저장된 값을 출력하면 그게 답이 됨!

---

## 백준 1655 가운데를 말해요 (https://www.acmicpc.net/problem/1655)
### 사용 알고리즘 : PriorityQueue
#### 평범하게 중간값을 구하기 위해 한개 입력받고 정렬시키고 가운데 인덱스 출력하는 방식으로 하게되면 시간제한이 0.1초여서 시간 초과가 나서 다른 방법으로 풀어야함!
- 정수의 개수 N을 입력받는다.
- 중간값을 기준으로 작은 숫자들은 내림차순 정렬해놓기 위한 내림차순 PriorityQueue 생성 맨 앞에 숫자가 가장 큰 수! 다음 중간값 후보!
- 중간값을 기준으로 큰 숫자들은 오름차순 정렬해놓기 위한 오름차순 PriorityQueue 생성 맨 앞에 숫자가 가장 작은 수! 다음 중간값 후보!
- 처음 입력받는 수는 중간값이기 때문에 첫 수는 mid로 정하고 2번째 정수부터 for문으로 돌림! for문 돌릴떄는 개수를 세기 때문에 2~N까지!
- 정수의 개수가 짝수일때는 중간 2개중 더 작은 값으로 한다.
  - 원래 홀수개였다가 정수가 추가돼서 짝수가 되는 것이니 기존 중간값의 위치를 생각해야함!
  - 입력받은 정수가 중간값보다 크거나 같을 때
    - 기존 중간값이 여전히 중간값이기 때문에 중간값은 유지
    - 중간값보다 크니까 오름차순 PriorityQueue에 입력받은 정수 추가
  - 입력받은 정수가 중간값보다 작을 때
    - 중간값이 지금 중간값보다 한 단계 작은 수로 바뀌어야함
    - 기존 중간값이 더 크니까 오름차순 PriorityQueue에 중간값을 넣어줌
    - 입력받은 정수가 더 작은 값이니까 내림차순 PriorityQueue에 입력받은 정수를 넣어줌
    - 기존 중간값보다 한 단계 작은 수가 중간값이니까 작은 수들을 내림차순 정렬시켜놓은 PriorityQueue에서 하나 뽑음! 그러면 작은수들 중 제일 큰 수가 나와서 한 단계 작은 수임!
- 정수의 개수가 홀수일때는 중간에 있는 값이 중간값!
  - 원래 짝수개였다가 정수가 추가돼서 홀수가 되는 것이니 기존 중간값의 위치를 생각해야함!
  - 입력받은 정수가 중간값보다 클 때
    - 기존 중간값보다 한 단계 큰 수가 중간값이 됨
    - 기존 중간값이 작으니까 내림차순 PriorityQueue에 기존 중간값을 넣어줌
    - 입력받은 정수가 더 큰 값이니까 오름차순 PriorityQueue에 입력받은 정수를 넣어줌
    - 한 단계 큰 수를 중간값으로 뽑아야 하니 큰 수들을 넣어둔 오름차순 PriorityQueue에서 하나 뽑음! 그러면 큰 수들 중 제일 작은 수가 나와서 한 단계 큰 수가 뽑혀나옴!
  - 입력받은 정수가 중간값보다 작거나 같을 때
    - 기존 중간값이 여전히 중간값이기 때문에 중간값은 유지
    - 입력받은 정수가 작거나 같으니까 중간값보다 작은 수들을 모아놓는 내림차순 PriorityQueue에 입력받은 정수를 넣어줌

---

