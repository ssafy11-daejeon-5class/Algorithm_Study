### 개미(BOJ10158)

- 규칙을 식으로 만들어내려고 시간을 너무 오래 쓴 느낌
- 입출력은 앞으로 스캐너 안쓰는 것이 좋겠다.

```java
/*
*
* 어떤 자연수를 8로 나눈 나머지의 범위는 0~7이다.
* (어떤 자연수를 8로 나눈 나머지)에서 3을 뺀 수의 범위는 -3 ~ 4다.
* -3, -2, -1, 0, 1, 2, 3, 4, -3, -2 ...
* 여기에 절댓값을 취할 수 있다.
* 3 2 1 0 1 2 3 4 3 2 ...
* 이 수열은 너비(w)가 4인 격자에서 개미의 x좌표의 규칙과 같다.
*/

Math.abs((w - 1 + p + T) % (w * 2) - (w - 1))
Math.abs((h - 1 + q + T) % (h * 2) - (h - 1))

```



### 진기의 최고급 붕어빵(SWEA1860)

- 고객이 방문하는 시간을 리스트로 만들어 오름차순으로 정렬하고
- 붕어빵이 나오는 시간도 고객 리스트 크기만큼, 오름차순 되도록 만들고
- 두 리스트를 index 0부터 n까지 비교한다. 
- 붕어[i]가 고객[i]보다 크다면 그 고객이 왔을 때 붕어빵은 아직 안나왔다는 뜻


```java            
 
            List<Integer> customers;
            for (int n = 0; n < N; n++) {
                customers.add(Integer.parseInt(st.nextToken()));
            }
            customers.sort(null);
            
            List<Integer> boongs;
            int m = M;
            while (boongs.size() < N) {
                for (int k = 0; k < K; k++) {
                    boongs.add(m);
                }
                m += M;
            }
            
            String result = "Possible";
            for (int n = 0; n < N; n++) {
                if (boongs.get(n) > customers.get(n))
                    result = "Impossible";
            }
```