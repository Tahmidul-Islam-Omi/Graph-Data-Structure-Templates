#include<bits/stdc++.h>
using namespace std;

vector<int> adj[1001];
vector<int> vis;

void dfs(int root) {

    cout << root << " ";

    for(auto x: adj[root]) {
        if(vis[x] == 0) {
            vis[x] = 1;
            dfs(x);
        }
    }
    
    return;
}
 
 
int main() {
    int n; 
    cin >> n;

    vis.assign(n + 1, 0);

    int m; cin >> m;

    for(int i = 1; i <= m; i++) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vis[1] = 1;
    dfs(1);
    return 0;   
 
}
