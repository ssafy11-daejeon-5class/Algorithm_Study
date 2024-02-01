#include <bits/stdc++.h>
using namespace std;
vector<pair<int,int>> arr;

bool compare(pair<int, int> a, pair<int, int> b)
{
	return a.first > b.first;
}
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
	cin.tie(0);
	int w, n;
	cin >> w >> n;
	for (int i = 0; i < n; i++)
	{
		int m, p;
		cin >> m >> p;
		arr.push_back({ p,m });
	}
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
	cout << totalprice << "\n";
   return 0;
}