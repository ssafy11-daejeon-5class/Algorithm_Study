# 우울 안 개구리
### *양방향 그래프*를 사용해서 해결
인접리스트를 사용해서 2   ->1->3 친구관계를 관리하고 <br/>
반복문을 통해 자신이 가장 강한지를 탐색했습니다. <br/>
주의할점은 자신과 같은 무게를 들수 있으면 자신이 강하지 않다는점 입니다 <br/>

### 인접 리스트 생성
```
graph[start].push_back(end);
graph[end].push_back(start);
```

### 탐색
```
for(int i=1;i<=n;i++)
    {
        int mx=weight[i];
        int check=0;
        for(int j=0;j<graph[i].size();j++)
        {
            if(weight[graph[i][j]]>=mx)
            {
                check=1;
                break;
            }
        }
        if(!check)res++;
    }
```

# 금고털이

### 그리디 알고리즘으로 해결
금속을 자를수 있다면 가격/무게 : 무게당 가격이 가장 높은 물건부터 담는것이 가방을 가장 값비싸게 채울수 있다. <br/>
<code><무게,무게당가격></code>으로 변수를 관리하고  <br/>
무게당가격을 기준으로 내림차순으로 정렬해 가방에 먼저 채울수 있도록 풀이 <br/>

### 탐색
```
sort(arr.begin(), arr.end(), compare);
	long totalprice = 0;
	for (int i = 0; i < n; i++)
	{
		if (arr[i].second < w)
		{
			totalprice += arr[i].first*arr[i].second;
			w = w - arr[i].second;
		}
		else
		{
			totalprice += arr[i].first*w;
			break;
		}
	}
```

# 장애물 인식 프로그램
### Queue를 사용해 BFS로 문제 해결
시작점이 여러개인 BFS 문제 <br/>
장애물 블록수 : 반복문을 돌며 BFS탐색이 시작했을때를 카운트 <br/>
각 블록의 장애물 수 : BFS로 탐색하는 블록의 수를 카운트 <br/>
BFS를 탐색할때 방문했던 블록은 다시 방문하지 않도록 방문처리를 해줘야함(vistied 배열 사용) <br/>

### 탐색
```
while (!q.empty())
	{
		int curx = q.front().first;
		int cury = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = curx + dx[i];
			int ny = cury + dy[i];
			if (nx >= n | nx < 0 || ny >= n || ny < 0)continue;
			if (visited[nx][ny] || board[nx][ny] == '0')continue;
			q.push({ nx,ny });
			visited[nx][ny] = 1;
			count++;
		}
	}
```
