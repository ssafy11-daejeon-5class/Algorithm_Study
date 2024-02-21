# 말이 되고픈 원숭이
- 삼차원 방문배열을 알고나서 풀어서 미친듯이 어렵지는 않았던 문제
- 사실 처음봤으면 엄청 당황했을듯 ... 처음보는 문제 유형 접하기 위해 많은 문제를 풀어보자!


# 월드컵
- 백트래킹, 재귀 연습하기에 좋은 문제였다고 생각됨!
- 꽤나 재미있는 문제였던 걸로 기억함
- 로직은 근데 꽤나 단순
```java
private static void valid(int depth) {
  if (depth == 15) {
    boolean check = true;
    for (int i = 0; i < 6; i++) {
      if(results[i].win !=0 || results[i].lose !=0 || results[i].draw !=0) {
        check = false;
        break;
      }
    }
    if(check) {
      flag = true;
    }
    return;
  }
  int team1 = combi.get(depth)[0];
  int team2 = combi.get(depth)[1];
  if (results[team1].win - 1 >= 0 && results[team2].lose - 1 >= 0) {
    results[team1].win--;
    results[team2].lose--;
    valid(depth + 1);
    results[team1].win++;
    results[team2].lose++;
  }
  if (results[team1].lose - 1 >= 0 && results[team2].win - 1 >= 0) {
    results[team1].lose--;
    results[team2].win--;
    valid(depth + 1);
    results[team1].lose++;
    results[team2].win++;
  }
  if(results[team1].draw - 1 >=0 && results[team2].draw - 1 >= 0) {
    results[team1].draw--;
    results[team2].draw--;
    valid(depth + 1);
    results[team1].draw++;
    results[team2].draw++;
  }
}
```
- 근데 혹시 이런식말고 다르게 푼사람 있나?
  
# 프로세서 연결하기
- 백트래킹에 구현을 곁들인 문제
- 개인적인 생각인데 A형 시험은 이런 유형일 것 같다는 생각이 많이 들었음
- 최근들어 이런 유형을 많이 풀리는거 보면 진짜 그런거 같기도? ㅋㅋ
- 원래는 조합을 먼저 구한 다음에 백트래킹 하려고 했는데 이 문제는 코어 하나 고른다음 곧장 재귀호출하는 것이 맞는듯!
- 구현 해야하는 내용은 우선
1. 백트래킹 해야하는 커다란 재귀함수 -> 현재 코어의 네방향 전선 연결을 진행한다.
1. 해당 방향으로 현재 코어의 전선을 연결할 수 있는지 확인!
1. 백트래킹으로 돌아오면 다시 코어의 전선을 지워줘야 한다.

### 전선 연결하는 방법 -> 감시때도 썼다.
- 파라미터에 num으로 체크하고 다시 되돌리기 할 수 있음. 그러면 입력상태 static으로 쓸 수 있음.
```java
private static void check(int direction, int index, int num) { // 체크할 방향, 프로세서 index, 변경할 숫자
  int curi = cores.get(index).i;
  int curj = cores.get(index).j;

  for (int k = 1; k < N; k++) {
    curi = curi + di[direction];
    curj = curj + dj[direction];
    if (curi >= 0 && curi < N && curj >= 0 && curj < N) {
      maps[curi][curj] = num;
      addNum++;
    } else {
      break;
    }
  }
}
```
