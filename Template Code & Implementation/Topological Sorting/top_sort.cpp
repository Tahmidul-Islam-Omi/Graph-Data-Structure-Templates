#include <bits/stdc++.h>

using namespace std;

vector < vector<int> > v1(6);
int visited[6];
stack<int>st;
void dfs(int root) {
    visited[root] = 1;

    for(auto child: v1[root]) {
        if(visited[child] == 0) {
            dfs(child);
        }
    }

    st.push(root);

}

int main()

{
    int n,m;
    cin >> n >> m;

    for(int i=1; i<=m; i++) {
        int u,v;
        cin >> u >> v;
        v1[u].push_back(v);

    }

    for(int i=1; i<=5; i++) {
        if (visited[i] != 1) {
            dfs(i);
        }
    }

    while ( !st.empty() )
    {
        int temp = st.top();
        st.pop();
        cout << temp << " ";
    }

}
