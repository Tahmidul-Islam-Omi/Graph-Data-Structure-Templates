
#include <bits/stdc++.h>

using namespace std;

vector < vector<int> > v1(20);
vector < vector<int> > rev(20);

int visited[20];
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

vector<int> component;

void rev_dfs(int root) {

    component.push_back(root);
    visited[root] = 1;

    for(auto child: rev[root]) {
        if(visited[child] == 0) {
            rev_dfs(child);
        }
    }

}

int main()

{
    int n,m;
    cin >> n >> m;

    for(int i=1; i<=m; i++) {
        int u,v;
        cin >> u >> v;
        v1[u].push_back(v);
        rev[v].push_back(u);

    }

    for(int i=1; i<=8; i++) {
        if (visited[i] != 1) {
            dfs(i);
        }
    }

    memset(visited , 0 , sizeof(visited));

    while ( !st.empty() )
    {
        int temp = st.top();
        st.pop();

        if(visited[temp]==0) {
            component.clear();

            rev_dfs(temp);

            for(int i=0; i<component.size(); i++) {
                cout << component[i] << " ";
            }
            cout << endl;
        }

    }
    
}

