#include<bits/stdc++.h>
using namespace std;

int main() {

    int n; 
    cin >> n;

    vector<int> adj[n + 1];

    int m; 
    cin >> m;

    for(int i = 1; i <= m; i++) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    queue<int> q;
    vector<int> vis(n + 1, 0); //queue te abar dhukabo ki na 

    int root = 1;
    q.push(root);
    vis[root] = 1;

    vector<int> parent(n + 1, 0);

    parent[root] = -1;
    /// q te already jara ache tader meaning hocche tader amra visit korsi but expand kori nai
    /// q te chilo bt popped hoye geche etar mane ki??? tara expanded 
    while(!q.empty()) {
        int temp = q.front();
        q.pop();
        /// now expand node temp
        for(auto x: adj[temp]) {
            if(vis[x] == 0) {
                vis[x] = vis[temp] + 1;
                parent[x] = temp;
                q.push(x);
            }
        }
    }

    for(int i = 1; i <= n; i++) cout << parent[i] << " ";

    for(int i = 1; i <= n; i++) {
        cout << "Distance from root of node " << i << ": " << vis[i] - 1 << "\n";
    }
    
    cout << "\n";
}

