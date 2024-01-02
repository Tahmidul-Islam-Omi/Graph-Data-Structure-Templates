#include <bits/stdc++.h>

using namespace std;

vector < vector<int> > v1(10);
vector<int> visited(10);

void dfs(int root) {

    visited[root] = 1;

    for(auto x: v1[root]) {
        
        if(visited[x] == 0) {
            dfs(x);
        }

        else if(visited[x] == 1) {
            cout << "Yes" << endl;
            exit(0);
        }

        else if( visited[x] == 2){
            continue;
        }
    }

    visited[root] = 2;

    return;

}

int main()

{

    int m;
    cin >> m;

    for(int i=1; i<=m; i++) {

        int u,v;
        cin >> u >> v;

        v1[u].push_back(v);


    }

    int root = 1;

    dfs(root);
    cout << "No" << endl;

}
