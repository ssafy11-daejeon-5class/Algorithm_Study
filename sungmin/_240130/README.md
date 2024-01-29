# 우울 안 개구리
### *양방향 그래프*를 사용해서 해결
인접리스트를 사용해서 2   ->1->3 친구관계를 관리하고
반복문을 통해 자신이 가장 강한지를 탐색했습니다.
주의할점은 자신과 같은 무게를 들수 있으면 자신이 강하지 않다는점 입니다

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
