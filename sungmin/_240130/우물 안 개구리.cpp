#include <bits/stdc++.h>
using namespace std;
int weight[100001]={0,};
vector<int>graph[100001];
int res=0;
int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
	cin.tie(0);
    int n,m;
    cin>>n>>m;
    for(int i=1;i<=n;i++)
    {
        cin>>weight[i];
    }
    for(int i=0;i<m;i++)
    {
        int start,end;
        cin>>start>>end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }
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
    cout<<res<<"\n";
    return 0;
}