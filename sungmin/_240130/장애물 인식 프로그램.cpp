#include <bits/stdc++.h>
using namespace std;

string board[26];
int visited[26][26] = { 0, };
int n;
queue<pair<int, int>> q;
vector<int> res;
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int bfs(int x,int y,int count)
{
	q.push({ x,y });
	visited[x][y] = 1;
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
	return count;
}
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> board[i];
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (board[i][j] == '1' && visited[i][j]==0)
			{
				res.push_back(bfs(i, j, 1));
			}
		}
	}
	sort(res.begin(), res.end());
    cout << res.size() << "\n";
	for (auto i : res)
	{
		cout << i << "\n";
	}
	return 0;
}